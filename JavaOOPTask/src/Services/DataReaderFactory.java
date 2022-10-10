package Services;

import Enums.DataReadType;

public class DataReaderFactory {
    public static DataReader getDataReader(String type) {
        return DataReadType.valueOf(type).getReader();
    }
}
