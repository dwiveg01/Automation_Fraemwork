package com.automationqa.utilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

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


        public static String randomWords() {

            // create a string of all characters
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            // create random string builder
            StringBuilder sb = new StringBuilder();

            // create an object of Random class
            Random random = new Random();

            // specify length of random string
            int length = 7;

            for(int i = 0; i < length; i++) {

                // generate random index number
                int index = random.nextInt(alphabet.length());

                // get character specified by index
                // from the string
                char randomChar = alphabet.charAt(index);

                // append the character to string builder
                sb.append(randomChar);
            }

            String randomString = sb.toString();
            return randomString;


        }
    }



