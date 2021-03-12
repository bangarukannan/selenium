package com.learn.utils;

import com.learn.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class ReadPropertyFile {
    private ReadPropertyFile(){

    }
//    To avoid loading the property file each time, used static block
    private static Properties properties = new Properties();
    private static final Map<String, String> CONFIG = new HashMap<>();
    static {
        try {
            FileInputStream file = new FileInputStream(FrameworkConstants.getConfigpath());
            properties.load(file);
            properties.keySet().stream().forEach( n-> CONFIG.put(n.toString(),getPropertyValue(n.toString()).trim()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getPropertyValue(String key){
        try {
            if (Objects.isNull(properties.getProperty(key)) || Objects.isNull(key)) {
                throw new Exception("Value/Key is null");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}
