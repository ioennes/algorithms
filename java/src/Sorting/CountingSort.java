package Sorting;

import java.util.Arrays;

public class CountingSort {

    public static int[] countingSort(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        return countingSort(array, max);
    }
    private static int[] countingSort(int[] A, int max) {
        int[] C = new int[max + 1];
        int[] B = new int[A.length];
        for (int i : A) C[i]++;
        for (int i = 1; i < C.length; i++) {
            C[i] += C[i-1];
        }
        for (int i = A.length - 1; i >= 0; i--)
            B[(C[A[i]]---1)] = A[i];
        return B;
    }
    public static void main(String[] args) {
        int[] a = {9, 3, 8, 1, 8, 7, 2, 3};
        a = countingSort(a, 9);
        System.out.println(Arrays.toString(a));
    }
}
