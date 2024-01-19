package a4;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;
import static org.junit.Assert.*;

public class BSTImplTest {
    public static final int TIMEOUT = 500;

    @Test(timeout=TIMEOUT)
    // @Description(description="BSTImpl test 1: empty BST")
    public void testBSTEmpty() {
        BSTImpl bst = new BSTImpl();
        assertTrue(bst.isEmpty());
    }

    @Test(timeout=TIMEOUT)
    // @Description(description="BSTImpl test 2: one node")
    public void testOneNode() {
        BSTImpl bst = new BSTImpl();
        assertTrue(bst.isEmpty());
        bst.insert(1);
        assertFalse(bst.isEmpty());
    }

    @Test(timeout=TIMEOUT)
    // @Description(description="BSTImpl test 3: Iterative max")
    public void testIterativeMaxEasy() {
        BSTImpl bst = new BSTImpl();
        assertTrue(bst.isEmpty());
        bst.insert(1);
        bst.insert(3);
        assertFalse(bst.isEmpty());
        assertEquals(3, bst.iterMax());
    }

    @Test(timeout=TIMEOUT)
    // @Description(description="BSTImpl test 4: Iterative max negative")
    public void testIterativeMaxNegEasy() {
        BSTImpl bst = new BSTImpl();
        assertTrue(bst.isEmpty());
        bst.insert(-1);
        bst.insert(-3);
        assertFalse(bst.isEmpty());
        assertEquals(-1, bst.iterMax());
    }

    @Test(timeout=TIMEOUT)
    // @Description(description="BSTImpl test 5: recursive max")
    public void testRecursiveMaxEasy() {
        BSTImpl bst = new BSTImpl();
        assertTrue(bst.isEmpty());
        bst.insert(1);
        bst.insert(3);
        assertFalse(bst.isEmpty());
        assertEquals(3, bst.recMax());
    }

    @Test(timeout=TIMEOUT)
    // @Description(description="BSTImpl test 6: recursive max negative")
    public void testRecursiveMaxNegEasy() {
        BSTImpl bst = new BSTImpl();
        assertTrue(bst.isEmpty());
        bst.insert(-1);
        bst.insert(-3);
        assertFalse(bst.isEmpty());
        assertEquals(-1, bst.recMax());
    }

    @Test(timeout=TIMEOUT)
    // @Description(description="BSTImpl test 7: max random 1")
    public void testMaxRandom1() {
        Random rd = new Random();
        // NOTE: cannot go more than 31, for those who did array-based implementation
        // This is because if the tree is unbalanced fully left or fully right, then it could exceed the space
        int maxElems = 10 + rd.nextInt(15); // [10, 25)

        // new addition starts here
        ArrayList<Integer> ints = new ArrayList<>();

        int instantiate = 0;
        while (instantiate < maxElems) {
            int insValue = rd.nextInt();
            if (!ints.contains(insValue)) {
                ints.add(insValue);
                instantiate++;
            }
        }

        int max = ints.get(0);

        // new addition ends  here

        BSTImpl bst = new BSTImpl();
        assertTrue(bst.isEmpty());

        bst.insert(max);
        assertFalse(bst.isEmpty());
        assertEquals(max, bst.iterMax());
        assertEquals(max, bst.recMax());

        for (int i = 1; i < maxElems; i++) {
            // modified to get elements from the existing arraylist
            bst.insert(ints.get(i));
            if (ints.get(i) > max) {
                max = ints.get(i);
            }
            // ensure the max is updated always
            assertEquals(max, bst.iterMax());
            assertEquals(max, bst.recMax());
        }
    }

    @Test(timeout=TIMEOUT)
    // @Description(description="BSTImpl test 8: max random 2")
    public void testMaxRandom2() {
        Random rd = new Random();
        // NOTE: cannot go more than 31, for those who did array-based implementation
        // This is because if the tree is unbalanced fully left or fully right, then it could exceed the space
        int maxElems = 10 + rd.nextInt(15); // [10, 25)

        // new addition starts here
        ArrayList<Integer> ints = new ArrayList<>();

        int instantiate = 0;
        while (instantiate < maxElems) {
            int insValue = rd.nextInt();
            if (!ints.contains(insValue)) {
                ints.add(insValue);
                instantiate++;
            }
        }

        int max = ints.get(0);

        // new addition ends  here

        BSTImpl bst = new BSTImpl();
        assertTrue(bst.isEmpty());

        bst.insert(max);
        assertFalse(bst.isEmpty());
        assertEquals(max, bst.iterMax());
        assertEquals(max, bst.recMax());

        for (int i = 1; i < maxElems; i++) {
            // modified to get elements from the existing arraylist
            bst.insert(ints.get(i));
            if (ints.get(i) > max) {
                max = ints.get(i);
            }
            // ensure the max is updated always
            assertEquals(max, bst.iterMax());
            assertEquals(max, bst.recMax());
        }
    }

