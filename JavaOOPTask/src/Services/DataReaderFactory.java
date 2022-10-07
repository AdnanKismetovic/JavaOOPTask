package Services;

import Enums.DataReadTypes;

public class DataReaderFactory {
    public static DataReader getDataReader(String type) {
        if (".json".equalsIgnoreCase(type)) return new DataJSONReader();
        else if ("api".equalsIgnoreCase(type)) return new DataAPIReader();
        return null;
    }
}
