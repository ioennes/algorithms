#include <iostream>

void merge(int* array, int left, int mid, int right) {
  
  int left_size = mid - left + 1;
  int right_size = right - mid;

  int* left_array = new int[left_size], *right_array = new int[right_size];

  for(int i = 0; i < left_size; i++) {
    left_array[i] = array[left + i];
  }

  for(int j = 0; j < right_size; j++) {
    right_array[j] = array[mid + 1 + j];
  }

  int i = 0, j = 0;
  int k = left;

  while(i < left_size || j < right_size) {
    if(j >= left_size || (i < left_size && left_array[i] <= right_array[j])) {
      array[k] = left_array[i];
      i++;
    }
    else {
      array[k] = right_array[j];
      j++;
    }
    k++;
  }
  delete[] left_array;
  delete[] right_array;
}

void mergeSort(int* array, int left, int right) {
  if(left >= right) return;
  int mid = left + (right - left) / 2;
  mergeSort(array, left, mid);
  mergeSort(array, mid + 1, right);
  merge(array, left, mid, right);
}