    @Test(timeout=TIMEOUT)
    // @Description(description="BSTImpl test 9: max random 3")
    public void testMaxRandom3() {
        Random rd = new Random();
        // NOTE: cannot go more than 31, for those who did array-based implementation
        // This is because if the tree is unbalanced fully left or fully right, then it could exceed the space
        int maxElems = 10 + rd.nextInt(15); // [10, 25)

        // new addition starts here
        ArrayList<Integer> ints = new ArrayList<>();

        int instantiate = 0;
        while (instantiate < maxElems) {
            int insValue = rd.nextInt();
            if (!ints.contains(insValue)) {
                ints.add(insValue);
                instantiate++;
            }
        }

        int max = ints.get(0);

        // new addition ends  here

        BSTImpl bst = new BSTImpl();
        assertTrue(bst.isEmpty());

        bst.insert(max);
        assertFalse(bst.isEmpty());
        assertEquals(max, bst.iterMax());
        assertEquals(max, bst.recMax());

        for (int i = 1; i < maxElems; i++) {
            // modified to get elements from the existing arraylist
            bst.insert(ints.get(i));
            if (ints.get(i) > max) {
                max = ints.get(i);
            }
            // ensure the max is updated always
            assertEquals(max, bst.iterMax());
            assertEquals(max, bst.recMax());
        }
    }

    @Test(timeout=TIMEOUT)
    // @Description(description="BSTImpl test 10: max random 4")
    public void testMaxRandom4() {
        Random rd = new Random();
        // NOTE: cannot go more than 31, for those who did array-based implementation
        // This is because if the tree is unbalanced fully left or fully right, then it could exceed the space
        int maxElems = 10 + rd.nextInt(15); // [10, 25)

        // new addition starts here
        ArrayList<Integer> ints = new ArrayList<>();

        int instantiate = 0;
        while (instantiate < maxElems) {
            int insValue = rd.nextInt();
            if (!ints.contains(insValue)) {
                ints.add(insValue);
                instantiate++;
            }
        }

        int max = ints.get(0);

        // new addition ends  here

        BSTImpl bst = new BSTImpl();
        assertTrue(bst.isEmpty());

        bst.insert(max);
        assertFalse(bst.isEmpty());
        assertEquals(max, bst.iterMax());
        assertEquals(max, bst.recMax());

        for (int i = 1; i < maxElems; i++) {
            // modified to get elements from the existing arraylist
            bst.insert(ints.get(i));
            if (ints.get(i) > max) {
                max = ints.get(i);
            }
            // ensure the max is updated always
            assertEquals(max, bst.iterMax());
            assertEquals(max, bst.recMax());
        }
    }

    @Test(timeout=TIMEOUT)
    // @Description(description="BSTImpl test 11: max random 5")
    public void testMaxRandom5() {
        Random rd = new Random();
        // NOTE: cannot go more than 31, for those who did array-based implementation
        // This is because if the tree is unbalanced fully left or fully right, then it could exceed the space
        int maxElems = 10 + rd.nextInt(15); // [10, 25)

        // new addition starts here
        ArrayList<Integer> ints = new ArrayList<>();

        int instantiate = 0;
        while (instantiate < maxElems) {
            int insValue = rd.nextInt();
            if (!ints.contains(insValue)) {
                ints.add(insValue);
                instantiate++;
            }
        }

        int max = ints.get(0);

        // new addition ends  here

        BSTImpl bst = new BSTImpl();
        assertTrue(bst.isEmpty());

        bst.insert(max);
        assertFalse(bst.isEmpty());
        assertEquals(max, bst.iterMax());
        assertEquals(max, bst.recMax());

        for (int i = 1; i < maxElems; i++) {
            // modified to get elements from the existing arraylist
            bst.insert(ints.get(i));
            if (ints.get(i) > max) {
                max = ints.get(i);
            }
            // ensure the max is updated always
            assertEquals(max, bst.iterMax());
            assertEquals(max, bst.recMax());
        }
    }

