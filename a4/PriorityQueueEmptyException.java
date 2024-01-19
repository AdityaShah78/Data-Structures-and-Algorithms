package a4;

public class PriorityQueueEmptyException extends RuntimeException{
    public PriorityQueueEmptyException(){
        super("dequeue on empty priority queue");
    }
}
