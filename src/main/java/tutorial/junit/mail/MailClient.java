package tutorial.junit.mail;

import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Email;
import org.json.JSONArray;
import org.json.JSONObject;
import tutorial.junit.properties.PropertiesProvider;

import static com.mailjet.client.resource.Email.*;
import static tutorial.junit.properties.Keys.MAIL_PUBLIC_KEY;
import static tutorial.junit.properties.Keys.MAIL_SECRET_KEY;

public class MailClient {

    private final PropertiesProvider properties;

    public MailClient(PropertiesProvider properties) {
        this.properties = properties;
    }

    public void send(Mail email) {
        MailjetClient client = new MailjetClient(properties.get(MAIL_PUBLIC_KEY), properties.get(MAIL_SECRET_KEY));

        MailjetRequest mail =
                new MailjetRequest(Email.resource)
                        .property(FROMEMAIL, "yuho@zsero.com")
                        .property(SUBJECT, email.getSubject())
                        .property(TEXTPART, email.getContent())
                        .property(HTMLPART, email.getContent())
                        .property(RECIPIENTS, new JSONArray().put(new JSONObject().put("Email", email.getTo())));
        try {
            client.post(mail);
        } catch (MailjetException | MailjetSocketTimeoutException e) {
            throw new MailNotSendException("Can not send email", e);
        }
    }

    public static void main(String[] args) {
        new MailClient(new PropertiesProvider().init()).send(new Mail("some", "some", "szczerbicki.pawel@gmail.com"));
    }

}
