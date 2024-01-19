package a1;

import a1.LargeInt;
import a1.SpecializedList;

public class RunTest {

    public static void main(String []args){
//        SpecializedList sl = new SpecializedList();
//        System.out.println(sl.getSize());
//        sl.insertFront((byte)1);
//        System.out.println(sl.getSize());
//        sl.insertEnd((byte)2);
//        sl.insertEnd((byte)3);
//        sl.insertEnd((byte)4);
//        sl.insertEnd((byte)5);
//        System.out.println(sl.lengthIs());
//        System.out.println(sl.getNextItem());
//        System.out.println(sl.getPriorItem());
//        System.out.println(sl.getNextItem());
//        System.out.println(sl.getPriorItem());
//        sl.resetBackward();sl.resetForward();
//        System.out.println(sl.getNextItem());
//        System.out.println(sl.getPriorItem());

        LargeInt l = new LargeInt("-123456");

        SpecializedList sl = new SpecializedList();
        sl.insertEnd((byte)1);
        sl.insertEnd((byte)2);
        sl.insertEnd((byte)3);
        sl.insertEnd((byte)4);
        sl.insertEnd((byte)5);
        sl.insertEnd((byte)6);
//        System.out.println(sl.getNextItem());
//        System.out.println(sl.getNextItem());
//        System.out.println(sl.getNextItem());
//        sl.insertEnd((byte)7);
//        System.out.println(sl.getNextItem());

//        for(int i = 0; i < 10; i++){
//            System.out.println(sl.getPriorItem());
//        }

//        System.out.println(l.toString());
//
//        LargeInt p = new LargeInt("99999");
//        LargeInt q = new LargeInt("10000");
//        LargeInt sum = p.add(q);
//
//
//        System.out.println("Sum should be 124690");
//        System.out.println(sum.toString());

        LargeInt a = new LargeInt("111");
        LargeInt b = new LargeInt("111");

        LargeInt negativeZero = new LargeInt("");
        LargeInt otherNumber = new LargeInt("");
        //System.out.println(negativeZero.toString());

        //System.out.println("Negative Zero: " + negativeZero);

        LargeInt d = a.add(a);
        //LargeInt z = a.add(a);

        d.setNegative();

        //System.out.println("Diff should be 333");
        //System.out.println(a);
        //System.out.println(a.add(a));
        //System.out.println(z);

        // Illegal state Exception



//        int num = 12;
//
//        int a = num % 100;
//
//        int b = num / 10;
//
//        System.out.println("a = " + a + ", b = " + b);

    }


}
