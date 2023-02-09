package datastructures.interview;

import java.util.HashMap;

public class Arrays {
    public static void main(String[] args) {
        // Check if two arrays contains any the same element ?
        int[] one = new int[3];
        one[0] = 1;
        one[1] = 3;
        one[2] = 5;

        int[] two = new int[3];
        two[0] = 2;
        two[1] = 4;
        two[2] = 6;

        System.out.println(itemInCommon(one, two));
        System.out.println(itemInCommonUsingHashMap(one, two));
    }

    // insufficient O(n^2)
    public static boolean itemInCommon(int[] arrOne, int[] arrTwo) {
        for (int one : arrOne) {
            for (int two : arrTwo) {
                if (one == two) return true;
            }
        }
        return false;
    }

    // Efficient O(n)
    public static boolean itemInCommonUsingHashMap(int[] arrOne, int[] arrTwo) {
        HashMap<Integer, Boolean> myHashMap = new HashMap<>();

        for (int i : arrOne) {
            myHashMap.put(i, true);
        }
        for (int i : arrTwo) {
            if (myHashMap.get(i) != null) return true;
        }

        return false;
    }
}
