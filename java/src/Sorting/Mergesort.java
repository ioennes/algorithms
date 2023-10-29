package Sorting;

public class Mergesort {

    private static int[] aux;

    public static void mergesort(int[] a) {
        aux = new int[a.length];
        mergesort(a, 0, a.length - 1);
    }

    private static void mergesort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        mergesort(a, lo, mid);
        mergesort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }
    private static void merge(int[] array, int lo, int mid, int hi) {
        int l = lo, r = mid + 1;
        for (int i = lo; i <= hi; i++)
            aux[i] = array[i];
        for (int i = lo; i <= hi; i++) {
            if (r > hi) array[i] = aux[l++];
            else if (l > mid) array[i] = aux[r++];
            else if (aux[l] > aux[r]) array[i] = aux[r++];
            else array[i] = aux[l++];
        }
    }
    public static void main(String[] args) {
        int[] a = {2, 1, 4, 3};
        mergesort(a);
    }
}