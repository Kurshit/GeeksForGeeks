package com.gfg.algos.strings;

public class PermutationIsPalindrome {

	public static void main(String[] args) {
		
		System.out.println(isPermutationPalindrome("nitin"));

	}
	
	public static boolean isPermutationPalindrome(String key) {
		
		if(key.isEmpty())
			return false;
		
		int[] visited = new int[256];
		
		for(int i=0; i < key.length(); i++) {
			char character = key.charAt(i);
			
			if(character == ' ')
				continue;
			int c = character;
			visited[c] = visited[c] + 1;
			
		}	
		
		int count = 0;
		for(int i =0; i < 256; i++) {
			if(visited[i] % 2 !=0)
				count++;
		}
		
		return count > 1 ? false : true;
	}

}
