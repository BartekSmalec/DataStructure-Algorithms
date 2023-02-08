package datastructures.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getValue() + "--> ");
            temp = temp.getNext();
        }
        System.out.println("Length: " + this.length);
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            length = 1;
        } else {
            tail.setNext(newNode);
            tail = newNode;
            length++;
        }
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        length++;
    }


    public void removeLast() {
        Node temp = head;
        Node pre = head;

        while (temp.getNext() != null) {
            pre = temp;
            temp = temp.getNext();
        }

        if (this.length == 1) this.head = null;

        this.tail = pre;
        this.tail.setNext(null);
        this.length--;
    }

    public void removeFirst() {
        if (this.length == 1) this.tail = null;
        head = head.getNext();
        length--;
    }

    public Node get(int index) {
        if (index >= length || index < 0) return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    public boolean insert(int index, int value) {

        Node temp = get(index);
        Node newNode = new Node(value);

        Node prev = get(index - 1);

        prev.setNext(newNode);
        newNode.setNext(temp);
        length++;

        return true;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);

        if (temp != null) {
            temp.setValue(value);
            return true;
        }
        return false;
    }

    public boolean remove(int index) {

        Node temp = get(index);
        Node prev = get(index - 1);

        prev.setNext(temp.getNext());
        this.length--;


        return true;
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.getNext();
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.getNext();
            temp.setNext(before);
            before = temp;
            temp = after;
        }
    }


}
