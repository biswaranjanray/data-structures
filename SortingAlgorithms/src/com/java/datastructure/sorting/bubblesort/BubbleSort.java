package com.java.datastructure.sorting.bubblesort;

import java.util.Arrays;

/**
 * Given an array of items, the bubble sort will sort them in increasing order.
 * The way bubble sort works, it repeastedly compares adjacent items in the list.
 * And then if the item in the left is larger then it swaps it to the right. So
 * larger item tends to bubble to the right. 
 * It's not an efficient sorting algorithm because it uses nested loops. It's only 
 * useful for small data sets.
 * 
 * Time Complexity. 
 * Best case: O(n)
 * Average case: O(n^2)
 * Worst case: O(n^2)

 * @author C5258401
 *
 */
public class BubbleSort {
	
	/**
	 * source:	https://www.youtube.com/watch?v=F13_wsHDIG4
	 * 
	 * @param array
	 * @return
	 */
	private static int[] algorithm(int[] array) {
		int i, j, temp = 0;
		//the outer loop needs to run from index 0 to the last index.
		//so if there are n items in the list, the last index would be n-1
		int n = array.length;
		for(i=0; i<n-1; i++) {
			/*the inner loop would run from index 0 to n-1-i. Here -i indicates 
			the no of items that are already sorted which is the no. of 
			iteration it has already completed.*/
			for(j=0; j<n-1-i; j++) {
				if(array[j] > array[j+1]) {
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		int[] input = {5, 8, 1, 6, 9, 2};
		Arrays.stream(BubbleSort.algorithm(input)).forEach(value -> System.out.print(" " + value));
	}

}
