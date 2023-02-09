package datastructures.recursion;

public class CallStackExample {
    public static void main(String[] args) {
        methodOne();

        // will print Three -> Two -> One
    }

    public static void methodThree() {
        System.out.println("Three");
    }

    public static void methodTwo() {
        methodThree();
        System.out.println("Two");
    }

    public static void methodOne() {
        methodTwo();
        System.out.println("One");
    }
}
