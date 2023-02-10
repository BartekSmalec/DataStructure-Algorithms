package datastructures.sortingalgorithms.mergesort;

public class Main {
    public static void main(String[] args) {
        int[] myArray = {12, 2, 22, 76, 34, 3, 7, 1};

    }

    public static int[] merge(int[] arrayOne, int[] arrayTwo) {
        int[] combined = new int[arrayOne.length + arrayTwo.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < arrayOne.length && j < arrayTwo.length) {
            if (arrayOne[i] > arrayTwo[j]) {
                combined[index] = arrayOne[i];
                index++;
                i++;
            } else {
                combined[index] = arrayOne[j];
                index++;
                j++;
            }
        }
        return null;
    }
}
