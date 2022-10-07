package Services;

public class DataWriterFactory {
    public static DataWriter getDataWriter(String type) {
        if (".csv".equalsIgnoreCase(type)) return new DataCSVWriter();
        return null;
    }
}
