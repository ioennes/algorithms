package Sorting;

import Fundamentals.Base;

import java.util.Arrays;

public class Testing {
    public static void main(String[] args) {
//        System.out.println("== SORTING 100 MILLION ELEMENTS WITH MANY EQUAL KEYS ==");
//
//        System.out.println("Mergesort: " + (float) Base.getTimeNanos(()
//                -> Mergesort.mergesort(Base.generateRandomArray(100000000, 0, 3)))/1000000000 + "s");
//        System.out.println("Quicksort: " + (float) Base.getTimeNanos(()
//                -> Quicksort.quicksort(Base.generateRandomArray(100000000, 0, 3)))/1000000000 + "s");
//        System.out.println("Heapsort: " + (float) Base.getTimeNanos(()
//                -> Heap.heapsort(Base.generateRandomArray(100000000, 0, 3)))/1000000000 + "s");
//        System.out.println("Counting Sort: " + (float) Base.getTimeNanos(()
//                -> CountingSort.countingSort(Base.generateRandomArray(100000000, 0, 3)))/1000000000 + "s");
//
//        System.out.println("== SORTING 100 MILLION ELEMENTS WITH FEW EQUAL KEYS ==");
//
//        System.out.println("Mergesort: " + (float) Base.getTimeNanos(()
//                -> Mergesort.mergesort(Base.generateRandomArray(100000000, 0, 1000000)))/1000000000 + "s");
//        System.out.println("Quicksort: " + (float) Base.getTimeNanos(()
//                -> Quicksort.quicksort(Base.generateRandomArray(100000000, 0, 1000000)))/1000000000 + "s");
        System.out.println("Heapsort: " + (float) Base.getTimeNanos(()
                -> Quicksort.quicksort(Base.generateRandomArray(100000000, 0, 100000000)))/1000000000 + "s");
        System.out.println("Counting Sort: " + (float) Base.getTimeNanos(()
                -> Quicksort.nationalFlag(Base.generateRandomArray(100000000, 0, 100000000)))/1000000000 + "s");
    }
}
