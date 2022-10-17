package services;

import models.Product;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class StatisticsServiceStreamsImpl implements StatisticsService {
    @Override
    public double getAveragePriceForProduct(List<Product> products, int productId) {
        double avgForProduct = products.stream()
                .filter(p -> p.getId() == productId)
                .collect(Collectors.averagingDouble(Product::getPrice));
        return avgForProduct;
    }

    @Override
    public double getMinPriceForProduct(List<Product> products, int productId) {
        Product minPriceProduct = products.stream()
                .filter(p -> p.getId() == productId)
                .min(Comparator.comparing(Product::getPrice)).get();
        return minPriceProduct.getPrice();
    }

    @Override
    public double getMaxPriceForProduct(List<Product> products, int productId) {
        Product maxPriceProduct = products.stream()
                .filter(p -> p.getId() == productId)
                .min(Comparator.comparing(Product::getPrice)).get();
        return maxPriceProduct.getPrice();
    }
}
