package tutorial.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import tutorial.junit.sandbox.Person;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private static final String MAIL = "mail";
    private static final String VALID_PASSWORD = "12345";
    private static final String EMPTY = "";

    private Person person;

    @BeforeEach
    void init() {
        System.out.println("before");
        person = new Person(MAIL, VALID_PASSWORD);
    }

    @AfterEach
    void after(){
        System.out.println("After");
    }

    @Test
    void shouldSetPasswordProperly() {
        assertEquals(person.getPassword(), VALID_PASSWORD);
    }

    @Test
    @Disabled("Class should be redesigned. Homework")
    void shouldNotSetPasswordShorterThanMin() {
        assertNotEquals(person.getPassword(), VALID_PASSWORD);
    }

    @Test
    void shouldNotHavePasswordWhenNullIsPassed() {
        Person p = new Person(MAIL, null);
        assertFalse(p.hasPassword());
    }

    @Test
    void shouldNotHavePasswordWhenEmptyIsPassed() {
        Person p = new Person(MAIL, EMPTY);
        assertFalse(p.hasPassword());
    }

    @Test
    void shouldChangePassword() {
        String newPassword = "12345567";

        assertTrue(person.changePassword(newPassword));
        assertEquals(newPassword, person.getPassword());
    }

    @Test
    void shouldNotChangePasswordWhenIsTooShort() {
        String newPassword = "321";
        assertFalse(person.changePassword(newPassword));
        assertNotEquals(person.getPassword(), newPassword);
    }

    @Test
    void shouldPasswordMatch() {
        assertTrue(person.passwordMatches(VALID_PASSWORD));
    }

    @Test
    void shouldPasswordNotMatch() {
        String givenPassword = "123";
        assertFalse(person.passwordMatches(givenPassword));
    }
}