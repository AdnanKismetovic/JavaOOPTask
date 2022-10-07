import Models.Product;
import Services.*;
import config.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Configuration.load();
            DataReader dr = DataReaderFactory.getDataReader(Configuration.config.getReadType());
            List<Product> products = dr.readData();
            ResultsGenerator.generateResults(products);
            DataWriter dw = DataWriterFactory.getDataWriter(Configuration.config.getWriteType());
            dw.save(ResultsGenerator.results);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}