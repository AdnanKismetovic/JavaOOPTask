package config;

import Models.Config;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Configuration {

    private final static String CONFIGURATION_FILE = "src/config/configuration.json";
    private static final Logger logger = LoggerFactory.getLogger(Configuration.class);

    public static Config load() {
        logger.info("Loading Configuration from file: " + CONFIGURATION_FILE);
        Config config = new Config();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            config = objectMapper.readValue(new File(CONFIGURATION_FILE), Config.class);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return config;
    }

}
