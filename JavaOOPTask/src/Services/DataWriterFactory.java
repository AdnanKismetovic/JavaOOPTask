package Services;

import Enums.DataSaveType;

public class DataWriterFactory {
    public static DataWriter getDataWriter(String type) {
        return DataSaveType.valueOf(type).getWriter();
    }
}
