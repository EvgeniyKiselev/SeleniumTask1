package util;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    private final Properties properties = new Properties();

    private static TestProperties INSTANCE = null;

    public TestProperties() {
        //System.setProperty("environment", "application");
        try {
            properties.load(new FileInputStream(new File("src/test/resources/" + System.getProperty("application", "application") + ".properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Test properties created!");
    }

    public static TestProperties getInstance() {
        if (INSTANCE == null){
            INSTANCE = new TestProperties();
        }
        return INSTANCE;
    }

    public String getProperty(String key, String defaultValue){
        return properties.getProperty(key, defaultValue);
    }
    public String getProperties(String key) {
        return properties.getProperty(key);
    }
}

