package com.gfg.algos.linkedlist.singlell.sorting.revise;

public class BubbleSort {
	
	public void sort(int[] arr) {
		
		if(arr.length == 0) 
			return;
		
		for(int i=0; i< arr.length-1; i++) {
			for(int j=0; j< arr.length-i-1; j++) {
				
				if(arr[j] > arr[j+1]) {
					
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					
				}
			}
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {15,10,25,5,30,40,2};
		
		BubbleSort sort = new BubbleSort();
		
		sort.sort(arr);
		
		for(int i: arr) {
			System.out.print(i + " ");
		}
	}

}
