package Services;

import Models.Product;

import java.util.List;

public interface StatisticsService {
    double getAveragePriceForProduct(List<Product> products, int productId);

    double getMinPriceForProduct(List<Product> products, int productId);

    double getMaxPriceForProduct(List<Product> products, int productId);
}
