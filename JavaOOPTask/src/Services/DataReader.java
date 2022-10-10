package Services;

import Models.Config;
import Models.Product;
import org.slf4j.Logger;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface DataReader {
    public List<Product> readData(Config config, Logger logger) throws IOException, URISyntaxException;
}
