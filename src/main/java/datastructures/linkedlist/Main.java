package datastructures.linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(4);

        myLinkedList.append(8);
        myLinkedList.append(5);
        myLinkedList.append(6);
        myLinkedList.append(2);
        myLinkedList.append(5);
        myLinkedList.append(10);

        myLinkedList.printList();

        myLinkedList.removeLast();
        myLinkedList.removeLast();

        myLinkedList.printList();

        myLinkedList.removeFirst();

        myLinkedList.printList();

        myLinkedList.prepend(1);
        myLinkedList.printList();

        myLinkedList.insert(1, 91);
        myLinkedList.printList();

        myLinkedList.set(1, 22);
        myLinkedList.printList();

        myLinkedList.remove(2);
        myLinkedList.printList();

        myLinkedList.reverse();
        myLinkedList.printList();

        //System.out.println(myLinkedList.get(4).getValue());


    }
}
