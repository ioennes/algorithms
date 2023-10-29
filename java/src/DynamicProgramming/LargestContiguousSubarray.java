package DynamicProgramming;

public class LargestContiguousSubarray {
    /* In this problem, we continue adding sums until we find a value in the array who, by itself, is greater
    than the previous combined. This becomes our new starting subarray, then we continue recording the maximal
    sums until i. We keep track of the index of the max, then print it out when the array is done. In our rt
    table, we store 0 if we are starting the subarray anew (arr[i] > arr[i] + dp[i-1]) and 1 else. So from the
    last position holding 0 before our max until the max is our ideal subarray. */
    public static void largestContiguousSubarray(int[] array) {
        if (array.length == 0) return;
        int[] dp = new int[array.length];
        int[] rt = new int[array.length];
        dp[0] = array[0];
        rt[0] = 0;
        int max = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i] + dp[i - 1]) {
                rt[i] = 0;
                dp[i] = array[i];
            }
            else {
                rt[i] = 1;
                dp[i] = array[i] + dp[i - 1];
            }
            if (dp[i] > max) max = i;
        }
        System.out.println("The maximum is " + dp[max]);
        int j = max;
        while (j > 0 && rt[j] != 0) j--;
        System.out.print("The maximal subarray is ");
        for (int i = j; i <= max; i++) {
            System.out.print(array[i] + " ");
        }
    }
    public static void main(String[] args) {
        largestContiguousSubarray(new int[] {-5, -5, -3, 1, 0, 5, -1, 4, -6});
    }
}
