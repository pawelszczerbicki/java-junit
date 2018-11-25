package tutorial.junit.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesProvider {

    private final String filename;
    private Properties props = new Properties();

    public PropertiesProvider(String filename) {
        this.filename = filename;
    }

    public PropertiesProvider init() {
        try {
            String path = getClass().getClassLoader().getResource(filename).getPath();
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
}
