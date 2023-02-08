package datastructures.dlinkedlist;

public class Main {
    public static void main(String[] args) {
        DLinkedList dLinkedList = new DLinkedList(1);

        dLinkedList.append(2);
        dLinkedList.append(3);
        dLinkedList.append(2);
        dLinkedList.append(1);
        dLinkedList.prepend(22);
        dLinkedList.prepend(15);

        dLinkedList.printList();
        dLinkedList.insert(1, 33);
        dLinkedList.printList();


        dLinkedList.remove(6);
        dLinkedList.printList();
    }
}
