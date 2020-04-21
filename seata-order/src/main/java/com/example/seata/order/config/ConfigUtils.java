package com.example.seata.order.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {

    public static Properties properties;

    static {
        try {
            InputStream in = ConfigUtils.class.getClassLoader().getResourceAsStream("application.properties");
            properties = new Properties();
            properties.load(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
