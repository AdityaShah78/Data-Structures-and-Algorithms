package a1;

import static org.junit.jupiter.api.Assertions.*;

import a1.SpecializedList;
import org.junit.jupiter.api.Test;

class SpecializedListSimpleTest {

    // the provided test case does not represent all possible cases.
    // please write your own cases to test for all possible edge scenarios within the preconditions

    @Test
    void testSpecializedListThreeElem() {
        byte elem = 3;
        byte elem2 = 4;
        byte elem3 = 5;

        SpecializedList threeList = new SpecializedList();
        assertEquals(0, threeList.lengthIs());
        threeList.insertFront(elem);
        threeList.insertEnd(elem2);
        threeList.insertEnd(elem3);
        assertEquals(3, threeList.lengthIs());

        // test iterator methods.
        // To keep with the preconditions in interface, I reset to initialize the pointer, then iterate
        threeList.resetForward();
        assertEquals(elem, threeList.getNextItem());
        threeList.resetBackward();
        assertEquals(elem3, threeList.getPriorItem());

        // where are the iterators now?
        assertEquals(elem2, threeList.getNextItem());
        assertEquals(elem2, threeList.getPriorItem());

        // test reset methods
        threeList.resetForward();
        assertEquals(elem, threeList.getNextItem());
        threeList.resetBackward();
        assertEquals(elem3, threeList.getPriorItem());
    }

    @Test
    void testSpecListBehaviour() {
        byte elem1 = 4, elem2 = 8, elem3 = 6;

        SpecializedList testList = new SpecializedList();

        assertEquals(0, testList.lengthIs()); // should be empty

        testList.insertFront(elem1);
        testList.insertEnd(elem3);

        assertEquals(2, testList.lengthIs());

        testList.resetForward(); //Pre-conditions states this is necessary before iterating getNextItem()
        assertEquals(elem1, testList.getNextItem());

        testList.resetBackward(); //Pre-condition states blah blah
        assertEquals(testList.getNextItem(), testList.getPriorItem());

        testList.insertFront(elem2);
        testList.resetForward(); // Pre-condition states blah blah
        assertEquals(elem2, testList.getNextItem());

        byte elem4 = 2;

        testList.insertEnd(elem4);
        testList.resetBackward();
        assertEquals(elem4, testList.getPriorItem());

        assertEquals(4, testList.lengthIs());

        byte listElements[] = {elem2, elem1, elem3, elem4};

        testList.resetForward();
        testList.resetBackward();

        for(int i = 0; i < listElements.length; i++) {
            assertEquals(listElements[i], testList.getNextItem());
            assertEquals(listElements[listElements.length - 1 - i], testList.getPriorItem());
        }
    }
}