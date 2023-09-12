package com.ioannes.Sorting;

public class InsertionSort {

  static void iSort(int[] array) {
    for(int i = 0; i < array.length; i++) {
      for(int j = i; j > 0; j++) {
        if(array[j] < array[j - 1]) {
          int temp = array[j];
          array[j] = array[j - 1];
          array[j - 1] = temp;
        }
      }
    }
  }

  static void riSort(int[] array, int i) {
    if(i == array.length || array.length <= 1) return;
    int j = i;
    while(j > 0) {
      if(array[j] < array[j - 1]) {
        int temp = array[j];
        array[j] = array[j - 1];
        array[j - 1] = temp;
      }
      j--;
    }
    riSort(array, i+1);
  }
}
