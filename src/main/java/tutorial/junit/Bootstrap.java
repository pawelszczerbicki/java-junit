package tutorial.junit;

import tutorial.junit.mail.MailClient;
import tutorial.junit.user.UserDao;
import tutorial.junit.user.UserService;

public class Bootstrap {
    public static void main(String[] args) {
        UserDao dao = new UserDao();
        MailClient client = new MailClient() ;
        UserService service = new UserService(dao, client);
    }
}
