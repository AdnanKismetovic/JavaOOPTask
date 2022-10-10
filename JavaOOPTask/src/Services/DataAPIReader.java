package Services;

import Models.Config;
import Models.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataAPIReader implements DataReader{
    @Override
    public List<Product> readData(Config config, Logger logger) {
        logger.info("Reading data from source: " + config.getSource());
        List<Product> products = new ArrayList<Product>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Map<?, ?>> map = mapper.readValue(new URL(config.getSource()), new TypeReference<>() {
            });
            for (int i = 0; i < map.size(); i++) {
                Map<?, ?> element = map.get(i);
                Product newProduct = new Product();
                String productID = element.get(config.getReadingProperties().productID).toString();
                String productName = element.get(config.getReadingProperties().productName).toString();
                String productPrice = element.get(config.getReadingProperties().productPrice).toString();
                if(logger.isDebugEnabled()) {
                    logger.debug("Product ID:" + productID);
                    logger.debug("Product Name:" + productName);
                    logger.debug("Product Price:" + productPrice);
                }
                if (productID == null || productName == null || productPrice == null)
                    throw new Exception("Some of reading properties might be null");
                newProduct.setId(Integer.parseInt(productID));
                newProduct.setName(productName);
                newProduct.setPrice(Double.parseDouble(productPrice));
                products.add(newProduct);
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return products;
    }
}
