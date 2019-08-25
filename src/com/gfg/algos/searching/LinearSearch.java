package com.gfg.algos.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinearSearch {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter number of elements in array :");
		int no = Integer.parseInt(br.readLine());
		
		System.out.println("Enter " + no + " elements");
		
		int[] arr = new int[no];
		
		for(int i=0; i<no; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println("Enter element to search : ");
		int key = Integer.parseInt(br.readLine());
		
		int resultIndex = linearSearch(arr,key);
		if(resultIndex != -1) {
			System.out.println("Element found at index " + resultIndex);
		} else
		{
			System.out.println("Element not found");
		}

	}
	
	public static int linearSearch(int[] arr, int key) {
		
		for(int i=0; i< arr.length; i++) {
			if(arr[i] == key) 
				return i;
		}		
		
		return -1;
	}

}
