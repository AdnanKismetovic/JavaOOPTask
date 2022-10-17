package services;

import models.Config;
import models.Product;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.BaseException;
import exceptions.ItemNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataAPIReader implements DataReader {
    private static final Logger logger = LoggerFactory.getLogger(DataAPIReader.class);

    @Override
    public List<Product> readData(Config config) throws BaseException {
        logger.info("Reading data from source: " + config.getSource());
        List<Product> products = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Map<?, ?>> map = mapper.readValue(new URL(config.getSource()), new TypeReference<>() {
            });
            for (Map<?, ?> element : map) {
                Product newProduct = new Product();
                String productID = element.get(config.getReadingProperties().productID).toString();
                String productName = element.get(config.getReadingProperties().productName).toString();
                String productPrice = element.get(config.getReadingProperties().productPrice).toString();
                if (productID == null || productName == null || productPrice == null)
                    throw new ItemNotFoundException("Some of reading properties might be null or cant be found", "Some of properties cannot be read or found in JSON file provided by API");
                newProduct.setId(Integer.parseInt(productID));
                newProduct.setName(productName);
                newProduct.setPrice(Double.parseDouble(productPrice));
                products.add(newProduct);
            }
        } catch (ItemNotFoundException ex) {
            logger.error(ex.getMessage());
        } catch (StreamReadException e) {
            throw new BaseException(e.getMessage());
        } catch (IOException e) {
            throw new BaseException(e.getMessage());
        }
        return products;
    }
}
