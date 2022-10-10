package Services;

import Enums.DataReadTypes;

public class DataReaderFactory {
    public static DataReader getDataReader(String type) {
        return DataReadTypes.valueOf(type).execute();
    }
}
