package dataProvider;

import comtest.exceptions.PropertyReaderException;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {

    public ConfigFileReader(){

    }

    private static final String EXCEPTION_TEXT = "Error occurred during reading properties file: ";

    private static final String CONFIG_PROPERTIES = "configs/project.properties";

    private static Properties configs;

    public static String getProperty(final String propertyName) {
        synchronized (ConfigFileReader.class) {
            if (configs == null) {
                try {
                    final InputStream readerConfig = ConfigFileReader.class
                            .getClassLoader().getResourceAsStream(CONFIG_PROPERTIES);
                    final Properties properties = new Properties();
                    properties.load(readerConfig);
                    configs = properties;
                } catch (IOException ex) {
                    throw new PropertyReaderException(EXCEPTION_TEXT + ex.getMessage());
                }
            }
        }
        final String systemProperty = System.getProperty(propertyName);
        var condition = configs.getProperty(propertyName, "Property Reader Fails");
        return systemProperty == null ? condition : systemProperty;
    }

    public static void setConfigProperty(String name, String value) {
        configs.setProperty(name, value);
    }
}

