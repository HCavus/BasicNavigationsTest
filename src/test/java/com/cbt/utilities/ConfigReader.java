package com.cbt.utilities;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties=new Properties();

    static {
        //try with resource --> try/catch block can take a parameter, AutoCloseable

        try {
            //reads file in java. we need to pass the path of the file
            FileInputStream fileInputStream=new FileInputStream("config.properties");
            //load contents of the file the properties object
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);

    }
}
