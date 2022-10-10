package Enums;

import Services.DataCSVWriter;
import Services.DataWriter;

public enum DataSaveTypes {
    CSV("csv") {
        public DataWriter execute() {
            return new DataCSVWriter();
        }
    },
    TXT("txt") {
        public DataWriter execute() {
            return new DataCSVWriter();
        }
    };

    public final String label;
    DataSaveTypes(String label) {
        this.label = label;
    }
    public abstract DataWriter execute();
}
