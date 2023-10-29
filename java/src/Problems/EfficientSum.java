package Problems;

import Sorting.Quicksort;

public class EfficientSum {

	public static boolean binarySearch(int[] array, int k, int i) {
		int hi = array.length - 1, lo = 0;
		while (lo < hi) {
			int mid = (hi + lo) / 2;
			if (array[mid] == k && mid != i) return true;
			if (k < array[mid]) 
				hi = mid - 1;
			else
				lo = mid + 1;
		}
		return false;
	}

	public static boolean FindEfficientSum(int[] array,	int k) { // O(nlogn)
        Quicksort.quicksort(array);  // O(nlogn)
		boolean found = false;
		for (int i = 0; i < array.length; i++) {		  // O(nlogn)
			found = binarySearch(array, k - array[i], i); // O(logn)
			if (found) break;
		}
		return found;
	}
}
