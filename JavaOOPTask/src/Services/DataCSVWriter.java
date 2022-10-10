package Services;

import Models.Result;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class DataCSVWriter implements DataWriter{
    @Override
    public void save(TreeMap<Integer, Result> results) {
        PrintWriter printWriter = null;
        try {
            String filepath = java.util.UUID.randomUUID().toString() + "results.csv";
            File file = new File(filepath);
            if (file.createNewFile()) {
                System.out.println("New file created:" + file.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter fileWriter = new FileWriter(filepath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
            printWriter.println("id, name, min, max, avg");
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
