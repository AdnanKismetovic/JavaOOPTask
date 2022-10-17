package enums;

import services.DataCSVWriter;
import services.DataWriter;

public enum DataSaveType {
    CSV("csv", new DataCSVWriter()),
    TXT("txt", new DataCSVWriter());

    private final String label;
    private final DataWriter writer;

    DataSaveType(String label, DataWriter writer) {
        this.label = label;
        this.writer = writer;
    }

    public String getLabel() {
        return label;
    }

    public DataWriter getWriter() {
        return writer;
    }

}
