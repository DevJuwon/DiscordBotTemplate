package com.makerzip.template;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Config {
    public static String _prefix = "!";
    public static String owner_id = "!";

    public String token(boolean debug) {
        Properties prop = new Properties();
        URL url = Thread.currentThread().getContextClassLoader().getResource("token.properties");
        if (debug) {
            try {
                prop.load(url.openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (prop.getProperty("test-token").length() == 59) {
                return prop.getProperty("test-token");
            } else {
                System.err.println("You did not write down the test-token. So it works as the main-token");
                return prop.getProperty("main-token");
            }
        } else {
            try {
                prop.load(url.openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return prop.getProperty("main-token");
        }
    }
}

