package datastructures.hashtable;

import java.util.ArrayList;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    public HashTable() {
        dataMap = new Node[size];
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChar = key.toCharArray();
        for (int i = 0; i < keyChar.length; i++) {
            int asciiValue = keyChar[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    public ArrayList keys() {
        ArrayList<String> allKeys = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while (temp != null) {
                allKeys.add(temp.getKey());
                temp = temp.getNext();
            }
        }

        return allKeys;
    }

    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }

            temp.setNext(newNode);
        }
    }

    public int get(String key) {
        int index = hash(key);
        if (dataMap[index] == null) return 0;
        Node temp = dataMap[index];
        while (temp != null) {
            if (temp.getKey().equals(key)) return temp.getValue();
            temp = temp.getNext();
        }

        return 0;
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ": ");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println(temp.getKey() + " ---> " + temp.getValue());
                temp = temp.getNext();
            }
        }
    }
}
