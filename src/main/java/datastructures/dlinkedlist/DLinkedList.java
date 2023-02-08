package datastructures.dlinkedlist;

public class DLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DLinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length++;
    }

    public void append(int value) {
        Node node = new Node(value);
        node.setPrev(this.tail);
        this.tail.setNext(node);
        this.tail = node;

        this.length++;
    }

    public void printList() {
        Node temp = this.head;
        for (int i = 0; i < this.length; i++) {
            System.out.print(temp.getValue() + "-->");
            temp = temp.getNext();
        }

        System.out.println("Length : " + this.length);
    }

    public void removeLast() {
        this.tail.getPrev().setNext(null);
        this.length--;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        newNode.setNext(this.head);
        this.head.setPrev(newNode);

        this.head = newNode;
        length++;
    }

    public void removeFirst() {
        this.head.getNext().setPrev(null);
        this.head = this.head.getNext();
        this.length--;
    }

    public Node get(int index) {
        Node temp = this.head;
        if (index < 0 || index >= length) return null;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }

        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        temp.setValue(value);
        return true;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void insert(int index, int value) {
        Node newNode = new Node(value);

        Node prev = get(index).getPrev();
        Node next = get(index);

        newNode.setPrev(prev);
        prev.setNext(newNode);

        newNode.setNext(next);
        next.setPrev(newNode);

        length++;

    }

    public void remove(int index){
        Node prev = get(index).getPrev();
        Node next = get(index).getNext();

        prev.setNext(next);
        next.setPrev(prev);

        length--;
    }
}
