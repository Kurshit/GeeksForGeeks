package com.gfg.algos.trie;


public class TrieSampleApp {

	public static void main(String[] args) {

		String keys[] = {"the", "a", "there", "answer", "any", 
				"by", "bye", "their"}; 

		String output[] = {"Not present in trie", "Present in trie"}; 

		Trie trie = new Trie(); 
		
		// Construct trie 
		int i; 
		for (i = 0; i < keys.length ; i++) 
			trie.insert(keys[i]); 

		//System.out.println(trie.search("there"));
		
		
		System.out.println("Matching Prefix : " + trie.getMatchingPrefix("ther"));
		
		System.out.println("------------------------");
		
		//trie.display();
		
		System.out.println("###############");
		
		//trie.displayContacts("th");
		
		
	
		
	
	
	}

}
