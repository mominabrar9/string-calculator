package stringcal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalTest {
    @Test
    void testEmptyStringReturnsZero() {
        StringCal sc = new StringCal();
        assertEquals(0, sc.add(""));
    }

    @Test
    void testSingleNumberReturnsValue() {
        StringCal sc = new StringCal();
        assertEquals(1, sc.add("1"));
    }

    @Test
    void testThrowsExceptionForNegative() {
        StringCal sc = new StringCal();
        Exception exception = assertThrows(RuntimeException.class, () -> sc.add("1,6,-7,3"));
        assertTrue(exception.getMessage().contains("negative numbers not allowed"));
    }

    @Test
    void testMultipleNumbers() {
        StringCal sc = new StringCal();
        assertEquals(6, sc.add("1,2,3"));
    }
}