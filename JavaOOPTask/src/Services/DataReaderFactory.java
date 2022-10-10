package Services;

import Enums.DataReadType;
import org.slf4j.Logger;

public class DataReaderFactory {
    public static DataReader getDataReader(String type, Logger logger) {
        logger.info("Getting reader for type: " + type);
        return DataReadType.valueOf(type).getReader();
    }
}
