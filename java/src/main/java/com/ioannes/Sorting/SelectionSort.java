package com.ioannes.Sorting;

public class SelectionSort {

  static void sSort(int[] array) {
    for(int i = 0; i < array.length; i++) {
      int min = i;
      for(int j = i + 1; j < array.length; j++) {
        if(array[min] > array[j]) min = j;
      }
      int temp = array[min];
      array[min] = array[i];
      array[i] = temp;
    }
  }

  static void rsSort(int[] array, int i) {
    if(i == array.length) return;
    int min = i;
    for(int j = i + 1; j < array.length; j++) {
      if(array[min] > array[j]) min = j;
    }
    int temp = array[min];
    array[min] = array[i];
    array[i] = temp;

    rsSort(array, i + 1);
  }
}
