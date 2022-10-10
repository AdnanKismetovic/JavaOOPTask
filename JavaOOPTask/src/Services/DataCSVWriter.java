package Services;

import Models.Result;
import org.slf4j.Logger;

import java.io.*;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class DataCSVWriter implements DataWriter{
    @Override
    public void save(TreeMap<Integer, Result> results, Logger logger) {
        PrintWriter printWriter = null;
        try {
            logger.info("Writing results to file...");
            String filepath = java.util.UUID.randomUUID().toString() + "results.csv";
            logger.info("File name: " + filepath);
            logger.info("File path: " + Paths.get("").toAbsolutePath().toString());
            File file = new File(filepath);
            if (file.createNewFile()) {
                logger.info("File created.");
            } else {
                logger.error("File already exists.");
            }
            FileWriter fileWriter = new FileWriter(filepath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
            printWriter.println("id, name, min, max, avg");
            logger.info("Printing results...");
            for (Map.Entry<Integer, Result> r : results.entrySet()) {
                printWriter.println(r.getKey() + "," + r.getValue().toString());
            }
            printWriter.flush();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                printWriter.close();
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
}