    @Test(timeout=TIMEOUT)
    // @Description(description="BSTImpl test 12: small inorder traversal")
    public void testSmallInorderTraversal() {
        BSTImpl bst = new BSTImpl();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(20);
        bst.reset(BSTInterface.INORDER);
        assertEquals(3, bst.getNextItem(BSTInterface.INORDER));
        assertEquals(5, bst.getNextItem(BSTInterface.INORDER));
        assertEquals(7, bst.getNextItem(BSTInterface.INORDER));
        assertEquals(10, bst.getNextItem(BSTInterface.INORDER));
        assertEquals(12, bst.getNextItem(BSTInterface.INORDER));
        assertEquals(15, bst.getNextItem(BSTInterface.INORDER));
        assertEquals(20, bst.getNextItem(BSTInterface.INORDER)); // should move pointer to reset Position
        assertEquals(3,bst.getNextItem(BSTInterface.INORDER));
    }

    @Test(timeout=TIMEOUT)
    // @Description(description="BSTImpl test 13: small preorder traversal")
    public void testSmallPreorderTraversal() {
        BSTImpl bst = new BSTImpl();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(20);
        bst.reset(BSTInterface.PREORDER);
        assertEquals(10, bst.getNextItem(BSTInterface.PREORDER));
        assertEquals(5, bst.getNextItem(BSTInterface.PREORDER));
        assertEquals(3, bst.getNextItem(BSTInterface.PREORDER));
        assertEquals(7, bst.getNextItem(BSTInterface.PREORDER));
        assertEquals(15, bst.getNextItem(BSTInterface.PREORDER));
        assertEquals(12, bst.getNextItem(BSTInterface.PREORDER));
        assertEquals(20, bst.getNextItem(BSTInterface.PREORDER)); //this should move pointer to reset Position
        assertEquals(10,bst.getNextItem(BSTInterface.PREORDER));
    }

    @Test(timeout=TIMEOUT)
    // @Description(description="BSTImpl test 14: small postorder traversal")
    public void testSmallPostorderTraversal() {
        BSTImpl bst = new BSTImpl();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(20);

        bst.reset(BSTInterface.POSTORDER);

        assertEquals(3, bst.getNextItem(BSTInterface.POSTORDER));
        assertEquals(7, bst.getNextItem(BSTInterface.POSTORDER));
        assertEquals(5, bst.getNextItem(BSTInterface.POSTORDER));
        assertEquals(12, bst.getNextItem(BSTInterface.POSTORDER));
        assertEquals(20, bst.getNextItem(BSTInterface.POSTORDER));
        assertEquals(15, bst.getNextItem(BSTInterface.POSTORDER));
        assertEquals(10, bst.getNextItem(BSTInterface.POSTORDER)); //should move pointer to reset Position
        assertEquals(3,bst.getNextItem(BSTInterface.POSTORDER));
    }

