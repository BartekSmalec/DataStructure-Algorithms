package datastructures.queue;

public class Queue {
    private Node first;
    private Node last;
    private int length;

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length++;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        last.setNext(newNode);
        last = newNode;
        length++;
    }

    public Node dequeue() {
        Node temp = first;

        first = first.getNext();
        length--;

        return temp;
    }

    public void printQueue() {
        Node temp = first;

        for (int i = 0; i < length; i++) {
            System.out.print(temp.getValue() + " --> ");
            temp = temp.getNext();
        }

        System.out.println("Length: " + length);
    }

}
