package com.gfg.algos.linkedlist.singlell.sorting.revise;

public class InsertionSort {
	
	
	public void sort(int[] arr) {
		
		if(arr.length == 0)
			return;
		int n = arr.length;
		
		for(int i=1; i<n; i++) {
			
			int key = arr[i];
			
			int j = i-1;
			
			while(j >=0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j = j-1;
			}
			
			arr[j+1] = key;
		}		
		
	}
	
	public static void main(String[] args) {
		
		int[] arr = {15,10,25,5,30,40,2};
		
		InsertionSort sort = new InsertionSort();
		
		sort.sort(arr);
		
		for(int i: arr) {
			System.out.print(i + " ");
		}

	}

}
