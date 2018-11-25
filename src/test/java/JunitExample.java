import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JunitExample {

    @DisplayName("Should junit work")
    @Test
    void shouldJunitWorkCorrectly() {
         assertTrue(2==3);
    }
}
