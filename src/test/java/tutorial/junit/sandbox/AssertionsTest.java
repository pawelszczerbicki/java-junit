package tutorial.junit.sandbox;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssertionsTest {

    @BeforeEach
    void beforeEach() {
        System.out.println("BEFORE");
    }

    @Test
    @DisplayName("Test all assertions")
    void testAssert() {

        //Variable declaration
        String string1 = "Junit";
        String string2 = "Junit";
        String string3 = "test";
        String string4 = "test";
        String string5 = null;
        int variable1 = 1;
        int variable2 = 2;
        int[] airethematicArrary1 = {1, 2, 3};
        int[] airethematicArrary2 = {1, 2, 3};

        //Assert statements
        assertEquals(string1, string2);
        assertSame(string3, string4);
        assertNotSame(string1, string3);
        assertNotNull(string1);
        assertNull(string5);
        assertTrue(variable1 < variable2);
        assertArrayEquals(airethematicArrary1, airethematicArrary2);

        if (2 > 3) fail("It should never happen");
    }

    @Test
    @Disabled("Test does not make sense")
    void disabled() {
        assertFalse(true);
    }
}
