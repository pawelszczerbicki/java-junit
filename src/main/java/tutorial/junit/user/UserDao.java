package tutorial.junit.user;

import java.util.HashMap;

public class UserDao {

    private HashMap<String, User> users = new HashMap<>();

    public void addUser(User u) {
        //TODO service duplicated user
        users.put(u.getEmail(), u);
    }

    public User get(String email) {
        return users.get(email);
    }

    public void addPermission(String email, Permission p) {
        get(email).addPermission(p);
    }

    public void removePermission(String email, Permission p) {
        get(email).removePermission(p);
    }

    public User remove(String email) {
        return users.remove(email);
    }


}
