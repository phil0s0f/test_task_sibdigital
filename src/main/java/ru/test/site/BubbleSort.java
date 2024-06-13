package ru.test.site;

public class BubbleSort {
    public static int[] sort(int[] array, Boolean asc) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if ((asc && array[j] > array[j + 1]) || (!asc && array[j] < array[j + 1])) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
