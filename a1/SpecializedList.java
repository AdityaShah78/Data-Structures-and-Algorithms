// Name: Aditya Shah
// Student number: 218681577
// Email: aditya78@my.yorku.ca
//--------------------------------------------------------

package a1;

public class SpecializedList implements SpecializedListInterface {

    // Helper class SListNode
    private static class SListNode {
        // private variable item of type byte to store the item in the list
        private byte item;
        // private variable SListNode pointing to the next item in the list
        private SListNode next;
        // private variable SListNode pointing to the previous item in the list
        private SListNode prev;

        // constructor to set the values for item, next and previous
        public SListNode(byte item, SListNode prev, SListNode next){
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        // public method getItem returns the item
        public byte getItem() {
            return item;
        }

        // public method getNext returns the next
        public SListNode getNext() {
            return next;
        }

        // public method getPrev return the prev
        public SListNode getPrev() {
            return prev;
        }

        // public method setNext sets the next
        public void setNext(SListNode next) {
            this.next = next;
        }

        // public method setPrev sets the prev
        public void setPrev(SListNode prev) {
            this.prev = prev;
        }

    }

    // refers to the forward of the current item in the list
    private SListNode currentForward;
    // refers to the backward of the current item in the list
    private SListNode currentBackward;
    // stores the head of the list
    private SListNode head;
    // stores the tail of the list
    private SListNode tail;
    // stores the size of the list
    private int size = 0;

    // constructor to create an empty list
    public SpecializedList() {
    }

    // method to get the size of the list
    public int getSize(){
        return size;
    }

    // method to check if the list is empty
    public boolean isEmpty(){
        return size == 0;
    }

    // resets the forward of the list
    @Override
    public void resetForward() {
        currentForward = head;
    }

    // gets the current item of the list and advances the pointer to the next element in the list
    @Override
    public byte getNextItem() {
        SListNode temp;
        if(currentForward == null){
            temp = head;
        }
        else {
            temp = currentForward;
        }
        currentForward = temp.next;
        return temp.item;
    }

    // resets the backward of the list
    @Override
    public void resetBackward() {
        currentBackward = tail;
    }

    // gets the current backward item of the list and advances the pointer to the previous element in the list
    @Override
    public byte getPriorItem() {
        SListNode temp;
        if(currentBackward == null){
            temp = tail;
        }
        else{
            temp= currentBackward;
        }
        currentBackward = temp.prev;
        return temp.item;
    }

    // method returns the size of the list
    @Override
    public int lengthIs() {
        return getSize();
    }

    // method is called to insert an item at the front of the list
    @Override
    public void insertFront(byte item) {
        if(isEmpty()){
            head = new SListNode(item, null, null);
            tail = head;
        }
        else {
            SListNode temp = head;
            head = new SListNode(item, null, temp.prev);
            temp.setPrev(head);
            head.setPrev(null);
            head.setNext(temp);
        }
        size++;
        currentForward = head;
        currentBackward = tail;
    }

    // method is called to insert an item at the end of the list
    @Override
    public void insertEnd(byte item) {
        if(isEmpty()){
            tail = new SListNode(item, null, null);
            head = tail;
        }
        else {
            SListNode temp = tail;
            tail = new SListNode(item, temp.next, null);
            temp.setNext(tail);
            tail.setPrev(temp);
            tail.setNext(null);
        }
        size++;
        currentForward = head;
        currentBackward = tail;
    }

}