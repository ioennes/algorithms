package Sorting;

import Fundamentals.Base;
import java.util.Arrays;

public class Quicksort {

    public static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }
    private static void quicksort(int[] array, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(array, lo, hi);
        quicksort(array, lo, j - 1);
        quicksort(array, j + 1, hi);
    }
    private static int partition(int[] array, int lo, int hi) {
        int i = lo, j = hi + 1, v = array[lo];
        while (true) {
            while (array[++i] < v)
                if (i == hi) break;
            while (array[--j] > v)
                if (j == lo) break;
            if (i >= j) break;
            Base.swap(array, i, j);
        }
        Base.swap(array, lo, j);
        return j;
    }
    public static void nationalFlag(int[] array) {
        nationalFlag(array, 0, array.length - 1);
    }
    private static void nationalFlag(int[] array, int lo, int hi) {
        if (lo >= hi) return;
        int lt = lo, i = lo, gt = hi, v = 2;
        while (i <= gt) {
            if (array[i] < v) Base.swap(array, lt++, i++);
            else if (array[i] > v) Base.swap(array, gt--, i);
            else i++;
        }
    }
    public static void main(String[] args) {
        int[] a = {3, 1, 2, 1, 1, 1, 2, 2, 3};
        nationalFlag(a);
        System.out.println(Arrays.toString(a));
    }
}
