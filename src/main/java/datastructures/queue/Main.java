package datastructures.queue;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(7);

        queue.enqueue(2);
        queue.enqueue(2);
        queue.enqueue(2);
        queue.enqueue(10);

        queue.printQueue();

        System.out.println(queue.dequeue().getValue());

        queue.printQueue();
    }
}
