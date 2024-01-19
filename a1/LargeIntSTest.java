package a1;

import static org.junit.jupiter.api.Assertions.*;

import a1.LargeInt;
import a1.LargeIntInterface;
import org.junit.jupiter.api.Test;

public class LargeIntSTest {

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
    void testLargeIntSum2pos_1() {
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
    void testLargeIntSum2pos_2() {
        String meValue = "50812";
        String me2Value = "234";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.add(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
        assertEquals("51046", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntSum2pos_3() {
        String meValue = "634";
        String me2Value = "1256";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.add(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
        assertEquals("1890", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntSum2Negatives_1() {
        String meValue = "-800";
        String me2Value = "-1000";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.add(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
        assertEquals("-1800", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntSum2Negatives_2() {
        String meValue = "-800";
        String me2Value = "-900";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.add(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
        assertEquals("-1700", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntSum2Negatives_3() {
        String meValue = "-2010236";
        String me2Value = "-1748459";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.add(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
        assertEquals("-3758695", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntSumMeNegative_1() {
        String meValue = "-800";
        String me2Value = "1000";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.add(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
        assertEquals("200", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntSumMeNegative_2() {
        String meValue = "-700";
        String me2Value = "800";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.add(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
        assertEquals("100", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntSumMeNegative_3() {
        String meValue = "-900";
        String me2Value = "700";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.add(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
        assertEquals("-200", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntSumMeNegative_4() {
        String meValue = "-9";
        String me2Value = "100";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.add(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
        assertEquals("91", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntSumMeNegative_5() {
        String meValue = "-1500";
        String me2Value = "250";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.add(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
        assertEquals("-1250", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntSumMe2Negative_1() {
        String meValue = "900";
        String me2Value = "-1000";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.add(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
        assertEquals("-100", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntSumMe2Negative_2() {
        String meValue = "700";
        String me2Value = "-850";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.add(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
        assertEquals("-150", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntSumMe2Negative_3() {
        String meValue = "1500";
        String me2Value = "-250";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.add(me2); // i add me2 to me, to get the resulting sum me3 = me + me2
        assertEquals("1250", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }


    @Test
    void testLargeIntDiff2pos_1() {
        String meValue = "9642";
        String me2Value = "4230";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.subtract(me2); // i subtract me2 from me, to get the resulting diff me3 = me - me2
        //	System.out.println("me3: " + me3.toString());
        assertEquals("5412", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntDiff2pos_2() {
        String meValue = "2601";
        String me2Value = "54023";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.subtract(me2); // i subtract me2 from me, to get the resulting diff me3 = me - me2
        //	System.out.println("me3: " + me3.toString());
        assertEquals("-51422", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntDiff2pos_3() {
        String meValue = "1523";
        String me2Value = "263";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.subtract(me2); // i subtract me2 from me, to get the resulting diff me3 = me - me2
        //	System.out.println("me3: " + me3.toString());
        assertEquals("1260", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntDiff2pos_4() {
        String meValue = "678";
        String me2Value = "924";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.subtract(me2); // i subtract me2 from me, to get the resulting diff me3 = me - me2
        //	System.out.println("me3: " + me3.toString());
        assertEquals("-246", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntDiff2Neg_1() {
        String meValue = "-500";
        String me2Value = "-1000";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.subtract(me2); // i subtract me2 from me, to get the resulting diff me3 = me - me2
        //	System.out.println("me3: " + me3.toString());
        assertEquals("500", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntDiff2Neg_2() {
        String meValue = "-1700";
        String me2Value = "-250";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.subtract(me2); // i subtract me2 from me, to get the resulting diff me3 = me - me2
        //	System.out.println("me3: " + me3.toString());
        assertEquals("-1450", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntDiff2Neg_3() {
        String meValue = "-900";
        String me2Value = "-230";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.subtract(me2); // i subtract me2 from me, to get the resulting diff me3 = me - me2
        //	System.out.println("me3: " + me3.toString());
        assertEquals("-670", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntDiff2Neg_4() {
        String meValue = "-700";
        String me2Value = "-800";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.subtract(me2); // i subtract me2 from me, to get the resulting diff me3 = me - me2
        //	System.out.println("me3: " + me3.toString());
        assertEquals("100", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntDiffMeNeg_1() {
        String meValue = "-326";
        String me2Value = "5367";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.subtract(me2); // i subtract me2 from me, to get the resulting diff me3 = me - me2
        //	System.out.println("me3: " + me3.toString());
        assertEquals("-5693", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntDiffMeNeg_2() {
        String meValue = "-1549";
        String me2Value = "62";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.subtract(me2); // i subtract me2 from me, to get the resulting diff me3 = me - me2
        //	System.out.println("me3: " + me3.toString());
        assertEquals("-1611", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntDiffMe2Neg_1() {
        String meValue = "234";
        String me2Value = "-6532";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.subtract(me2); // i subtract me2 from me, to get the resulting diff me3 = me - me2
        //	System.out.println("me3: " + me3.toString());
        assertEquals("6766", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testLargeIntDiffMe2Neg_2() {
        String meValue = "8111";
        String me2Value = "-636";
        LargeInt me = new LargeInt(meValue); // i have an integer me
        LargeInt me2 = new LargeInt(me2Value); // i have another integer me2
        LargeIntInterface me3 = me.subtract(me2); // i subtract me2 from me, to get the resulting diff me3 = me - me2
        //	System.out.println("me3: " + me3.toString());
        assertEquals("8747", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }






}