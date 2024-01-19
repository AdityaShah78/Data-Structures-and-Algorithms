package a4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

import org.junit.Test;

import static org.junit.Assert.*;

public class PriorityQueueImplTest {
    public static final int TIMEOUT = 500;

    @Test(timeout=TIMEOUT)
    //@Description(description="PriorityQueueImpl test 1: empty queue")
    public void testEmpty() {
        PriorityQueueImpl queue = new PriorityQueueImpl();
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());

        boolean expectedExceptionThrown = false;

        try {
            queue.dequeue();
            fail("PriorityQueueEmptyException not thrown for dequeue on empty");
        } catch (Exception e) {
            String exceptionSimpleName = e.getClass().getSimpleName();
            if (exceptionSimpleName.equals("PriorityQueueEmptyException")) {
                expectedExceptionThrown = true;
            }
            else {
                fail("Some other exception was thrown. " + e.getClass() + ": " + e.getMessage());
            }
        }

        assertTrue("PriorityQueueEmptyException not thrown for dequeue on empty", expectedExceptionThrown);
    }

    @Test(timeout=TIMEOUT)
    //@Description(description="PriorityQueueImpl test 2: first entry")
    public void testOneEntry() {
        PriorityQueueImpl queue = new PriorityQueueImpl();
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());

        queue.enqueue(1);
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());

        assertEquals(1, queue.dequeue());
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());

        boolean expectedExceptionThrown = false;

        try {
            queue.dequeue();
            fail("PriorityQueueEmptyException not thrown for dequeue on empty");
        } catch (Exception e) {
            String exceptionSimpleName = e.getClass().getSimpleName();
            if (exceptionSimpleName.equals("PriorityQueueEmptyException")) {
                expectedExceptionThrown = true;
            }
            else {
                fail("Some other exception was thrown. " + e.getClass() + ": " + e.getMessage());
            }
        }

        assertTrue("PriorityQueueEmptyException not thrown for dequeue on empty", expectedExceptionThrown);
    }

    @Test(timeout=TIMEOUT)
    //@Description(description="PriorityQueueImpl test 3: two entries, remove right child")
    public void testTwoEntriesRightChildRemove() {
        PriorityQueueImpl queue = new PriorityQueueImpl();
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());

        queue.enqueue(1);
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());

        queue.enqueue(2);
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());

        /*
         * 1
         *  \
         *   2
         */

        assertEquals(2, queue.dequeue());
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());

        assertEquals(1, queue.dequeue());
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());

        boolean expectedExceptionThrown = false;

        try {
            queue.dequeue();
            fail("PriorityQueueEmptyException not thrown for dequeue on empty");
        } catch (Exception e) {
            String exceptionSimpleName = e.getClass().getSimpleName();
            if (exceptionSimpleName.equals("PriorityQueueEmptyException")) {
                expectedExceptionThrown = true;
            }
            else {
                fail("Some other exception was thrown. " + e.getClass() + ": " + e.getMessage());
            }
        }

        assertTrue("PriorityQueueEmptyException not thrown for dequeue on empty", expectedExceptionThrown);
    }

    @Test(timeout=TIMEOUT)
    //@Description(description="PriorityQueueImpl test 4: two entries, remove root")
    public void testTwoEntriesRootRemove() {
        PriorityQueueImpl queue = new PriorityQueueImpl();
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());

        queue.enqueue(1);
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());

        queue.enqueue(-1);
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());

        /*
         *    1
         *   /
         * -1
         */

        assertEquals(1, queue.dequeue());
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());

        assertEquals(-1, queue.dequeue());
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());

        boolean expectedExceptionThrown = false;

        try {
            queue.dequeue();
            fail("PriorityQueueEmptyException not thrown for dequeue on empty");
        } catch (Exception e) {
            String exceptionSimpleName = e.getClass().getSimpleName();
            if (exceptionSimpleName.equals("PriorityQueueEmptyException")) {
                expectedExceptionThrown = true;
            }
            else {
                fail("Some other exception was thrown. " + e.getClass() + ": " + e.getMessage());
            }
        }

        assertTrue("PriorityQueueEmptyException not thrown for dequeue on empty", expectedExceptionThrown);
    }

    @Test(timeout=TIMEOUT)
    //@Description(description="PriorityQueueImpl test 5: four entries, max, remove left child")
    public void testFourEntriesMaxWithLeftChildRemove() {
        PriorityQueueImpl queue = new PriorityQueueImpl();
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());

        queue.enqueue(1);
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());

        queue.enqueue(3);
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());

        queue.enqueue(5);
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());

        queue.enqueue(4);
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());

        /*
         * 1
         *  \
         *   3
         *    \
         *     5
         *    /
         *   4
         */

        assertEquals(5, queue.dequeue());
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());

        /*
         * 1
         *  \
         *   3
         *    \
         *     4
         */

        assertEquals(4, queue.dequeue());
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());

        /*
         * 1
         *  \
         *   3
         */
    }

    @Test(timeout=TIMEOUT)
    //@Description(description="PriorityQueueImpl test 6: four entries, remove root")
    public void testFourEntriesMaxWithRootRemove() {
        PriorityQueueImpl queue = new PriorityQueueImpl();
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());

        queue.enqueue(4);
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());

        queue.enqueue(2);
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());

        queue.enqueue(3);
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());

        queue.enqueue(1);
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());

        /*
         *     4
         *    /
         *   2
         *  / \
         * 1   3
         *
         */

        assertEquals(4, queue.dequeue());
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());

        /*
         *   2
         *  / \
         * 1   3
         *
         */

        assertEquals(3, queue.dequeue());
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());

        /*
         *   2
         *  /
         * 1
         *
         */

        assertEquals(2, queue.dequeue());
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());

        /*
         * 1
         *
         */
    }

    @Test(timeout=TIMEOUT)
    //@Description(description="PriorityQueueImpl test 7: doubles")
    public void testDoubles() {
        Double[] doubles = new Double[] {0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
        int[] ints = new int[] {6, 5, 4, 3, 2, 1};
        int[] intsRev = new int[] {0, 1, 2, 3, 4, 5, 6};

        PriorityQueueImpl q = new PriorityQueueImpl();

        assertTrue(q.isEmpty());
        assertFalse(q.isFull());

        for (Double aDouble : doubles) {
            q.enqueue(aDouble);
            assertFalse(q.isEmpty());
            assertFalse(q.isFull());
        }

        for (int i = 0; i < doubles.length; i++) {
            assertEquals(doubles[i], intsRev[i], 0.0);
        }

        for (int anInt : ints) {
            assertNotEquals(anInt, q.dequeue());
            assertFalse(q.isEmpty());
            assertFalse(q.isFull());
        }
    }

    @Test(timeout=TIMEOUT)
    //@Description(description="PriorityQueueImpl test 8: strings")
    public void testStrings() {
        // yeah im EMO who freaking cares
        String[] arguments = new String[] {"lying", "is", "the", "most", "fun",
                "a", "girl", "can", "have", "without", "taking", "her", "clothes", "off",
                "but", "its",  "better", "if", "you", "do"};
        PriorityQueueImpl queue = new PriorityQueueImpl();
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());

        for (String argument : arguments) {
            queue.enqueue(argument);
            assertFalse(queue.isEmpty());
            assertFalse(queue.isFull());
        }

        /*
         *                 lying
         *               /       \
         *              is       the
         *             /  \       /  \
         *           fun  its  most  without
         *          /    \         \        \
         *         a     girl      taking   you
         *          \        \        /
         *           can     have    off
         *          /   \       \
         *        but   clothes  her
         *        /          \     \
         *      better        do   if
         */

        String[] argumentsReverseLexo = new String[] {"you", "without", "the", "taking", "off", "most", "lying",
                "its", "is", "if", "her", "have", "girl", "fun", "do", "clothes", "can", "but", "better", "a"};

        for (int i = 0; i < argumentsReverseLexo.length - 1; i++) {
            assertEquals(argumentsReverseLexo[i], queue.dequeue());
            assertFalse(queue.isEmpty());
            assertFalse(queue.isFull());
        }

        assertEquals(argumentsReverseLexo[argumentsReverseLexo.length - 1], queue.dequeue());
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
    }

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    private static Date getDate(String date) {
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            return new Date();
        }
    }

    @Test(timeout=TIMEOUT)
    //@Description(description="PriorityQueueImpl test 9: dates")
    public void testDates() {
        Date[] dates = {
                getDate("03/26/1996"),
                getDate("01/01/1990"),
                getDate("06/14/1993"),
                getDate("11/11/2011"),
                getDate("12/25/2003"),
                getDate("09/11/2001"),
                getDate("09/11/2002"),
                getDate("01/01/2000"),
                getDate("01/02/2000"),
                getDate("12/12/2012")
        };

        PriorityQueueImpl queue = new PriorityQueueImpl();
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());

        for (Date date : dates) {
            queue.enqueue(date);
            assertFalse(queue.isEmpty());
            assertFalse(queue.isFull());
        }

        /*
         * Note: I was too lazy to put the full dates
         * in this diagram
         *
         *           1996
         *         /      \
         *      1990      2011
         *        \        /  \
         *       1993    2003 2012
         *                /  \
         *              2001 2002
         *              /
         *           01/01/2000
         *               \
         *             01/02/2000
         */

        Date[] datesRevChrono = {
                getDate("12/12/2012"),
                getDate("11/11/2011"),
                getDate("12/25/2003"),
                getDate("09/11/2002"),
                getDate("09/11/2001"),
                getDate("01/02/2000"),
                getDate("01/01/2000"),
                getDate("03/26/1996"),
                getDate("06/14/1993"),
                getDate("01/01/1990")
        };

        for (int i = 0; i < datesRevChrono.length - 1; i++) {
            assertEquals(datesRevChrono[i], queue.dequeue());
            assertFalse(queue.isEmpty());
            assertFalse(queue.isFull());
        }

        assertEquals(datesRevChrono[datesRevChrono.length - 1], queue.dequeue());
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
    }

    @Test(timeout=TIMEOUT)
    //@Description(description="PriorityQueueImpl test 10: mixed operations")
    public void testMixedOperations() {
        PriorityQueueImpl queue = new PriorityQueueImpl();
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
        queue.enqueue(3);
        queue.enqueue(1);
        queue.enqueue(2);
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());
        assertEquals(3, queue.dequeue());
        queue.enqueue(5);
        queue.enqueue(4);
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());
        assertEquals(5, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(1, queue.dequeue());
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());

        boolean expectedExceptionThrown = false;

        try {
            queue.dequeue();
            fail("PriorityQueueEmptyException not thrown for dequeue on empty");
        } catch (Exception e) {
            String exceptionSimpleName = e.getClass().getSimpleName();
            if (exceptionSimpleName.equals("PriorityQueueEmptyException")) {
                expectedExceptionThrown = true;
            }
        }

        assertTrue("PriorityQueueEmptyException not thrown for dequeue on empty", expectedExceptionThrown);
    }

    @Test(timeout=TIMEOUT)
    //@Description(description="PriorityQueueImpl test 11: simple queue")
    public void testSimplePQ() {
        PriorityQueueImpl queue = new PriorityQueueImpl();
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());

        queue.enqueue(1);
        assertFalse(queue.isEmpty());

        queue.enqueue(2);
        assertFalse(queue.isEmpty());

        assertEquals(2, queue.dequeue());
        assertFalse(queue.isEmpty());

        assertEquals(1, queue.dequeue());
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());

    }

    @Test(timeout=TIMEOUT)
    //@Description(description="PriorityQueueImpl test 12: dequeue")
    public void testDequeue() {
        PriorityQueueImpl q = new PriorityQueueImpl();
        q.enqueue(5);
        q.enqueue(2);
        q.enqueue(7);
        q.enqueue(6);
        q.enqueue(8);

        assertEquals(8, q.dequeue());
        assertEquals(7, q.dequeue());
        assertEquals(6, q.dequeue());
        assertEquals(5, q.dequeue());
        assertEquals(2, q.dequeue());
        assertTrue(q.isEmpty());
    }

    @Test(timeout=TIMEOUT)
    //@Description(description="PriorityQueueImpl test 13: delete right")
    public void fullDeletionRight() {
        PriorityQueueImpl q = new PriorityQueueImpl();
        q.enqueue(5);
        q.enqueue(6);
        assertEquals(6, q.dequeue());
        assertFalse(q.isEmpty());
        assertEquals(5, q.dequeue());
        assertTrue(q.isEmpty());
    }

    @Test(timeout=TIMEOUT)
    //@Description(description="PriorityQueueImpl test 14: delete left")
    public void fullDeletionLeft() {
        PriorityQueueImpl q = new PriorityQueueImpl();
        q.enqueue(5);
        q.enqueue(2);
        assertEquals(5, q.dequeue());
        assertFalse(q.isEmpty());
        assertEquals(2, q.dequeue());
        assertTrue(q.isEmpty());
    }

    @Test(timeout=TIMEOUT)
    //@Description(description="PriorityQueueImpl test 15: test exception")
    public void testPQEmptyException() {

        PriorityQueueImpl q = new PriorityQueueImpl();

        // enqueue 10-20
        for(int i = 10; i <= 20; i++) {
            q.enqueue(i); // shouldn't need a cast
        }

        // enqueue 0-9
        for(int j = 9; j >= 0; j--) {
            q.enqueue(j); // shouldn't need a cast
        }

        boolean expectedExceptionThrown = false;

        // try enqueuing 21, which should not throw an exception
        try {
            q.enqueue(21); // shouldn't need a cast
        } catch (Exception e) {
            fail(e.getClass().getSimpleName() + "was thrown but none was expected");
        }

        // assert no exception thrown
        assertFalse("Exception thrown but none was expected", expectedExceptionThrown);

        // dequeue values from 0-21 and check value is as expected
        for(int i = 21; i >= 0; i--) {
            assertEquals(i, q.dequeue());
        }

        assertTrue(q.isEmpty());

        // try to dequeue from empty list, which should throw a PriorityQueueEmptyException
        try {
            q.dequeue();
            fail("PriorityQueueEmptyException not thrown for dequeue on empty");
        } catch (Exception e) {
            String thrownExceptionName2 = e.getClass().getSimpleName();
            if (thrownExceptionName2.equals("PriorityQueueEmptyException")) {
                expectedExceptionThrown = true;
            }
            else {
                fail("Some other exception was thrown. " + e.getClass() + ": " + e.getMessage());
            }
        }

        assertTrue("PriorityQueueEmptyException not thrown for dequeue on empty", expectedExceptionThrown);
    }

    @Test(timeout=TIMEOUT)
    //@Description(description="PriorityQueueImpl test 16: test exception with random values")
    public void testPQEmptyExceptionsRandom() {

        PriorityQueueImpl q = new PriorityQueueImpl();

        assertTrue(q.isEmpty());
        assertFalse(q.isFull());

        ArrayList<Integer> randomList = new ArrayList<>();
        Random rand = new Random();

        int maxSize = 20;

        // make a list of random numbers
        while(randomList.size() < maxSize) {
            int random = rand.nextInt(1000);
            if (!randomList.contains(random)) {
                randomList.add(random);
            }
        }

        // enqueue randomList
        for(int randInt : randomList) {
            q.enqueue(randInt); // shouldn't need a cast
            assertFalse(q.isEmpty());
            assertFalse(q.isFull());
        }

        boolean expectedExceptionThrown = false;

        // try enqueuing a 21st number, which should not throw an exception
        try {
            q.enqueue(-1); // shouldn't need a cast
        } catch (Exception e) {
            fail(e.getClass().getSimpleName() + "was thrown but none was expected");
        }

        // assert no exception thrown
        assertFalse("PriorityQueueEmptyException thrown but none was expected", expectedExceptionThrown);

        // sort randomList for checking dequeue
        ArrayList<Integer> sortedRandList = new ArrayList<>(randomList);
        sortedRandList.sort(Collections.reverseOrder());

        // dequeue randomList values and check value is as expected
        for (int randInt : sortedRandList) {
            assertEquals(randInt, q.dequeue());
            assertFalse(q.isEmpty());
        }

        // dequeue 21st number
        q.dequeue();

        assertTrue(q.isEmpty());

        // try to dequeue from empty list, which should throw a PriorityQueueEmptyException
        try {
            q.dequeue();
            fail("PriorityQueueEmptyException not thrown for dequeue on empty");
        } catch (Exception e) {
            String thrownExceptionName2 = e.getClass().getSimpleName();
            if (thrownExceptionName2.equals("PriorityQueueEmptyException")) {
                expectedExceptionThrown = true;
            }
            else {
                fail("Some other exception was thrown. " + e.getClass() + ": " + e.getMessage());
            }
        }

        assertTrue("PriorityQueueEmptyException not thrown for dequeue on empty", expectedExceptionThrown);
    }

}