package Services;

import Models.Config;
import Models.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.Configuration;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataJSONReader implements DataReader{
    @Override
    public List<Product> readData(Config config) {
        List<Product> products = new ArrayList<Product>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Map<?, ?>> map = mapper.readValue(new FileReader(config.getSource()), new TypeReference<List<Map<?, ?>>>() {
            });
            for (int i = 0; i < map.size(); i++) {
                Map<?, ?> element = map.get(i);
                Product newProduct = new Product(Integer.parseInt(element.get(config.getReadingProperties().productID).toString()),
                        element.get(config.getReadingProperties().productName).toString(),
                        Double.parseDouble(element.get(config.getReadingProperties().productPrice).toString()));
                products.add(newProduct);
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return products;
    }
}
