package com.app.inventoryblockchain.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final Properties properties = new Properties();

    static {
        try(InputStream in = ConfigLoader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if(in == null) {
                throw new RuntimeException("config.properties not found");
            }
            properties.load(in);
        }catch (IOException e) {
            throw new RuntimeException("Error loading properties file", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
