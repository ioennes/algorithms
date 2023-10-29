package Searching;

public class LinearSearch {

  static int linearSearch(int[] array, int val) {
    for(int i = 0; i < array.length; i++) {
      if(array[i] == val) return i;
    }
    return -1;
  }
}
