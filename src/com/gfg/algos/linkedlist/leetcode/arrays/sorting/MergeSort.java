package com.gfg.algos.linkedlist.leetcode.arrays.sorting;

public class MergeSort {

	public static void main(String[] args) {
		
		int[] arr = {20,2,50,3,12,7,30,9};

		mergeSort(arr);

		for(int item : arr) {
			System.out.print(item + " ");
		}

	}
	
	public static void mergeSort(int[] arr) {
			
		sort(arr,0,arr.length-1);
		
	}
	
	public static void sort(int[] arr, int l, int r) {
		
		if(l < r) {
			
		
		int m =  (l+r)/2;
		
		sort(arr,l,m);
		sort(arr,m+1,r);
		
		mergtThem(arr,l,r,m);		
		}
		
	}
	
	public static void mergtThem(int[] arr, int l, int r, int m) {
		
		int s1 = m-l+1;
		int s2 = r-m;
		
		int[] L = new int[s1];
		int[] R = new int[s2];
		
		
		for(int i=0; i<s1; i++)
			L[i] = arr[l+i];			
		
		for(int i=0; i<s2; i++)
			R[i] = arr[m+i+1];
		
		int i =0, j =0;
		int k= l;
		
		
		while(i < s1 && j < s2 ) {
			
			if(L[i]<=R[j]) {
				arr[k] = L[i];
				i++;
				
			} else {
				arr[k] = R[j];
				j++;
			}
			
			k++;
			
		}
		
		   while (i < s1) 
	        { 
	            arr[k] = L[i]; 
	            i++; 
	            k++; 
	        } 
	  
	        /* Copy remaining elements of R[] if any */
	        while (j < s2) 
	        { 
	            arr[k] = R[j]; 
	            j++; 
	            k++; 
	        } 
		
		
		
	}

}
