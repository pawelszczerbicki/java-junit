package tutorial.junit.mail;

public class MailNotSendException extends RuntimeException {

    public MailNotSendException(String message, Throwable cause) {
        super(message, cause);
    }
}
