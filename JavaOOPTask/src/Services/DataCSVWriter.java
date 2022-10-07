package Services;

import Models.Result;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class DataCSVWriter implements DataWriter{
    @Override
    public void save(TreeMap<Integer, Result> results) {
        PrintWriter pw = null;
        try {
            String filepath = java.util.UUID.randomUUID().toString() + "results.csv";
            File file = new File(filepath);
            if (file.createNewFile()) {
                System.out.println("New file created:" + file.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter fw = new FileWriter(filepath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.println("id, name, min, max, avg");
            for (Map.Entry<Integer, Result> r : results.entrySet()) {
                pw.println(r.getKey() + "," + r.getValue().toString());
            }
            pw.flush();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                pw.close();
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
}
