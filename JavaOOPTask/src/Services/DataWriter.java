package Services;

import Models.Result;

import java.io.IOException;
import java.util.TreeMap;

public interface DataWriter {
    void save(TreeMap<Integer, Result> results) throws IOException;
}
