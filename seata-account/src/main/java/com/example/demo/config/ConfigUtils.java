package com.example.demo.config;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author boomboompow
 * @date 2020/5/19 2:00 PM
 */
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
