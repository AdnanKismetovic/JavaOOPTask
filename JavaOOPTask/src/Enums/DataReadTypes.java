package Enums;

import Services.DataAPIReader;
import Services.DataJSONReader;
import Services.DataReader;

public enum DataReadTypes {
    API("api") {
        public DataReader execute() {
            return new DataAPIReader();
        }
    },
    JSON("json") {
        public DataReader execute() {
            return new DataJSONReader();
        }
    },
    URL("url") {
        public DataReader execute() {
            return new DataAPIReader();
        }
    };

    public final String label;

    DataReadTypes(String label) {
        this.label = label;
    }

    public abstract DataReader execute();
}
