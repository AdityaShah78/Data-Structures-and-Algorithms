package a1;

import a1.LargeInt;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargeIntRTest {

    final int runCount = 100_000;
    final int maxBits = 256;

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


}