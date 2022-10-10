package Services;

import Enums.DataReadTypes;
import Enums.DataSaveTypes;

public class DataWriterFactory {
    public static DataWriter getDataWriter(String type) {
        return DataSaveTypes.valueOf(type).execute();
    }
}
