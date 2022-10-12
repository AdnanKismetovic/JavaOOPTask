package Services;

import Models.Product;
import Models.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.TreeMap;

public class ResultsGenerator {
    private static StatisticsService statisticsService = new StatisticsServiceImpl();
    private static final Logger logger = LoggerFactory.getLogger(ResultsGenerator.class);

    public static TreeMap<Integer, Result> generateResults(List<Product> products) {
        TreeMap<Integer, Result> results = new TreeMap<Integer, Result>();
        for (Product p : products) {
            if (!results.containsKey(p.getId())) {
                results.put(p.getId(), new Result(p.getName(), statisticsService.getMinPriceForProduct(products, p.getId()), statisticsService.getMaxPriceForProduct(products, p.getId()), statisticsService.getAveragePriceForProduct(products, p.getId())));
            }
        }
        return results;
    }
}
