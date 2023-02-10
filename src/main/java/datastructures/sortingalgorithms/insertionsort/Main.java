package datastructures.sortingalgorithms.insertionsort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] myArray = {12, 2, 22, 76, 34, 3, 7, 1};
        insertionSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }

    public static void insertionSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i -1;
            while(j > -1 && temp <array[j]){
                array[j+1] = array[j];
                array[j] = temp;
                j--;
            }
        }
    }
}
