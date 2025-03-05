package com.ait.test;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {

		int[] arr = { 5, 3, 8, 4, 2 };

		int n = arr.length;
		boolean swapped;

		// Traverse through all array elements
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			System.out.println(i);
			System.out.println(n-1);

			// Last i elements are already sorted
			for (int j = 0; j < n - 1 - i; j++) {
				// Compare adjacent elements
				if (arr[j] > arr[j + 1]) {
					// Swap if the element is greater than the next
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}

			// If no two elements were swapped, the array is already sorted
			if (!swapped) {
				break;
			}
		}
		System.out.println(Arrays.toString(arr));

	}
// kth largest number without sorting.
// bubble sort.
// Satish,find character values count
// linkedList , abcd
// matrix
// Annotations, CustomAnnotations

}
