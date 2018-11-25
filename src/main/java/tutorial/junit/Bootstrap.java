package tutorial.junit;

import tutorial.junit.mail.MailClient;
import tutorial.junit.properties.PropertiesProvider;
import tutorial.junit.user.UserDao;
import tutorial.junit.user.UserService;

public class Bootstrap {
    public static void main(String[] args) {
        UserDao dao = new UserDao();
        PropertiesProvider properties = new PropertiesProvider("app.properties");
        MailClient client = new MailClient() ;
        UserService service = new UserService(dao, client);
    }
}
