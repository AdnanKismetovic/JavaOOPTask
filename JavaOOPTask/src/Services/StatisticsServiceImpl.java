package Services;

import Models.Product;

import java.math.RoundingMode;
import java.util.List;

public class StatisticsServiceImpl implements StatisticsService {
    @Override
    public Product getMinOverAll(List<Product> products) {
        double min = Double.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            double currentValue = products.get(i).getPrice();
            if (currentValue < min) {
                min = currentValue;
                index = i;
            }
        }
        return products.get(index);
    }

    @Override
    public Product getMaxOverAll(List<Product> products) {
        double max = Double.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            double currentValue = products.get(i).getPrice();
            if (currentValue > max) {
                max = currentValue;
                index = i;
            }
        }
        return products.get(index);
    }

    @Override
    public double getAvgOverAll(List<Product> products) {
        double sum = 0;
        for (int i = 0; i < products.size(); i++) {
            sum += products.get(i).getPrice();
        }
        return (double)(Math.round(sum / products.size()) * 100) / 100;
    }

    @Override
    public double getAveragePriceForProduct(List<Product> products, int productId) {
        double sum = 0;
        int cnt = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == productId) {
                sum += products.get(i).getPrice();
                cnt++;
            }
        }
        return (double)(Math.round(sum / cnt) * 100) / 100;
    }

    @Override
    public double getMinPriceForProduct(List<Product> products, int productId) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < products.size(); i++) {
            double currentValue = products.get(i).getPrice();
            if (currentValue < min) {
                min = currentValue;
            }
        }
        return min;
    }

    @Override
    public double getMaxPriceForProduct(List<Product> products, int productId) {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < products.size(); i++) {
            double currentValue = products.get(i).getPrice();
            if (currentValue > max) {
                max = currentValue;
            }
        }
        return max;
    }

    @Override
    public Product getClosestProductToAverage(List<Product> products, double averageValue) {
        int index = -1;
        double minDiff = Double.MAX_VALUE;
        for (int i = 0; i < products.size(); i++) {
            if (Math.abs(products.get(i).getPrice() - averageValue) < minDiff) {
                index = i;
            }
        }
        return products.get(index);
    }
}
