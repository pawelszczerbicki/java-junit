package tutorial.junit.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import tutorial.junit.mail.Mail;
import tutorial.junit.mail.MailClient;

import static org.apache.commons.lang.RandomStringUtils.random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceTest {
    private static final String PWD = random(5);
    private static final String EMAIL = random(5);
    private User user = new User("mail@mail.com", PWD);

    private UserDao dao;

    private MailClient client;

    private UserService userService;

    private ArgumentCaptor<Mail> emailCaptor = ArgumentCaptor.forClass(Mail.class);
    private ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);

    @BeforeEach
    void init() {
        dao = mock(UserDao.class);
        client = mock(MailClient.class);
        userService = new UserService(dao, client);
    }

    @Test
    void shouldRegisterUser() {
        //when
        User registered = userService.register(user.getEmail(), PWD);

        //then
        verify(client).send(emailCaptor.capture());
        verify(dao).addUser(userCaptor.capture());

        assertEquals(user, registered);
        assertEquals(emailCaptor.getValue().getTo(), user.getEmail());
        assertEquals(userCaptor.getValue(), user);
    }

    @Test
    void shouldGetUser() {
        //given
        when(dao.get(EMAIL)).thenReturn(user);

        //when
        User expected = userService.get(EMAIL);

        //then
        assertEquals(expected, user);
        verify(dao).get(EMAIL);
    }

}