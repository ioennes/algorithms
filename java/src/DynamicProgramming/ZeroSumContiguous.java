package DynamicProgramming;

import java.util.HashSet;

public class ZeroSumContiguous {
    /* In this problem, we simply keep storing the total sum of the array from 0 to i in a hashset, this is so we have
    instant lookups. If we find that the sum we're adding already exists, then between the first time it was added and
    the next, there would've been a subarray whose sum is 0.*/
    public static boolean zeroSumContiguous() {
        int[] a = {9, 3, 4, -1, -2, 1, -2, 8, 8};
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        set.add(sum);
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (set.contains(sum)) return true;
            set.add(sum);
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(zeroSumContiguous());
    }
}
