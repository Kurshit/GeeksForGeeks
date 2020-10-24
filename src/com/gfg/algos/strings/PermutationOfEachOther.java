package com.gfg.algos.strings;

/*
 *	Approach 1: Sort both the strings and compare character by character both the strings
 *	
 *	TC: O(nlogn)
 *
 *  Approach 2 : Using extra space to store characters and keeping count of each character on traverssing first array and then decreamenting
 *  count of respective characters on iterating second array. Fiannly, if there is any value in intial visited array which is
 *  non zero - this
 *  
 *    TC : O(n)
 */

public class PermutationOfEachOther {

	public static void main(String[] args) {
		
		System.out.println(arePermutationOfEachOther("kuku","ukuk"));
		System.out.println(arePermutationOfEachOther("kukk","ukuk"));

	}
	
	public static boolean arePermutationOfEachOther(String first, String second) {
		
		int firstLength = first.length();
		int secondLength = second.length();
		
		if(firstLength != secondLength)
			return false;
		
		int[] counter = new int[256];
		
		for(int i=0; i < first.length(); i++)
			counter[first.charAt(i)] = counter[first.charAt(i)] + 1;
		
		for(int i=0; i < second.length(); i++)
			counter[second.charAt(i)] = counter[second.charAt(i)] - 1;
		
		for( int i=0; i < 256; i++)
		{
			if(counter[i] != 0)
				return false;
		}
		
		
		return true;
	}

}
