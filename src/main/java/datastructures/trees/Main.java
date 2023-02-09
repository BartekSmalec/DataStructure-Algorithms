package datastructures.trees;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(25);
        myBST.insert(15);
        myBST.insert(3);
        myBST.insert(50);
        myBST.insert(30);

        System.out.println(myBST.getRoot().getLeft().getValue());
        System.out.println(myBST.contains(2));
        System.out.println(myBST.contains(3));
    }
}
