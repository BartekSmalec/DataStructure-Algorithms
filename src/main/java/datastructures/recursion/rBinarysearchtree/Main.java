package datastructures.recursion.rBinarysearchtree;

public class Main {
    public static void main(String[] args) {
        RecursiveBTS myBST = new RecursiveBTS();

        myBST.insert(25);
        myBST.insert(15);
        myBST.insert(3);
        myBST.insert(50);
        myBST.insert(30);

        System.out.println(myBST.getRoot().getLeft().getValue());
        System.out.println(myBST.contains(2));
        System.out.println(myBST.contains(3));
        System.out.println("Recursive contains: ");
        System.out.println(myBST.recursiveContains(2));
        System.out.println(myBST.recursiveContains(3));

        myBST.recursiveInsert(5);
        myBST.recursiveInsert(8);

        System.out.println(myBST.recursiveContains(5));
        System.out.println(myBST.recursiveContains(8));

        System.out.println(myBST.getRoot().getLeft().getLeft().getValue());

        System.out.println("Minimum value: ");

        System.out.println(myBST.minValue(myBST.getRoot()));
        System.out.println(myBST.minValue(myBST.getRoot().getRight()));


    }
}
