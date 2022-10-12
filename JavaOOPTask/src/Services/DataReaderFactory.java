package Services;

import Enums.DataReadType;
import org.slf4j.Logger;

public class DataReaderFactory {
    public static DataReader getDataReader(String type, Logger logger) {
        logger.info("Getting reader for type: " + type);
        DataReader dataReader = null;
        try {
            dataReader = DataReadType.valueOf(type).getReader();
            if (dataReader == null) {
                throw new Exception("Data reader isn't created successfully");
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return dataReader;
    }
}
