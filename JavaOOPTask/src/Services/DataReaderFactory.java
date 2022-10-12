package Services;

import Enums.DataReadType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataReaderFactory {
    private static final Logger logger = LoggerFactory.getLogger(DataReaderFactory.class);

    public static DataReader getDataReader(String type) {
        try {
            DataReader dataReader = DataReadType.valueOf(type).getReader();
            return dataReader;
        } catch (IllegalArgumentException ex) {
            logger.error(ex.getMessage());
            throw new IllegalArgumentException("Reader not created.");
        }
    }
}
