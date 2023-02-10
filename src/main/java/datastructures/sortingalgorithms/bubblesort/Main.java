package datastructures.sortingalgorithms.bubblesort;

public class Main {
    public static void main(String[] args) {
        int[] myArray = {12, 2, 22, 76, 34, 3, 7, 1};
        bubbleSort(myArray);
        for(int number: myArray){
            System.out.print(number + " ");
        }
    }

    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i < 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
