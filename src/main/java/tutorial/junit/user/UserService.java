package tutorial.junit.user;

import java.util.List;

public class UserService {

//    private final UserProvider userProvider;


    public User register(String email, String password) {
        return null;
    }

    public void confirmRegistration() {

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

    public void remove(User current) {
        //Only admin can remove
    }

    public void addPermission(Permission p, String username, User current) {

    }

    //additional task - add user provider
}
