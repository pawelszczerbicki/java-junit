package tutorial.junit.properties;

public class CanNotLoadPropertiesException extends RuntimeException {

    public CanNotLoadPropertiesException(String message, Throwable cause) {
        super(message, cause);
    }
}