    @Test(timeout=TIMEOUT)
    // @Description(description="BSTImpl test 15: large inorder traversal")
    public void testLargeInorderTraversal() {
        BSTImpl bst = new BSTImpl();
        bst.insert(100);//1
        bst.insert(25);//2
        bst.insert(200);//2
        bst.insert(1);//3
        bst.insert(99);//3
        bst.insert(150);//3
        bst.insert(400);//3
        bst.insert(90);//4
        bst.insert(125);//4
        bst.insert(500);//4
        bst.insert(80);//5
        bst.insert(115);//5
        bst.insert(145);//5
        bst.insert(450);//5
        bst.insert(85);//6
        bst.insert(110);//6
        bst.insert(120);//6
        bst.insert(149);//6
        bst.insert(114);//7
        bst.insert(117);//7
        bst.reset(BSTInterface.INORDER);
        assertEquals(1, bst.getNextItem(BSTInterface.INORDER));
        assertEquals(25, bst.getNextItem(BSTInterface.INORDER));
        assertEquals(80, bst.getNextItem(BSTInterface.INORDER));
        assertEquals(85, bst.getNextItem(BSTInterface.INORDER));
        assertEquals(90, bst.getNextItem(BSTInterface.INORDER));
        assertEquals(99, bst.getNextItem(BSTInterface.INORDER));
        assertEquals(100, bst.getNextItem(BSTInterface.INORDER));
        assertEquals(110,bst.getNextItem(BSTInterface.INORDER));

        assertEquals(114, bst.getNextItem(BSTInterface.INORDER));
        assertEquals(115, bst.getNextItem(BSTInterface.INORDER));
        assertEquals(117, bst.getNextItem(BSTInterface.INORDER));
        assertEquals(120, bst.getNextItem(BSTInterface.INORDER));
        assertEquals(125, bst.getNextItem(BSTInterface.INORDER));
        assertEquals(145, bst.getNextItem(BSTInterface.INORDER));
        assertEquals(149, bst.getNextItem(BSTInterface.INORDER));
        assertEquals(150,bst.getNextItem(BSTInterface.INORDER));

        assertEquals(200, bst.getNextItem(BSTInterface.INORDER));
        assertEquals(400, bst.getNextItem(BSTInterface.INORDER));
        assertEquals(450, bst.getNextItem(BSTInterface.INORDER));
        assertEquals(500, bst.getNextItem(BSTInterface.INORDER));
        assertEquals(1, bst.getNextItem(BSTInterface.INORDER));// should move pointer to reset Position
    }

    @Test(timeout=TIMEOUT)
    // @Description(description="BSTImpl test 16: large preorder traversal")
    public void testLargePreorderTraversal() {
        BSTImpl bst = new BSTImpl();
        bst.insert(100);//1
        bst.insert(25);//2
        bst.insert(200);//2
        bst.insert(1);//3
        bst.insert(99);//3
        bst.insert(150);//3
        bst.insert(400);//3
        bst.insert(90);//4
        bst.insert(125);//4
        bst.insert(500);//4
        bst.insert(80);//5
        bst.insert(115);//5
        bst.insert(145);//5
        bst.insert(450);//5
        bst.insert(85);//6
        bst.insert(110);//6
        bst.insert(120);//6
        bst.insert(149);//6
        bst.insert(114);//7
        bst.insert(117);//7
        bst.reset(BSTInterface.PREORDER);
        assertEquals(100, bst.getNextItem(BSTInterface.PREORDER));
        assertEquals(25, bst.getNextItem(BSTInterface.PREORDER));
        assertEquals(1, bst.getNextItem(BSTInterface.PREORDER));
        assertEquals(99, bst.getNextItem(BSTInterface.PREORDER));
        assertEquals(90, bst.getNextItem(BSTInterface.PREORDER));
        assertEquals(80, bst.getNextItem(BSTInterface.PREORDER));
        assertEquals(85, bst.getNextItem(BSTInterface.PREORDER));
        assertEquals(200,bst.getNextItem(BSTInterface.PREORDER));

        assertEquals(150, bst.getNextItem(BSTInterface.PREORDER));
        assertEquals(125, bst.getNextItem(BSTInterface.PREORDER));
        assertEquals(115, bst.getNextItem(BSTInterface.PREORDER));
        assertEquals(110, bst.getNextItem(BSTInterface.PREORDER));
        assertEquals(114, bst.getNextItem(BSTInterface.PREORDER));
        assertEquals(120, bst.getNextItem(BSTInterface.PREORDER));
        assertEquals(117, bst.getNextItem(BSTInterface.PREORDER));
        assertEquals(145,bst.getNextItem(BSTInterface.PREORDER));

        assertEquals(149, bst.getNextItem(BSTInterface.PREORDER));
        assertEquals(400, bst.getNextItem(BSTInterface.PREORDER));
        assertEquals(500, bst.getNextItem(BSTInterface.PREORDER));
        assertEquals(450, bst.getNextItem(BSTInterface.PREORDER));// should move pointer to reset Position
        assertEquals(100, bst.getNextItem(BSTInterface.PREORDER));
    }

