package com.gfg.algos.linkedlist.leetcode.arrays.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		
		int[] arr = {20,2,50,3,12,7,30,9};
		
		insertionSort(arr);
		
		for(int item : arr) {
			System.out.print(item + " ");
		}

	}
	
	public static void insertionSort(int[] arr) {
		
		for(int i=1; i< arr.length; i++) {
			int key = arr[i];
			
			int j = i-1;
			
			while(j >=0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			
			arr[j+1] = key;		
			
		}
		
	}

}
