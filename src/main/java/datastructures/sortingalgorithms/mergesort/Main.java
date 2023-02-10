package datastructures.sortingalgorithms.mergesort;

import java.util.Arrays;

import static datastructures.sortingalgorithms.mergesort.MergeSort.mergeSort;

public class Main {
    public static void main(String[] args) {
        int[] myArray = {3,20,6,4,7,8};

        System.out.println(Arrays.toString(mergeSort(myArray)));

    }
}
