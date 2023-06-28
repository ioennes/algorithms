#include "../DataStructures/LinkedList.h"
#include <vector>
#include <math.h>
#include <algorithm>

std::vector<int> countingSort(const std::vector<int>& list) {
  int max = *std::max_element(list.begin(), list.end());
  std::vector<int> count(max+1, 0);
  for(int i = 0; i < list.size(); i++) {
    count[list[i]]++;
  }
  
  std::vector<int> sorted_array;
  for(int i = 0; i < count.size(); i++) {
    for(int j = 0; j < count[i]; j++) {
      sorted_array.push_back(i);
    }
  }
  
  return sorted_array;
}

void radixSort(std::vector<int>& list) {
  int max_val = *std::max_element(list.begin(), list.end());
  int max_length = std::log10(max_val) + 1;
  for(int digit_position = 0; digit_position < max_length; digit_position++) {
    std::vector<std::vector<int>> buckets(10);
    for(int num : list) {
      int digit = (num / (int)pow(10, digit_position)) % 10;
      buckets[digit].push_back(num);
    }
    list.clear();
    for (auto& bucket : buckets) {
      for (int num : bucket) {
        list.push_back(num);
      }
    }
  }
}
