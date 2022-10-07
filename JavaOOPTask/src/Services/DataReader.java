package Services;

import Models.Product;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface DataReader {
    public List<Product> readData() throws IOException, URISyntaxException;
}
