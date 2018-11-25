package tutorial.junit.properties;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tutorial.junit.properties.Keys.MAIL_PUBLIC_KEY;

class PropertiesProviderTest {

    private PropertiesProvider properties = new PropertiesProvider("app.properties").init();

    @Test
    void shouldReadProperty() {
        //given
        String expected = "test";

        //then
        assertEquals(expected, properties.get(MAIL_PUBLIC_KEY));
    }

}