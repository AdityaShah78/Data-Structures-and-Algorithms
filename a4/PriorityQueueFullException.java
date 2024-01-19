package a4;

public class PriorityQueueFullException extends RuntimeException {
    public PriorityQueueFullException(){
        super("enqueue on priority queue full");
    }
}
