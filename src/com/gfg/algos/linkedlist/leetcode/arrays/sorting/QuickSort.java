package com.gfg.algos.linkedlist.leetcode.arrays.sorting;

public class QuickSort {

	public static void main(String[] args) {
		
		int[] arr = {5,1,18,9,17};
				
		sort(arr, 0, arr.length-1);
		
		for(int item : arr) 
			System.out.print(item +" ");

	}
	
	public static void sort(int[] arr,int l, int h) {
		
		if(l < h) {
		
		int pivot = partition(arr,l,h);
		
		sort(arr,l,pivot-1);
		sort(arr,pivot+1,h);
		
		}
		
		
	}
	
	public static int partition(int[] arr, int low, int high) {
		
		int pivot = arr[high];
		
		int i = low-1;
		
		for(int j=low; j< high; j++) {
			
			if(arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				
			}
		}
		
		i++;
		int temp = arr[i];
		arr[i] = arr[high];
		arr[high] = temp;
		
		return i;
		
	}

}
