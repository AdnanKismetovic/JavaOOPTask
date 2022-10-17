package services;

import models.Config;
import models.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.BaseException;
import exceptions.ItemNotFoundException;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataJSONReader implements DataReader {

    @Override
    public List<Product> readData(Config config) throws BaseException {
        List<Product> products = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Map<?, ?>> map = mapper.readValue(new FileReader(config.getSource()), new TypeReference<>() {
            });
            for (Map<?, ?> element : map) {
                Product newProduct = new Product();
                String productID = element.get(config.getReadingProperties().productID).toString();
                String productName = element.get(config.getReadingProperties().productName).toString();
                String productPrice = element.get(config.getReadingProperties().productPrice).toString();
                if (productID == null || productName == null || productPrice == null)
                    throw new ItemNotFoundException("Some of reading properties might be null", "Check if names of properties in JSON file are the same as in config file.");
                newProduct.setId(Integer.parseInt(productID));
                newProduct.setName(productName);
                newProduct.setPrice(Double.parseDouble(productPrice));
                products.add(newProduct);
            }
        } catch (Exception ex) {
            throw new BaseException(ex.getMessage());
        }
        return products;
    }
}
