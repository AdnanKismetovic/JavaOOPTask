package Services;

import Enums.DataReadType;
import exceptions.ItemNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataReaderFactory {
    private static final Logger logger = LoggerFactory.getLogger(DataReaderFactory.class);

    public static DataReader getDataReader(String type) throws ItemNotFoundException {
        try {
            return DataReadType.valueOf(type).getReader();
        } catch (IllegalArgumentException ex) {
            logger.error(ex.getMessage());
            throw new ItemNotFoundException("Reader not created.", "Reading type doesn't exist in ENUM or is not defined.");
        }
    }
}
