package com.automationqa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

public class PropertyUtil {
    public static final String configFilePath = "src/test/resources/properties/";
    public static HashMap<String, String> configMap = new HashMap<>();

    public static void readProperty() {
        Properties prop = null;
        try {
            prop = new Properties();
            File f1 = new File(configFilePath);
            File[] listOfFiles = f1.listFiles(); //for storing configs and locator folder

            //System.out.println("Length:" + listOfFiles.length);
            for (int i = 0; i < listOfFiles.length; i++) {
                File[] listOfPropFiles = listOfFiles[i].listFiles();  //for properties file inside configs and locators folder
                //System.out.println("Path is=" + listOfFiles[i].getAbsolutePath());
                for (int j = 0; j < listOfPropFiles.length; j++) {
                    String prop1 = listOfPropFiles[j].getAbsolutePath();
                    //String prop1=configFilePath+listOfFiles[i].getName();
                    // System.out.println("Path is=" + prop1);
                    FileInputStream inputStream = new FileInputStream(prop1);
                    prop.load(inputStream);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (prop != null) {
            for (String Key : prop.stringPropertyNames()) {
                String value = prop.getProperty(Key);
                configMap.put(Key, value);
            }


        }
    }

    public static String getProperty(String configName) {
        String configValue = "";
        if (configMap.isEmpty()) {
            readProperty();
        }
        configValue = configMap.get(configName);
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


