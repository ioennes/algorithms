public class MergeSort {

  public static void merge(int[] array, int left, int mid, int right) {
    int left_size = mid - left + 1;
    int right_size = right - mid;

    int[] left_array = new int[left_size], right_array = new int[right_size];

    for(int i = 0; i < left_size; i++) {
      left_array[i] = array[left + i];
    }
    for(int i = 0; i < right_size; i++) {
      right_array[i] = array[mid + i + 1];
    }

    int i = 0; int j = 0;
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
  }

  public static void mergeSort(int[] array, int left, int right) {
    if(array.length <= 1) return;
    int mid = left + (right - left) / 2;
    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);
  }
}

