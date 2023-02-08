package datastructures.stack;

public class Stack {
    private Node top;
    private int height;

    public Stack(int value) {
        Node newNode = new Node(value);
        this.top = newNode;
        this.height++;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (height == 0) {
            this.top = newNode;
        } else {
            newNode.setNext(this.top);
            this.top = newNode;
        }

        this.height++;
    }

    public void printStack() {
        Node temp = this.top;
        for (int i = 0; i < this.height; i++) {
            System.out.print(temp.getValue() + " -> ");
            temp = temp.getNext();
        }
    }

    public Node pop() {
        Node returnedNode = this.top;

        this.top = returnedNode.getNext();
        this.height--;

        return returnedNode;
    }

}
