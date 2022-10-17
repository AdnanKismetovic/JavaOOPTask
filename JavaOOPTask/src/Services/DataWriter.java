package Services;

import Models.Result;
import exceptions.ObjectCreationException;
import org.slf4j.Logger;

import java.util.TreeMap;

public interface DataWriter {
    void save(TreeMap<Integer, Result> results, Logger logger) throws ObjectCreationException;
}
