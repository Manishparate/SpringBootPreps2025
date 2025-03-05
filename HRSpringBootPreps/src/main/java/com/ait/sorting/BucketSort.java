package com.ait.sorting;
import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    // Bucket Sort function
    public static void bucketSort(float[] arr) {
        // Step 1: Create empty buckets
        int n = arr.length;
        if (n <= 1) return;

        // Find the maximum and minimum values in the array
        float minValue = arr[0];
        float maxValue = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            } else if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        // Step 2: Create the buckets
        int bucketCount = n; // Number of buckets is equal to the number of elements
        ArrayList<Float>[] buckets = new ArrayList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<Float>();
        }

        // Step 3: Insert elements into buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) ((arr[i] - minValue) / (maxValue - minValue) * (bucketCount - 1));
            buckets[bucketIndex].add(arr[i]);
        }

        // Step 4: Sort each bucket and concatenate the result
        int index = 0;
        for (int i = 0; i < bucketCount; i++) {
            Collections.sort(buckets[i]);  // Sort each bucket (insertion sort is fine here)
            for (Float num : buckets[i]) {
                arr[index++] = num;  // Concatenate the sorted elements from the buckets
            }
        }
    }

    // Function to print the array
    public static void printArray(float[] arr) {
        for (float num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example array
        float[] arr = {0.42f, 0.32f, 0.51f, 0.23f, 0.78f, 0.91f, 0.65f};

        System.out.println("Original array:");
        printArray(arr);

        bucketSort(arr);  // Sorting the array using Bucket Sort

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
