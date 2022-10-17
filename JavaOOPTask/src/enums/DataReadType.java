package enums;

import services.DataAPIReader;
import services.DataJSONReader;
import services.DataReader;

public enum DataReadType {
    API("api", new DataAPIReader()),
    JSON("json", new DataJSONReader()),
    URL("url", new DataAPIReader());

    public final String label;
    private final DataReader reader;

    DataReadType(String label, DataReader reader) {
        this.label = label;
        this.reader = reader;
    }

    public String getLabel() {
        return label;
    }

    public DataReader getReader() {
        return reader;
    }
}
