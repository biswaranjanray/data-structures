package com.java.datastructure.sorting.insertionsort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Insertion sort sorts from the left in a list or array. All items to the left are smaller and sorted.
 * Its not a best algorithm in terms of performance because it uses nested loops to shift items into 
 * places, but its better than selection sort and bubble sort and useful only for small data sets.

 * Time complexity:
 * Best Case: O(n)
 * worst case: O(n^2)
 * Average case: O(n^2)

 * Source:	https://www.youtube.com/watch?v=i-SKeOcBwko
			https://www.youtube.com/watch?v=lCDZ0IprFw4
 * @author C5258401
 *
 */
public class InsertionSort {

	private static int[] sortingAlgorithm1(int[] array) {
		int n = array.length;
		for(int i=1; i<n; i++) {
			int value = array[i];
			int hole = i;
			while(hole > 0 && array[hole-1] > value) {
				array[hole] = array[hole - 1];
				hole--;
			}
			array[hole] = value;
		}
		return array;
	}
	
	private static int[] sortingAlgorithm2(int[] array) {
		int key, temp;
		for(int i=1; i<array.length; i++) {
			key = array[i];
			int j = i-1;
			while(j>=0 && key<array[j]) {
				//swap
				temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
				j--;
			}
		}
		return array;
	}
	
	private static List<Integer> sortUsingList(List<Integer> list) {
		int key, temp;
		
		for(int i=1; i<list.size(); i++) {
			key = list.get(i);
			int j = i-1;
			while(j>=0 && key<list.get(j)) {
				temp = list.get(j);
				list.set(j, list.get(j+1));
				list.set(j+1, temp);
				j--;
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		int[] input = {5, 8, 1, 3, 9, 6};
		Arrays.stream(InsertionSort.sortingAlgorithm1(input)).forEach(value -> System.out.print(" " + value));
		System.out.println();
		Arrays.stream(InsertionSort.sortingAlgorithm2(input)).forEach(value -> System.out.print(" " + value));
		System.out.println();
		System.out.println("Sort using list...");
		List<Integer> list = IntStream.of(input).boxed().collect(Collectors.toList());
		System.out.println(InsertionSort.sortUsingList(list));
	}
}
