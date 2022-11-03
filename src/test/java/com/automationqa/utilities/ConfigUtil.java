package com.automationqa.utilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class ConfigUtil {

    public static final String configFilePath = "src/test/resources/Configs/Environment.properties";

    public static HashMap<String, String> configMap = new HashMap<>();

    public static void configReader() {
        Properties prop = null;
        try {
            FileInputStream inputStream = new FileInputStream(configFilePath);
            prop = new Properties();
            prop.load(inputStream);
            inputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (prop != null) {
            for (String key : prop.stringPropertyNames()) {
                String value = prop.getProperty(key);
                configMap.put(key, value);
                System.out.println("CONFIG:: " + key + ">>>" + value);
            }
        }
    }

    public static String getConfig(String configName) {
        String configValue = "";
        if (configMap.isEmpty()) {
            configReader();
        }
        String envVar = System.getenv(configName);
        if (envVar == null)
            configValue = configMap.get(configName);
        else {
            configValue = envVar;
        }
        System.out.println("CONFIG:: " + configName + " >>> " + configValue);
        return configValue;


    }


}
