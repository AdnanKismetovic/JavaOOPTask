package Enums;

import Services.DataAPIReader;
import Services.DataJSONReader;
import Services.DataReader;

public enum DataReadType {
    API("api", new DataAPIReader()),
    JSON("json", new DataJSONReader()) ,
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
