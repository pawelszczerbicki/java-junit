package tutorial.junit.sandbox;

public class Person {

    public static final int MIN_PASSWORD_LENGTH = 4;

    private String name;

    private String email;

    private String password;

    public Person(String name, String email, String password) {
        this(email, password);
        this.name = name;
    }

    public Person(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public boolean changePassword(String pwd) {
        if (pwd.length() > MIN_PASSWORD_LENGTH) {
            this.password = pwd;
            return true;
        }
        return false;
    }

    public boolean hasPassword() {
        return password != null && !password.isEmpty();
    }

    public boolean passwordMatches(String pwd) {
        return this.password.equals(pwd);
    }

    public String getPassword() {
        return password;
    }

    public boolean equals(Object o) {
        Person p = (Person) o;
        return this.email.equals(p.email);
    }

    public int hashCode() {
        return email.hashCode();
    }

    public static void main(String[] args) {
        Person p1 = new Person("email","dsadsa");
        Person p2 = new Person("email","1111111dsadsa");
        System.out.println(p1.equals(p2));
    }

}
