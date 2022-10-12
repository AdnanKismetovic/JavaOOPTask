package Services;

import Models.Result;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.TreeMap;

public interface DataWriter {
    void save(TreeMap<Integer, Result> results, Logger logger) throws IOException;
}
