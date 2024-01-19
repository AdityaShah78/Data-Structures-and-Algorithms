package a1;

import a1.LargeInt;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargeIntRandomTest {

    final int runCount = 100_000;
    final int maxBits = 256;

    @Test
    void testSameObjectAddPositive() {
        LargeInt i = new LargeInt("1263");
        LargeInt sum = i.add(i);
        assertEquals("2526", sum.toString());
        assertEquals("1263", i.toString());
    }

    @Test
    void testSameObjectAddNegative() {
        LargeInt i = new LargeInt("-537");
        LargeInt sum = i.add(i);
        assertEquals("-1074", sum.toString());
        assertEquals("-537", i.toString());
    }

    @Test
    void testSameObjectSubtractPositive() {
        LargeInt i = new LargeInt("211");
        LargeInt diff = i.subtract(i);
        assertEquals("0", diff.toString());
        assertEquals("211", i.toString());
    }

    @Test
    void testSameObjectSubtractNegative() {
        LargeInt i = new LargeInt("-5448");
        LargeInt diff = i.subtract(i);
        assertEquals("0", diff.toString());
        assertEquals("-5448", i.toString());
    }

    @Test
    void testAdditionWithLeadingZeroes() {
        LargeInt num1 = new LargeInt("000123");
        LargeInt num2 = new LargeInt("00906");
        LargeInt sum = num1.add(num2);
        BigInteger num1BI = new BigInteger("000123");
        BigInteger num2BI = new BigInteger("00906");
        BigInteger sumBI = num1BI.add(num2BI);
        assertEquals(sumBI.toString(), sum.toString());
    }

    @Test
    void testSubtractionWithLeadingZeroes() {
        LargeInt num1 = new LargeInt("000123");
        LargeInt num2 = new LargeInt("00906");
        LargeInt diff = num1.subtract(num2);
        BigInteger num1BI = new BigInteger("000123");
        BigInteger num2BI = new BigInteger("00906");
        BigInteger diffBI = num1BI.subtract(num2BI);
        assertEquals(diffBI.toString(), diff.toString());
    }

    @Test
    void testReusingAdditionandSubtraction() {
        LargeInt num1 = new LargeInt("0");
        LargeInt num2;
        LargeInt num3;
        BigInteger num1BI = new BigInteger("0");
        BigInteger num2BI;
        BigInteger num3BI;

        for (int i = 0; i <= runCount; i++) {
            // random long number
            num2BI = new BigInteger(maxBits, new Random());
            num3BI = new BigInteger(maxBits, new Random());
            num2 = new LargeInt(num2BI.toString());
            num3 = new LargeInt(num3BI.toString());

            // add
            num1 = num1.add(num2);
            num1BI = num1BI.add(num2BI);

            // subtract
            num1 = num1.subtract(num3);
            num1BI = num1BI.subtract(num3BI);

            // check
            assertEquals(num1BI.toString(), num1.toString());
        }

    }

    @Test
    void testRandomAddition() {
        Random random = new Random();

        for (int i = 0; i <= runCount; i++) {
            BigInteger num1 = new BigInteger(maxBits, random);
            if (random.nextBoolean()) num1 = num1.negate();
            LargeInt num1LI = new LargeInt(num1.toString());

            BigInteger num2 = new BigInteger(maxBits, random);
            if (random.nextBoolean()) num2 = num2.negate();
            LargeInt num2LI = new LargeInt(num2.toString());

            assertEquals(num1.add(num2).toString(), num1LI.add(num2LI).toString());
        }
    }

    @Test
    void testRandomSubtraction() {
        Random random = new Random();

        for (int i = 0; i <= runCount; i++) {
            BigInteger num1 = new BigInteger(maxBits, random);
            if (random.nextBoolean()) num1 = num1.negate();
            LargeInt num1LI = new LargeInt(num1.toString());

            BigInteger num2 = new BigInteger(maxBits, random);
            if (random.nextBoolean()) num2 = num2.negate();
            LargeInt num2LI = new LargeInt(num2.toString());

            assertEquals(num1.subtract(num2).toString(), num1LI.subtract(num2LI).toString());
        }
    }

    @Test
    void testLeadingZeroesAdditionSubtraction() {
        LargeInt num1 = new LargeInt("0123456789");
        BigInteger num1BI = new BigInteger("0123456789");
        LargeInt num2 = new LargeInt("009876543210");
        BigInteger num2BI = new BigInteger("009876543210");
        LargeInt num3 = num1.add(num2);
        BigInteger num3BI = num1BI.add(num2BI);

        assertEquals(num3BI.toString(), num3.toString());
    }


}