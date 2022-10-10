import Models.Config;
import Models.Product;
import Models.Result;
import Services.*;
import config.Configuration;

import java.util.List;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        try {
            Config config = Configuration.load();
            DataReader dataReader = DataReaderFactory.getDataReader(config.getReadType());
            List<Product> products = dataReader.readData(config);
            TreeMap<Integer, Result> results = ResultsGenerator.generateResults(products);
            DataWriter dataWriter = DataWriterFactory.getDataWriter(config.getWriteType());
            dataWriter.save(results);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}