package com.java.datastructure.sorting.selectionsort;

import java.util.Arrays;

/**
 * This class implements the selection sort algorithm. In this algorithm it searches 
 * through the list to find the smallest item in the unsorted part of the list, and 
 * then it moves that to the first position in the list. 
 * 
 * This is not a fast algorithm to sort because it uses nested loop to sort. 
 * It is useful only for small data sets. Time complexity of this algorithm is O(n^2).
 * 
 * source: https://www.youtube.com/watch?v=cqh8nQwuKNE
 * 
 * @author C5258401
 *
 */
public class SelectionSort {
	
	private static int minValue, minIndex, temp = 0;
	
	public static int[] selectionSort(int[] array) {
		for(int i=0; i<array.length; i++) {
			minValue = array[i];
			minIndex = i;
			for(int j=i; j<array.length; j++) {
				if(array[j] < minValue) {
					minValue = array[j];
					minIndex = j;
				}
			}
			if(minValue < array[i]) {
				temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		int[] array = {7, 8, 5, 4, 9, 2};
		int[] result = SelectionSort.selectionSort(array);
		System.out.print("Sorted array:");
		for (int i : result) {
			System.out.print(" " + i);
		}
		System.out.println();
		System.out.print("Sorted array:");
		Arrays.stream(SelectionSort.selectionSort(array)).forEach( s -> System.out.print(" " + s));
		//System.out.println();
	}

}
