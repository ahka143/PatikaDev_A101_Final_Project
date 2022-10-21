package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;

    static {
        FileInputStream fis= null;
        try {
            fis = new FileInputStream("configuration.properties");
            properties=new Properties();
            properties.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
