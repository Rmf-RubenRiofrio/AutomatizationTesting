package com.ruben.framework;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties prop = new Properties();

    static{
        try(InputStream input = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config.properties")){
            if(input == null){
                throw new RuntimeException("config.properties resource not found!");
            }
            prop.load(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key){
        return prop.getProperty(key);
    }

    public static int getIntProperty(String key){
        return Integer.parseInt(prop.getProperty(key));
    }
}
