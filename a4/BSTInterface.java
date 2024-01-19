package a4;

//----------------------------------------------------------------------------
//
//Interface for a class that implements a Binary Search Tree of unique
//elements, i.e., no duplicate elements as defined by the key of the tree
//elements
//----------------------------------------------------------------------------

public interface BSTInterface {

    // Used to specify traversal order
    public static final int INORDER = 1;
    public static final int PREORDER = 2;
    public static final int POSTORDER = 3;

    public boolean isEmpty();
    // Effect: Determines whether this BST is empty

    public void insert (Comparable item);
    // Effect: Adds item to this BST
    // Preconditions: This BST is not full
    // Element matching item is not in this BST
    // Postcondition: Item is in this BST

    public Comparable getNextItem (int orderType);
    // Effect: For the orderType specified, it returns a copy of the element
    // at the current position pointed to for that orderType in this BST,
    // and advances the value of the current position based on the orderType.
    // If the traversal for that orderType has reached the end, loop back to
    // the first node of that traversal type.
    // Preconditions: Current position for this orderType is defined
    // There exists a BST element at current position
    // No BST transformers were called since most recent call to
    // reset
    // Postconditions: Return value = (a copy of element at current position)
    // Current position for this orderType is advanced to the next element,
    // or loops back to the first node of that orderType

    public void reset (int orderType);
    // Effect: Resets/initializes the current position for the given orderType
    // Preconditions: There is at least one element in the BST
    // Postcondition: Current position for this orderType is set to the relevant starting position
    // (refer to lecture notes - it may be different for each traversal type)
    // Also - this means there are three pointers, one for each traversal type.
}