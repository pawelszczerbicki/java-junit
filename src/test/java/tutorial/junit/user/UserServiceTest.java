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
    private User user = new User("mail@mail.com", PWD);

    private UserDao dao;

    private MailClient client;

    private UserService userService;

    private ArgumentCaptor<Mail> captor = ArgumentCaptor.forClass(Mail.class);

    @BeforeEach
    void init() {
        dao = new UserDao();
        client = mock(MailClient.class);
        userService = new UserService(dao, client);
    }

    @Test
    void shouldRegisterUser() {
        //when
        User registered = userService.register(user.getEmail(), PWD);

        when(client.test(any())).thenReturn("othe");

        System.out.println(client.test("test"));

        //then
        assertEquals(user, dao.get(user.getEmail()));
        assertEquals(user, registered);
        verify(client).send(captor.capture());
        Mail mailThatWasSuposedToBeSend = captor.getValue();
    }

}