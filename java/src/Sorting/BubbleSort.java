package Sorting;

import Fundamentals.Base;

public class BubbleSort {
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean is_sorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    Base.swap(array, j, j + 1);
                    is_sorted = false;
                }
            }
            if (is_sorted) return;
        }
    }
}
