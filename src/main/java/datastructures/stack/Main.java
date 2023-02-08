package datastructures.stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(1);
        stack.push(2);
        stack.push(3);
        stack.push(55);

        stack.printStack();
        stack.pop();
        stack.pop();
        stack.push(22);

        System.out.println("\n");
        stack.printStack();
    }
}
