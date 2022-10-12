package Services;

import Models.Config;
import Models.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataJSONReader implements DataReader{
    @Override
    public List<Product> readData(Config config, Logger logger) {
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
                if (logger.isDebugEnabled()) {
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
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return products;
    }
}
