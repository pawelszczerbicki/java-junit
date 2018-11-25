package tutorial.junit.user;

import java.util.ArrayList;

public class User {

    private String email;
    private String password;
    private ArrayList<Permission> permissions = new ArrayList<>();
    private State state;


    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.state = State.REGISTERED;
    }

    //Add roles and permissions so two lists will be there
    public boolean hasPermission(Permission p) {
        return permissions.contains(p);
    }

    public void addPermission(Permission p) {
        permissions.add(p);
    }

    public void removePermission(Permission p) {
        permissions.remove(p);
    }

    public String getEmail() {
        return email;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    //TODO use instance of
    public boolean equals(Object o) {
        User u = (User) o;
        return this.email.equals(u.email);
    }

    public int hashCode(){
        return email.hashCode();
    }


}
