package Fundamentals;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.function.Supplier;

public class Base {
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    public static int[] generateRandomArray(int size, int lowerBound, int upperBound) {
        Random random = new Random();
        int[] randomArray = new int[size];

        for (int i = 0; i < size; i++) {
            int randomNum = random.nextInt(upperBound - lowerBound) + lowerBound;
            randomArray[i] = randomNum;
        }

        return randomArray;
    }
    public static long getTimeNanos(Runnable function) {
        Instant start = Instant.now();
        function.run();
        Instant end = Instant.now();
        return Duration.between(start, end).toNanos();
    }
    public static long getTimeNanos(Supplier<int[]> function) {
        Instant start = Instant.now();
        function.get();
        Instant end = Instant.now();
        return Duration.between(start, end).toNanos();
    }
}
