package datastructures.hashtable;

public class Main {
    public static void main(String[] args) {
        HashTable myHashTable = new HashTable();
        myHashTable.printTable();

        myHashTable.set("nails", 100);
        myHashTable.set("tile", 50);
        myHashTable.set("lumber", 80);

        myHashTable.set("bols",10);
        myHashTable.set("qweq",10);

        myHashTable.printTable();

        System.out.println("Get nails: " + myHashTable.get("nails"));
        System.out.println("Get bols: " + myHashTable.get("bols"));
        System.out.println("Get test: " + myHashTable.get("test"));

        System.out.println("Keys: " + myHashTable.keys());

    }
}
