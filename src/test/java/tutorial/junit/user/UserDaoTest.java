package tutorial.junit.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.apache.commons.lang.RandomStringUtils.random;
import static org.junit.jupiter.api.Assertions.*;
import static tutorial.junit.user.Permission.ADMIN;

class UserDaoTest {

    private static final String EMAIL = random(5);
    private User user;
    private UserDao userDao;

    @BeforeEach
    void initDb() {
        user = new User(EMAIL, random(5));
        userDao = new UserDao();
        userDao.addUser(user);
    }

    @Test
    void shouldAddUser() {
        //when
        User fetched = userDao.get(EMAIL);

        //then
        assertEquals(user, fetched);
    }

    @Test
    void shouldRemoveUser() {
        //when
        User removed = userDao.remove(EMAIL);

        //then
        assertEquals(user, removed);
        assertNull(userDao.get(EMAIL));
    }

    @Test
    void shouldAddPermission() {
        userDao.addPermission(EMAIL, ADMIN);
        assertTrue(userDao.get(EMAIL).hasPermission(ADMIN));
    }

    @Test
    void shouldRemovePermission() {
        userDao.addPermission(EMAIL, ADMIN);
        userDao.removePermission(EMAIL, ADMIN);
        assertFalse(userDao.get(EMAIL).hasPermission(ADMIN));
    }

}