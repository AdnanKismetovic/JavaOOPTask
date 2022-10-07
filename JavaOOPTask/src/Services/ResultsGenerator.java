package Services;

import Models.Product;
import Models.Result;

import java.util.List;
import java.util.TreeMap;

public class ResultsGenerator {
    public static TreeMap<Integer, Result> results = new TreeMap<Integer, Result>();
    private static StatisticsService statisticsService = new StatisticsServiceImpl();
    public static void generateResults(List<Product> products) {
        for (Product p: products) {
            if (!results.containsKey(p.getId())) {
                results.put(p.getId(), new Result(p.getName(), statisticsService.getMinPriceForProduct(products, p.getId()), statisticsService.getMaxPriceForProduct(products, p.getId()), statisticsService.getAveragePriceForProduct(products, p.getId())));
            }
        }
    }
}
