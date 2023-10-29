package Sorting;

import Fundamentals.Base;

public class SelectionSort {
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min_index = i;
            for (int j = i; j < array.length; j++) {
                min_index = array[min_index] > array[j] ? j : min_index;
            }
            Base.swap(array, min_index, i);
        }
    }
}