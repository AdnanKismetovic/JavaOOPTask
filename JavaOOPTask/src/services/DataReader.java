package services;

import models.Config;
import models.Product;
import exceptions.BaseException;

import java.util.List;

public interface DataReader {
    List<Product> readData(Config config) throws BaseException;
}
