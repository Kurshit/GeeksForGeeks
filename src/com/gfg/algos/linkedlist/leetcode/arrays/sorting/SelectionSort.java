package com.gfg.algos.linkedlist.leetcode.arrays.sorting;

public class SelectionSort {

	public static void main(String[] args) {

		int[] arr = {20,2,50,3,12,7,30,9};

		selectionSort(arr);

		for(int item : arr) {
			System.out.print(item + " ");
		}


	}

	public static void selectionSort(int[] arr) {

		for(int i=0; i < arr.length-1; i++) {
			int minIndex = i;

			for(int j=i+1; j < arr.length ;j++) {

				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}

			}


			int temp = arr[i];

			arr[i] = arr[minIndex];
			arr[minIndex] = temp;

		}

	}

}
