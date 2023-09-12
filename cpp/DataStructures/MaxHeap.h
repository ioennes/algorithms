#include <iostream>
#include <vector>

template<typename T, class Allocator> void shrink_capacity(std::vector<T,Allocator>& v)
{
	std::vector<T,Allocator>(v.begin(),v.end()).swap(v);
}

class MaxHeap {

	private:
		std::vector<int> heap;

	public:
		MaxHeap(): heap() {};

		MaxHeap(const std::vector<int>& array): heap(array) {
			buildMaxHeap();
		}

		int getParent(int i) const {
			if(i == 0) return heap[i];
			return heap[(i - 1) / 2];
		}

		int getLeft(int i) const {
			int leftIndex = 2 * i + 1;
			if (leftIndex < heap.size()) return heap[leftIndex];
			else return -1;
		}

		int getRight(int i) const {
			int rightIndex = 2 * i + 2;
			if (rightIndex < heap.size()) return heap[rightIndex];
			else return -1;
		}

		std::vector<int> getHeap() {
			return heap;
		}

		void maxHeapify(int i, int heap_size) {
			int l = 2*i + 1;  
			int r = 2*i + 2;  
			int largest = 0;
			if(l < heap_size && heap[l] > heap[i]) largest = l;
			else largest = i;
			if(r < heap_size && heap[r] > heap[largest]) largest = r;
			if(largest != i) {
				std::swap(heap[i], heap[largest]);
				maxHeapify(largest, heap_size);
			}
		}

		void insert(int value) {
			heap.push_back(value);
			maxHeapify(0, heap.size());
		}

		int extract_max() {
			std::swap(heap[0], heap[heap.size()]);
			int result = heap[heap.size()];
			shrink_capacity(heap);
			maxHeapify(0, heap.size());
			return result;
		}

		void buildMaxHeap() {
			for(int i = heap.size() / 2; i >= 0; i--) {
				maxHeapify(i, heap.size());
			}
		}

		/* Heap Sort: Initialize k to vector.size() - 1 */

		void heapSort(int k) {
			std::swap(heap[0], heap[k]);
			maxHeapify(0, k);
			if(k != 0) heapSort(k - 1);
		}
};

std::ostream& operator<<(std::ostream& stream, const std::vector<int>& vector) {
	for (int element : vector) {
		stream << element << " ";
	}
	return stream;
}
