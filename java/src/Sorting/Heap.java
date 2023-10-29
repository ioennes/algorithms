package Sorting;

import java.util.Arrays;

public class Heap {

	private static final int SENTINEL = 0;
	private int[] heap;
	private int size;
	public Heap() {
		heap = new int[1];
		heap[0] = SENTINEL;
		size = 0;
	}
	private void swap(int index_1, int index_2) {
		int temp = heap[index_1];
		heap[index_1] = heap[index_2];
		heap[index_2] = temp;
	}
	private void ensureCapacity() {
		int[] new_heap = new int[heap.length * 2];
        System.arraycopy(heap, 0, new_heap, 0, heap.length);
		heap = new_heap;
	}
	public int getParent(int index) {
		return index / 2;
	}
	public int getLeft(int index) {
		return index * 2 > size ? SENTINEL : index * 2;
	}
	public int getRight(int index) {
		return (index * 2) + 1 > size ? SENTINEL : (index * 2) + 1;
	}
	public void swim(int index) {
		if (index == 1) return;
		while (index != 1 && heap[index] > heap[getParent(index)]) {
			swap(index, getParent(index));
			index = getParent(index);
		}
	}
	public void sink(int index) {
		while ((getLeft(index) != SENTINEL || getRight(index) != SENTINEL) 
				&& (heap[index] < heap[getLeft(index)] || heap[index] < heap[getRight(index)])) {
			int largest = heap[getLeft(index)] > heap[getRight(index)] ? getLeft(index) : getRight(index);
			swap(index, largest);
			index = largest;
		}
	}
	public void insert(int key) {
		if (size == heap.length - 1) ensureCapacity();
		heap[++size] = key;
		swim(size);
	}
	public int extractMax() {
		if (size == 0) return SENTINEL;
		int result = heap[1];
		heap[1] = SENTINEL;
		swap(1, size--);
		sink(1);
		return result;
	}
	public void buildMaxHeap() {
		for (int i = size / 2; i >= 1; i--)
			sink(i);
	}
	public void heapsort() {
		buildMaxHeap();
		while (size != 0)
			heap[size] = extractMax();
	}
	public int[] getHeap() {
		return Arrays.copyOfRange(heap, 1, heap.length);
	}
	public static void heapsort(int[] array) {
		Heap heap = new Heap();
		for (int i = 0; i < array.length; i++) {
			heap.insert(array[i]);
		}
		heap.heapsort();
		int[] sortedHeap = heap.getHeap();
		System.arraycopy(sortedHeap, 0, array, 0, array.length);
	}
}