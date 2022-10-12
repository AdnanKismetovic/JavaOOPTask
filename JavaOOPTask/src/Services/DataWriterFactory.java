package Services;

import Enums.DataSaveType;
import org.slf4j.Logger;

public class DataWriterFactory {
    public static DataWriter getDataWriter(String type, Logger logger) {
        logger.info("Getting writer for type: " + type);
        DataWriter dataWriter = null;
        try {
            dataWriter = DataSaveType.valueOf(type).getWriter();
            if (dataWriter == null)
                throw new Exception("Writer isn't successfully created");
        } catch (Exception e) {
           logger.error(e.getMessage());
        }
        return dataWriter;
    }
}