    @Test(timeout=TIMEOUT)
    // @Description(description="BSTImpl test 17: large postorder traversal")
    public void testLargePostorderTraversal() {
        BSTImpl bst = new BSTImpl();
        bst.insert(100);//1
        bst.insert(25);//2
        bst.insert(200);//2
        bst.insert(1);//3
        bst.insert(99);//3
        bst.insert(150);//3
        bst.insert(400);//3
        bst.insert(90);//4
        bst.insert(125);//4
        bst.insert(500);//4
        bst.insert(80);//5
        bst.insert(115);//5
        bst.insert(145);//5
        bst.insert(450);//5
        bst.insert(85);//6
        bst.insert(110);//6
        bst.insert(120);//6
        bst.insert(149);//6
        bst.insert(114);//7
        bst.insert(117);//7
        bst.reset(BSTInterface.POSTORDER);
        assertEquals(1, bst.getNextItem(BSTInterface.POSTORDER));
        assertEquals(85, bst.getNextItem(BSTInterface.POSTORDER));
        assertEquals(80, bst.getNextItem(BSTInterface.POSTORDER));
        assertEquals(90, bst.getNextItem(BSTInterface.POSTORDER));
        assertEquals(99, bst.getNextItem(BSTInterface.POSTORDER));
        assertEquals(25, bst.getNextItem(BSTInterface.POSTORDER));
        assertEquals(114, bst.getNextItem(BSTInterface.POSTORDER));
        assertEquals(110,bst.getNextItem(BSTInterface.POSTORDER));

        assertEquals(117, bst.getNextItem(BSTInterface.POSTORDER));
        assertEquals(120, bst.getNextItem(BSTInterface.POSTORDER));
        assertEquals(115, bst.getNextItem(BSTInterface.POSTORDER));
        assertEquals(149, bst.getNextItem(BSTInterface.POSTORDER));
        assertEquals(145, bst.getNextItem(BSTInterface.POSTORDER));
        assertEquals(125, bst.getNextItem(BSTInterface.POSTORDER));
        assertEquals(150, bst.getNextItem(BSTInterface.POSTORDER));
        assertEquals(450,bst.getNextItem(BSTInterface.POSTORDER));

        assertEquals(500, bst.getNextItem(BSTInterface.POSTORDER));
        assertEquals(400, bst.getNextItem(BSTInterface.POSTORDER));
        assertEquals(200, bst.getNextItem(BSTInterface.POSTORDER));
        assertEquals(100, bst.getNextItem(BSTInterface.POSTORDER));// should move pointer to reset Position
        assertEquals(1, bst.getNextItem(BSTInterface.POSTORDER));
    }

    @Test(timeout=TIMEOUT)
    // @Description(description="BSTImpl test 18: mixed traversals")
    public void testTraversal() {
        int[] arr = { 200, 150, 140, 160, 165, 164, 166, 145, 143, 147, 144, 146, 130, 135, 131, 136, 210, 205, 204,
                206, 208, 207, 209, 215, 214 };

        int[] postOrder = { 131, 136, 135, 130, 144, 143, 146, 147, 145, 140, 164, 166, 165, 160, 150, 204, 207, 209,
                208, 206, 205, 214, 215, 210, 200 };
        int[] preOrder = { 200, 150, 140, 130, 135, 131, 136, 145, 143, 144, 147, 146, 160, 165, 164, 166, 210, 205,
                204, 206, 208, 207, 209, 215, 214 };
        int[] inOrder = { 130, 131, 135, 136, 140, 143, 144, 145, 146, 147, 150, 160, 164, 165, 166, 200, 204, 205, 206,
                207, 208, 209, 210, 214, 215 };

        BSTImpl bst = new BSTImpl();

        for (int element : arr)
            bst.insert(element);

        bst.reset(BSTImpl.INORDER);
        bst.reset(BSTImpl.PREORDER);
        bst.reset(BSTImpl.POSTORDER);

        for (int i = 0; i < arr.length; i++) {
            assertEquals(inOrder[i], bst.getNextItem(BSTImpl.INORDER));
            assertEquals(preOrder[i], bst.getNextItem(BSTImpl.PREORDER));
            assertEquals(postOrder[i], bst.getNextItem(BSTImpl.POSTORDER));
        }

        // assert looped back after traversals reached their end
        assertEquals(inOrder[0], bst.getNextItem(BSTImpl.INORDER));
        assertEquals(preOrder[0], bst.getNextItem(BSTImpl.PREORDER));
        assertEquals(postOrder[0], bst.getNextItem(BSTImpl.POSTORDER));

    }
}