package com.cbt.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    private static FileInputStream fileInputStream;
    static {
        //try with resource --> try/catch block can take a parameter, AutoCloseable

        try {
            fileInputStream=new FileInputStream("config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
