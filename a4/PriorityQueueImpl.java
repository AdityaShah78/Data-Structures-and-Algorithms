package a4;

public class PriorityQueueImpl implements PriorityQueueInterface {

    // variable to store the Priority Queue
    private BSTImpl BST;

    // variable to store the size
    private int size;

    // non argument constructor to initialize the bst
    public PriorityQueueImpl(){
        BST = new BSTImpl();
    }

    // checks if the queue is empty or not
    @Override
    public boolean isEmpty() {
        if(this.size == 0){
            return true;
        }
        else{
            return false;
        }
    }

    // checks if the queue is full or not
    @Override
    public boolean isFull() {
        return false;
    }

    // adds an int to the queue
    @Override
    public void enqueue(Comparable item) {

        // if the queue is full, throw an exception
        if(isFull()){
            throw new PriorityQueueFullException();
        }

        // insert the int
        BST.insert(item);

        // increment the size
        size++;
    }

    // removes and returns a max int
    @Override
    public Comparable dequeue() {

        // if the queue is empty, throw an exception
        if(isEmpty()){
            throw new PriorityQueueEmptyException();
        }

        // decrement the size
        size--;

        // return and delete the max int from the queue
        return BST.deleteMax();
    }

}
