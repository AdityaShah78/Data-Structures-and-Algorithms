package a1;

import a1.LargeInt;

import java.math.BigInteger;
import java.util.Random;

public class testMain {

    public static void main(String[] args) {

        final int runCount = 100_000;
        final int maxBits = 256;

        Random random = new Random();

        for (int i = 0; i <= 10; i++) {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------");
            BigInteger num1 = new BigInteger(maxBits, random);
            if (random.nextBoolean()) num1 = num1.negate();
            LargeInt num1LI = new LargeInt(num1.toString());
            System.out.println("num1:   " + num1);
            System.out.println("num1LI: " + num1LI);
            System.out.println("Length of num1:   " + num1.toString().length());
            System.out.println("Length of num1LI: " + num1LI.toString().length());
            System.out.println("same content? " + num1LI.toString().equals(num1.toString()));
            //System.out.println("Returns empty if equal:'" + StringUtils.difference(num1.toString(), num1LI.toString())+"'");
            //System.out.println("index of differences(-1 = equal): " + StringUtils.indexOfDifference(num1.toString(), num1LI.toString()));
            System.out.println();

            BigInteger num2 = new BigInteger(maxBits, random);
            if (random.nextBoolean()) num2 = num2.negate();
            LargeInt num2LI = new LargeInt(num2.toString());
            System.out.println("num2:   " + num2.toString());
            System.out.println("num2LI: " + num2LI.toString());
            System.out.println("Length of num2:   " + num2.toString().length());
            System.out.println("Length of num2LI: " + num2LI.toString().length());
            System.out.println("same content? " + num2LI.toString().equals(num2.toString()));
            //System.out.println("Returns empty if equal:'" + StringUtils.difference(num2.toString(), num2LI.toString())+"'");
            //System.out.println("index of differences(-1 = equal): " + StringUtils.indexOfDifference(num2.toString(), num2LI.toString()));
            System.out.println();
            num1.add(num2).toString();

            num1LI.add(num2LI).toString();
            System.out.println("------NUM1 + NUM2------");
            System.out.println("BigInteger:" + num1.toString());
            System.out.println("LargeInt:  " + num1LI.toString());
            System.out.println("Length of num1:   " + num1.toString().length());
            System.out.println("Length of num1LI: " + num1LI.toString().length());
            System.out.println("same content? " + num1LI.toString().equals(num1.toString()));
            //System.out.println("Returns empty if equal:'" + StringUtils.difference(num1.toString(), num1LI.toString())+"'");
            //System.out.println("index of differences(-1 = equal): " + StringUtils.indexOfDifference(num1.toString(), num1LI.toString()));
            System.out.println("----------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------");




        }
    }

}