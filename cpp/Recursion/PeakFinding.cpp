#include <iostream>
#include <ostream>
#include <utility>

/* One Dimensional Peak Finding */

int ODPeakHelper(int array[], int low, int high) {
  int mid = (low + high) / 2;
  if((mid == 0 || array[mid] >= array[mid + 1]) && (mid == high || array[mid] >= array[mid - 1])) {
    return mid;
  }
  if(mid > 0 && array[mid] < array[mid + 1]) return ODPeakHelper(array, mid + 1, high);
  else return ODPeakHelper(array, low, mid - 1);
}

int ODPeak(int array[], int size) {
  return ODPeakHelper(array, 0, size - 1);
}

/* Two Dimensional Peak Finding */

int getMax(int** matrix, int rows, int mid, int& max) {
  int max_idx = 0;
  for(int i = 0; i < rows; i++) {
    if(matrix[i][mid] > max) {
      max = matrix[i][mid];
      max_idx = i;
    }
  }
  return max_idx;
}

std::pair<int, int> TDPeakHelper(int** matrix, int rows, int cols, int mid_start, int mid_end) {
  int mid = (mid_start + mid_end) / 2;
  int max = 0;
  int max_idx = getMax(matrix, rows, mid, max);

  if ((mid == mid_start || max >= matrix[max_idx][mid - 1]) && 
    (mid == mid_end || max >= matrix[max_idx][mid + 1])) {
    return std::make_pair(max_idx, mid);
  }
  if(mid > mid_start && max < matrix[max_idx][mid - 1])
    return TDPeakHelper(matrix, rows, cols, mid_start, mid - 1);
  else return TDPeakHelper(matrix, rows, cols, mid + 1, mid_end);
}

std::pair<int, int> TDPeak(int** matrix, int rows, int cols) {
  return TDPeakHelper(matrix, rows, cols, 0, cols - 1);
}

template<typename i, typename j> std::ostream& operator<<(std::ostream& stream, const std::pair<i, j>& pair) {
  stream << "{" << pair.first << ", " << pair.second << "}" << std::endl;
  return stream;
}

int main() {
  int a[5] = {5, 3, 6, 2, 3};
  int n = sizeof(a)/sizeof(int);
  std::cout << "1D Peak: "<< ODPeak(a, n) << std::endl;

  int** matrix = new int*[4];
  for(int i = 0; i < 4; i++)
    matrix[i] = new int[4];

  for(int i = 0; i < 4; i++) {
    for(int j = 0; j < 4; j++) {
      matrix[i][j] = i * j;  // or some other value
    }
  }

  matrix[2][2] = 20;

  std::cout << "2D Peak: " << TDPeak(matrix, 4, 4) << std::endl;
}
