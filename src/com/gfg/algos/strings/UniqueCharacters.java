package com.gfg.algos.strings;

/*
 *  Approach 1. : Using two for loops, iterate through String comparing first character with rest of characters. Then second with
 *  rest of characters. Then third and so on.
 *  
 *  TC : O(n2)
 *  
 *  Approach 2: 
 *  	
 *  Using ascii value and using visited boolean array (extra space) to mark already visited/present character true.
 *   
 *   We assume ascii character set with 256 valid values
 *   
 *   TC : Min (O(c), O(n))  - where c is the length of character set (128, 256 etc) and n is length of string
 *   
 *   Examplain : O(n) complexity seems logical here where n is the length of string. But we could argue that the for loop will
 *   never iterate beyond 256 ever - provided we know the character set. So, if character set is not known, it is
 *   
 *   Min (O(c), O(n))
 *   
 *   SC: O(1) - since space is always constant
 *  
 */

public class UniqueCharacters {

	public static void main(String[] args) {
	
		System.out.println(isUnique("kurshit"));
		System.out.println(isUnique("kurshik"));
		System.out.println(isUnique("kurshiz"));
		System.out.println(isUnique("kurshizz"));
		System.out.println(isUnique("abcdefghijklmnopqrstuvwxyz"));
		System.out.println(isUnique(""));
	}
	
	/*
	 * Solution by Approach 2 
	 */
	
	public static boolean isUnique(String key) {
		boolean[] visited = new boolean[256];
		
		if(key.isEmpty())
			return false;
		
		for(int i=0; i < key.length(); i++) {
			int asciiOfCurrentVariable = key.charAt((i));
			
			if(visited[asciiOfCurrentVariable])
				return false;
			
			visited[asciiOfCurrentVariable] = true;
		}
		
		return true;
		
	}	
	
}
