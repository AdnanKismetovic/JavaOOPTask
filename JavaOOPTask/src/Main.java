import Models.Config;
import Models.Product;
import Models.Result;
import Services.*;
import config.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.TreeMap;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        try {
            Config config = Configuration.load(logger);
            DataReader dataReader = DataReaderFactory.getDataReader(config.getReadType(), logger);
            List<Product> products = dataReader.readData(config, logger);
            TreeMap<Integer, Result> results = ResultsGenerator.generateResults(products, logger);
            DataWriter dataWriter = DataWriterFactory.getDataWriter(config.getWriteType(), logger);
            dataWriter.save(results, logger);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}