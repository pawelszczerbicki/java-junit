package tutorial.junit.mail;

import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Email;
import org.json.JSONArray;
import org.json.JSONObject;

import static com.mailjet.client.resource.Email.*;

public class MailClient {
    private static final String PUBLIC_KEY = "90779ff3c6d42df37091c22062abf671";
    private static final String SECRET_KEY = "70fe116895369529d8749b88df3a5425";

    //TODO add PropertiesProvider as contstructor parameter, and get
    //Properties from file
    public void send(Mail email) {

        MailjetClient client = new MailjetClient(PUBLIC_KEY, SECRET_KEY);

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
        }
    }

    public String test(String some) {
        return some + "hello";
    }

}
