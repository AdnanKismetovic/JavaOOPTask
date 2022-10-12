package config;

import Models.Config;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;

import java.io.File;

public class Configuration {

    private final static String CONFIGURATION_FILE = "src/config/configuration.json";
    public static Config load(Logger logger) {
        logger.info("Loading Configuration from file: " + CONFIGURATION_FILE);
        Config config = new Config();
        try {
            logger.info("Creating Object Mapper...");
            ObjectMapper objectMapper = new ObjectMapper();
            logger.info("Creating Config Object...");
            config = objectMapper.readValue(new File(CONFIGURATION_FILE), Config.class);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return config;
    }

}
