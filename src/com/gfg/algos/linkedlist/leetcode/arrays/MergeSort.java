package com.gfg.algos.linkedlist.leetcode.arrays;

public class MergeSort {
	
	public void sort(int[] arr, int l, int r) {
		
		if(l < r) {
			
			
			int m = ( l + r )/2;
			
			sort(arr,l,m);
			sort(arr,m+1,r);
			merge(arr,l,r,m);
		}	
		
	}
	
	public void merge(int[] arr, int l, int r, int m) {
		
		
		int s1 = m - l + 1;
		int s2 = r-m;
		
		int[] L = new int[s1];
		int[] R = new int[s2];
		
		for(int i=0; i<s1; i++)
			L[i] = arr[l+i];
		
		for(int j=0; j<s2; j++)
			R[j] = arr[m+ j + 1];
		
		int i =0, j = 0;
		int k =l;
		
		while(i < s1 && j < s2) {
			
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			
			k++;
			
		}
		
		while( i < s1) {
			arr[k++] = L[i++];
		}
		
		while( j < s2) {
			arr[k++] = R[j++];
		}
			
		
		
		
	}
	
	static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 

	public static void main(String[] args) {
		
		int arr[] = {12, 11, 13, 5, 6, 7}; 
		  
        System.out.println("Given Array"); 
        printArray(arr); 
  
        MergeSort ob = new MergeSort(); 
        ob.sort(arr, 0, arr.length-1); 
  
        System.out.println("\nSorted array"); 
        printArray(arr); 
		
	}

}
