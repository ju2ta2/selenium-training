package com.nostromo.dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private final Properties properties;


    public ConfigFileReader(){
        BufferedReader reader;
        String propertyFilePath = "configs//Configuration.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getChromeDriverPath(){
        String driverPath = properties.getProperty("chromeDriverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("chromeDriverPath not specified in the Configuration.properties file.");
    }

    public String getFirefoxDriverPath(){
        String driverPath = properties.getProperty("firefoxDriverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("firefoxDriverPath not specified in the Configuration.properties file.");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getAdminUsername() {
        String adminUsername = properties.getProperty("adminUsername");
        if(adminUsername != null) return adminUsername;
        else throw new RuntimeException("adminUsername not specified in the Configuration.properties file.");
    }

    public String getAdminPassword() {
        String adminPassword = properties.getProperty("adminPassword");
        if(adminPassword != null) return adminPassword;
        else throw new RuntimeException("adminPassword not specified in the Configuration.properties file.");
    }

    public String getApplicationEndpoint() {
        String url = properties.getProperty("endpoint");
        if(url != null) return url;
        else throw new RuntimeException("endpoint not specified in the Configuration.properties file.");
    }

}
