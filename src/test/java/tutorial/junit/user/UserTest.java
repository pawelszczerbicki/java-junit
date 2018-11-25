package tutorial.junit.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static tutorial.junit.user.Permission.ADMIN;

class UserTest {
    private static final String EMAIL = randomAlphabetic(5);
    private static final String PWD = randomAlphabetic(5);

    private User user;

    @BeforeEach
    void initUser() {
        user = new User(EMAIL, PWD);
        user.addPermission(ADMIN);
    }

    @Test
    void shouldAddPermission() {
        assertTrue(user.hasPermission(ADMIN));
    }

    @Test
    void shouldRemovePermission() {
        user.removePermission(ADMIN);
        assertFalse(user.hasPermission(ADMIN));
    }
}