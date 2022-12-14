import models.Config;
import models.Product;
import models.Result;
import services.*;
import config.Configuration;
import exceptions.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.TreeMap;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            Config config = Configuration.load();
            DataReader dataReader = DataReaderFactory.getDataReader(config.getReadType());
            List<Product> products = dataReader.readData(config);
            TreeMap<Integer, Result> results = ResultsGenerator.generateResults(products);
            DataWriter dataWriter = DataWriterFactory.getDataWriter(config.getWriteType());
            dataWriter.save(results, logger);
        } catch (BaseException ex) {
            logger.error(ex.getMessage());
        }
    }
}