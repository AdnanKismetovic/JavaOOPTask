package Services;

import Models.Product;

import java.util.List;

public class StatisticsServiceImpl implements StatisticsService {
    @Override
    public double getAveragePriceForProduct(List<Product> products, int productId) {
        double sum = 0;
        int cnt = 0;
        for (Product product : products) {
            if (product.getId() == productId) {
                sum += product.getPrice();
                cnt++;
            }
        }
        return (double) (Math.round(sum / cnt) * 100) / 100;
    }

    @Override
    public double getMinPriceForProduct(List<Product> products, int productId) {
        double min = Double.MAX_VALUE;
        for (Product product : products) {
            double currentValue = product.getPrice();
            if (currentValue < min) {
                min = currentValue;
            }
        }
        return min;
    }

    @Override
    public double getMaxPriceForProduct(List<Product> products, int productId) {
        double max = Double.MIN_VALUE;
        for (Product product : products) {
            double currentValue = product.getPrice();
            if (currentValue > max) {
                max = currentValue;
            }
        }
        return max;
    }
}
