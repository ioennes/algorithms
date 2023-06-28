package Searching;

public class BinarySearch {

  static int binarySearch(int[] array, int val) {
    
    int low = 0;
    int high = array.length - 1;

    while(high >= low) {
      
      int mid = (high + low) / 2;
      if(array[mid] == val) return mid;
      else if(array[mid] > val) high = mid - 1;
      else low = mid + 1;
    }
    return -1;
  }

  static int rBinarySearch(int[] array, int val, int high, int low) {

    if(high > low) return -1;

    int mid = (high + low) / 2;
    if(array[mid] == val) return mid;
    if(array[mid] > val)
      return rBinarySearch(array, val, mid - 1, low);
    else return rBinarySearch(array, val, high, mid + 1);
  }
}
