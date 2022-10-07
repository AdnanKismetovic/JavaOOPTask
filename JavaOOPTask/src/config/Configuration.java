package config;

import Models.Config;
import Models.Result;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class Configuration {

    private final static String CONFIGURATION_FILE = "src/config/configuration.json";
    public static Config config;
    public static void load() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            config = objectMapper.readValue(new File(CONFIGURATION_FILE), Config.class);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
