package Services;

import Models.Product;

import java.util.List;

public interface StatisticsService {
    public Product getMinOverAll(List<Product> products);
    public Product getMaxOverAll(List<Product> products);
    public double getAvgOverAll(List<Product> products);
    public double getAveragePriceForProduct(List<Product> products, int productId);
    public double getMinPriceForProduct(List<Product> products, int productId);
    public double getMaxPriceForProduct(List<Product> products, int productId);

    public Product getClosestProductToAverage(List<Product> products, double averageValue);
}
