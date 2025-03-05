package com.ait.test;

import java.util.Arrays;

public class mMyClass {

	public static void main(String[] args) {
		int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
		int end = arr[arr.length - 1]; // Choose the rightmost element as pivot
		int start = 0;

//		bubbleSort(arr);
		quickSort(arr, start, end);

	}

	private static void bubbleSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println("Sorted array: ");
		System.out.println(Arrays.toString(arr));
	}

	static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			// Find pivot element such that element smaller than pivot are on the left and
			// greater on the right
			int pi = partition(arr, start, end);

			// Recursively sort the left and right subarrays
			quickSort(arr, start, pi - 1);
//			quickSort(arr, pi + 1, high);
		}
		System.out.println(Arrays.toString(arr));
	}

	// Partition method to place pivot element in correct position
	static int partition(int[] arr, int low, int high) {
		int pivot = arr[high]; // Choose the rightmost element as pivot
		int i = (low - 1); // Index of smaller element

		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				// Swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// Swap arr[i + 1] and arr[high] (pivot element)
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1; // Return the partition index
	}
}