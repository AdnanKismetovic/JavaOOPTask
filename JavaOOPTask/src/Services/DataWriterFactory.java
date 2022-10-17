package Services;

import Enums.DataSaveType;
import exceptions.ItemNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataWriterFactory {
    private static final Logger logger = LoggerFactory.getLogger(DataWriterFactory.class);

    public static DataWriter getDataWriter(String type) throws ItemNotFoundException {
        try {
            return DataSaveType.valueOf(type).getWriter();
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            throw new ItemNotFoundException("Writer not created", "Writing type does not exist in ENUM or is not defined.");
        }
    }
}
