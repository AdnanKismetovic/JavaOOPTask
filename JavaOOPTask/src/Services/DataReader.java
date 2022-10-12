package Services;

import Models.Config;
import Models.Product;
import exceptions.BaseException;

import java.util.List;

public interface DataReader {
    List<Product> readData(Config config) throws BaseException;
}
