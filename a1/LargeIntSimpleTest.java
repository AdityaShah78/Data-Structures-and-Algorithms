package a1;

import static org.junit.jupiter.api.Assertions.*;

import a1.LargeInt;
import a1.LargeIntInterface;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class LargeIntSimpleTest {

    // the provided test cases do not represent all possible cases.
    // please write your own cases to test for all possible edge scenarios within the assignment requirements

    @Test
    void testLargeIntNeg20120() {
        String value = "-20120";
        LargeInt me = new LargeInt("-20120");
        // we'll use String.replace, to ensure that we can catch outputs with extraneous + or , characters when grading
        assertEquals(value, me.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeInt20120() {
        String value = "20120";
        LargeInt me = new LargeInt(value);
        assertEquals(value, me.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntSum() {
        LargeInt me = new LargeInt("102112"); // i have an integer me
        LargeInt me2 = new LargeInt("104231"); // i have another integer me2
        LargeIntInterface me3 = me.add(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
        assertEquals("206343", me3.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntDiff() {
        LargeInt me = new LargeInt("9642"); // i have an integer me
        LargeInt me2 = new LargeInt("4230"); // i have another integer me2
        LargeIntInterface me3 = me.subtract(me2); // i subtract me2 from me, to get the resulting diff me3 = me - me2
        assertEquals("5412", me3.toString().replace("+","").replace(",", ""));
    }

    @Test
    public void testAdd() {
        LargeInt m = new LargeInt("2222");
        LargeInt n = new LargeInt("241414222");
        LargeInt ans = m.add(n);
        assertEquals("241416444", ans.toString());

        m = new LargeInt("-2222");
        n = new LargeInt("241414222");
        ans = m.add(n);
        assertEquals("241412000", ans.toString());

        m = new LargeInt("2222");
        n = new LargeInt("-241414222");
        ans = m.add(n);
        assertEquals("-241412000", ans.toString());

        m = new LargeInt("-2222");
        n = new LargeInt("-241414222");
        ans = m.add(n);
        assertEquals("-241416444", ans.toString());
    }

    @Test
    public void testSubtract() {
        LargeInt m = new LargeInt("2222");
        LargeInt n = new LargeInt("241414222");
        LargeInt ans = m.subtract(n);
        assertEquals("-241412000", ans.toString());

        m = new LargeInt("-2222");
        n = new LargeInt("241414222");
        ans = m.subtract(n);
        assertEquals("-241416444", ans.toString());

        m = new LargeInt("2222");
        n = new LargeInt("-241414222");
        ans = m.subtract(n);
        assertEquals("241416444", ans.toString());

        m = new LargeInt("-2222");
        n = new LargeInt("-241414222");
        ans = m.subtract(n);
        assertEquals("241412000", ans.toString());
    }

    @Test
    public void testZeroSubtract() {
        LargeInt num1 = new LargeInt("0");
        LargeInt num2 = new LargeInt("1");
        assertEquals((new BigInteger("0").subtract(new BigInteger("1")).toString()), num1.subtract(num2).toString());

        num1 = new LargeInt("-0");
        num2 = new LargeInt("1");
        assertEquals((new BigInteger("-0").subtract(new BigInteger("1")).toString()), num1.subtract(num2).toString());

        num1 = new LargeInt("0");
        num2 = new LargeInt("-1");
        assertEquals((new BigInteger("0").subtract(new BigInteger("-1")).toString()), num1.subtract(num2).toString());

        num1 = new LargeInt("-0");
        num2 = new LargeInt("-1");
        assertEquals((new BigInteger("-0").subtract(new BigInteger("-1")).toString()), num1.subtract(num2).toString());

        num1 = new LargeInt("1");
        num2 = new LargeInt("0");
        assertEquals((new BigInteger("1").subtract(new BigInteger("0")).toString()), num1.subtract(num2).toString());

        num1 = new LargeInt("-1");
        num2 = new LargeInt("0");
        assertEquals((new BigInteger("-1").subtract(new BigInteger("0")).toString()), num1.subtract(num2).toString());

        num1 = new LargeInt("1");
        num2 = new LargeInt("-0");
        assertEquals((new BigInteger("1").subtract(new BigInteger("-0")).toString()), num1.subtract(num2).toString());

        num1 = new LargeInt("-1");
        num2 = new LargeInt("-0");
        assertEquals((new BigInteger("-1").subtract(new BigInteger("-0")).toString()), num1.subtract(num2).toString());

        num1 = new LargeInt("0");
        num2 = new LargeInt("0");
        assertEquals((new BigInteger("0").subtract(new BigInteger("0")).toString()), num1.subtract(num2).toString());

        num1 = new LargeInt("-0");
        num2 = new LargeInt("0");
        assertEquals(new BigInteger("-0").subtract(new BigInteger("0")).toString(), num1.subtract(num2).toString());

        num1 = new LargeInt("0");
        num2 = new LargeInt("-0");
        assertEquals(new BigInteger("0").subtract(new BigInteger("-0")).toString(), num1.subtract(num2).toString());

        num1 = new LargeInt("-0");
        num2 = new LargeInt("-0");
        assertEquals(new BigInteger("-0").subtract(new BigInteger("-0")).toString(), num1.subtract(num2).toString());
    }

    @Test
    public void testZeroAddition() {
        LargeInt num1 = new LargeInt("0");
        LargeInt num2 = new LargeInt("1");
        assertEquals(new BigInteger("0").add(new BigInteger("1")).toString(), num1.add(num2).toString());

        num1 = new LargeInt("-0");
        num2 = new LargeInt("1");
        assertEquals(new BigInteger("-0").add(new BigInteger("1")).toString(), num1.add(num2).toString());

        num1 = new LargeInt("0");
        num2 = new LargeInt("-1");
        assertEquals(new BigInteger("0").add(new BigInteger("-1")).toString(), num1.add(num2).toString());

        num1 = new LargeInt("-0");
        num2 = new LargeInt("-1");
        assertEquals(new BigInteger("-0").add(new BigInteger("-1")).toString(), num1.add(num2).toString());

        num1 = new LargeInt("1");
        num2 = new LargeInt("0");
        assertEquals(new BigInteger("1").add(new BigInteger("0")).toString(), num1.add(num2).toString());

        num1 = new LargeInt("-1");
        num2 = new LargeInt("0");
        assertEquals(new BigInteger("-1").add(new BigInteger("0")).toString(), num1.add(num2).toString());

        num1 = new LargeInt("1");
        num2 = new LargeInt("-0");
        assertEquals(new BigInteger("1").add(new BigInteger("-0")).toString(), num1.add(num2).toString());

        num1 = new LargeInt("-1");
        num2 = new LargeInt("-0");
        assertEquals(new BigInteger("-1").add(new BigInteger("-0")).toString(), num1.add(num2).toString());

        num1 = new LargeInt("0");
        num2 = new LargeInt("0");
        assertEquals(new BigInteger("0").add(new BigInteger("0")).toString(), num1.add(num2).toString());

        num1 = new LargeInt("-0");
        num2 = new LargeInt("0");
        assertEquals(new BigInteger("-0").add(new BigInteger("0")).toString(), num1.add(num2).toString());

        num1 = new LargeInt("0");
        num2 = new LargeInt("-0");
        assertEquals(new BigInteger("0").add(new BigInteger("-0")).toString(), num1.add(num2).toString());

        num1 = new LargeInt("-0");
        num2 = new LargeInt("-0");
        assertEquals(new BigInteger("-0").add(new BigInteger("-0")).toString(), num1.add(num2).toString());

    }

    @Test
    void testLargeIntNeg201200() {
        String value = "-20120";
        LargeInt me = new LargeInt("-20120");
        // we'll use String.replace, to ensure that we can catch outputs with extraneous + or , characters when grading
        assertEquals(value, me.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeInt201200() {
        String value = "20120";
        LargeInt me = new LargeInt(value);
        assertEquals(value, me.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntSumm() {
        String meValue = "102112";
        String me2Value = "104231";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.add(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
        assertEquals("206343", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntDifff() {
        String meValue = "9642";
        String me2Value = "4230";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.subtract(me2); // i subtract me2 from me, to get the resulting diff me3 = me - me2
        assertEquals("5412", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }


}