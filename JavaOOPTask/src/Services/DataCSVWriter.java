package Services;

import Models.Result;
import exceptions.ObjectCreationException;
import org.slf4j.Logger;

import java.io.*;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class DataCSVWriter implements DataWriter {
    @Override
    public void save(TreeMap<Integer, Result> results, Logger logger) throws ObjectCreationException {
        String filepath = java.util.UUID.randomUUID() + "results.csv";
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(filepath)))) {
            logger.info("File name: " + filepath);
            logger.info("File path: " + Paths.get("").toAbsolutePath() + filepath);
            printWriter.println("id, name, min, max, avg");
            for (Map.Entry<Integer, Result> r : results.entrySet()) {
                printWriter.println(r.getKey() + "," + r.getValue().toString());
            }
            printWriter.flush();
        } catch (IOException e) {
            throw new ObjectCreationException(e.getMessage(), "Error can occur during creation of FileWriter BufferedWriter or PrintWriter");
        }
    }
}
