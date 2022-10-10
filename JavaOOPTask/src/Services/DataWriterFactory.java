package Services;

import Enums.DataSaveType;
import org.slf4j.Logger;

public class DataWriterFactory {
    public static DataWriter getDataWriter(String type, Logger logger) {
        logger.info("Getting writer for type: " + type);
        return DataSaveType.valueOf(type).getWriter();
    }
}
