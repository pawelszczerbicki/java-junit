package tutorial.junit.user;

import tutorial.junit.mail.Mail;
import tutorial.junit.mail.MailClient;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private UserDao userDao;
    private MailClient client;

    public UserService(UserDao userDao, MailClient client) {
        this.userDao = userDao;
        this.client = client;
    }

    public User register(String email, String password) {
        User user = new User(email, password);
        userDao.addUser(user);
        client.send(new Mail("Hello", "Welcome", email));
        return user;
    }

    public User get(String email) {
        return userDao.get(email);
    }

    public void confirmRegistration(String email, String token) {

    }

    public boolean login(String login, String password) {
        //todo check if is active, and password
        return true;

    }

    public List<User> getAdmins(User current) {
        //Check if current is admin
        return null;
    }

    public List<User> getAllUsers(User current) {
        //Check if current is admin
        return null;
    }

    public void remove(User current, String toRemoveEmail) {
        //Only admin can remove
        userDao.remove(toRemoveEmail);
    }

    public void addPermission(Permission p, String username, User current) {

    }

    public void testException() {
        new ArrayList<>().get(10);
    }
}
