package tutorial.junit.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesProvider {

    private static final String FILENAME = "app.properties";
    private Properties props = new Properties();

    public PropertiesProvider init() {
        try {
            String path = getClass().getClassLoader().getResource(FILENAME).getPath();
            props.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
            throw new CanNotLoadPropertiesException("Check file path", e);
        }

        return this;
    }

    public String get(String key) {
        return props.getProperty(key);
    }

    public boolean getBoolean(String key){
        //TODO implement
        return false;
    }
}
