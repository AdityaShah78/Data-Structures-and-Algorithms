package a1;

import static org.junit.jupiter.api.Assertions.*;

import a1.LargeInt;
import org.junit.jupiter.api.Test;

public class LargeIntSameObjectTest {
    @Test
    void testSameObjectAddPositive() {
        LargeInt i = new LargeInt("1263");
        LargeInt sum = i.add(i);
        assertEquals("2526", sum.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testSameObjectAddNegative() {
        LargeInt i = new LargeInt("-537");
        LargeInt sum = i.add(i);
        assertEquals("-1074", sum.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testSameObjectSubtractPositive() {
        LargeInt i = new LargeInt("211");
        LargeInt diff = i.subtract(i);
        assertEquals("0", diff.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testSameObjectSubtractNegative() {
        LargeInt i = new LargeInt("-5448");
        LargeInt diff = i.subtract(i);
        assertEquals("0", diff.toString().replace("+","").replace(",", ""));
    }
}