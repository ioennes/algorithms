package Sorting;

import Fundamentals.*;

import java.util.Arrays;

public class Shellsort {
    public static void shellsort(int[] array) {
        int swaps = 0;
        int n = array.length;
        int h = 1;
        while (h < n / 3) h = (3 * h) + 1;
        while (h >= 1) {
            for (int i = h; i < array.length; i++) {
                int j = i;
                while (j >= h && array[j] < array[j - h]) {
                    Base.swap(array, j, j - h);
                    j = j - h;
                    swaps++;
                }
            }
            h = h / 3;
        }
    }
    public static void main(String[] args) {
        int[] a = {9, 3, 4, 6, 1};
        shellsort(a);
        System.out.println(Arrays.toString(a));
    }
}
