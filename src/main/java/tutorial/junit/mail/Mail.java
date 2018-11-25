package tutorial.junit.mail;

public class Mail {

    private String subject;
    private String content;
    private String to;

    public Mail(String subject, String content, String to) {
        this.subject = subject;
        this.content = content;
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getTo() {
        return to;
    }
}
