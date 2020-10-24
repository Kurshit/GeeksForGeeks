package com.hackerrank.problemsolving;

/* A left rotation operation on an array of size  shifts each of the array's elements  unit to the left. 
 * For example, if  left rotations are performed on array , then the array would become .

 * Given an array of  integers and a number, , perform  left rotations on the array. 
 * Then print the updated array as a single line of space-separated integers.
 *
*/

public class LeftRotateArray {
	
	public static void leftRotateIt(int[] arr, int n, int d) {
		
		if(n == 0 || n == 1 || d == n)
			return;
		
		if( d > n )
			d = d % n;
		
		for(int i =0; i < d; i++) {
			int temp = arr[0];
			
			for(int j=0; j < n -1; j++) {
				arr[j] = arr[j+1];
			}
			
			arr[n-1] = temp;
		}
			
	}
	
	public static void main(String[] args) {
		
		int[] arr = {15,10,5,7,8};
		int n = arr.length;
		int d = 8;
		leftRotateIt(arr, n, d);
		
		for(int i : arr) {
			System.out.print( i + " ");
		}
		
	}
	
	

}
