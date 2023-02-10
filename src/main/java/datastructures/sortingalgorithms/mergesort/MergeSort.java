package datastructures.sortingalgorithms.mergesort;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] array) {
        if (array.length == 1) return array;
        int midIndex = array.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));
        return merge(left, right);
    }

    public static int[] merge(int[] arrayOne, int[] arrayTwo) {
        int[] combined = new int[arrayOne.length + arrayTwo.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < arrayOne.length && j < arrayTwo.length) {
            if (arrayOne[i] < arrayTwo[j]) {
                combined[index] = arrayOne[i];
                index++;
                i++;
            } else {
                combined[index] = arrayTwo[j];
                index++;
                j++;
            }
        }
        while (i < arrayOne.length) {
            combined[index] = arrayOne[i];
            index++;
            i++;
        }

        while (j < arrayTwo.length) {
            combined[index] = arrayTwo[j];
            index++;
            j++;
        }
        return combined;
    }
}
