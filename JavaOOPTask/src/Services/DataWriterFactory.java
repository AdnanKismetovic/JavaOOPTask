package Services;

import Enums.DataSaveType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataWriterFactory {
    private static final Logger logger = LoggerFactory.getLogger(DataWriterFactory.class);

    public static DataWriter getDataWriter(String type) {
        try {
            DataWriter dataWriter = DataSaveType.valueOf(type).getWriter();
            return dataWriter;
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            throw new IllegalArgumentException("Writer not created");
        }
    }
}
