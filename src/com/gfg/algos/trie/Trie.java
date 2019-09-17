package com.gfg.algos.trie;

public class Trie {

	/*
	 * ASCII : 
	 *  a -z : 97-122
	 */
	
	
	TrieNode root = new TrieNode();

	public static class TrieNode {

		final static int ALPHABET_SIZE = 26;
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
		boolean isEOW;
		int count;

		TrieNode() {
			isEOW = false;
			//OPTIONAL for loop - by default null
			for(int i=0; i < 26; i++) 
				children[i] = null;
		}
	}

	public void insert(String key) {

		int level;
		int length = key.length();
		int index;

		TrieNode ptr = root;

		for(level = 0; level < length; level++) {

			index = key.charAt(level) - 'a';

			if(ptr.children[index] == null) {

				ptr.children[index] = new TrieNode();				
			}

			ptr = ptr.children[index];
		}

		ptr.isEOW = true;

	}

	public boolean search(String key) {

		int level;
		int length = key.length();
		int index;

		TrieNode ptr = root;

		for(level =0; level < length; level++) {

			index = key.charAt(level) - 'a';

			if(ptr.children[index] == null)
				return false;

			ptr = ptr.children[index];
		}

		return ptr != null && ptr.isEOW;
	}

	/*Display the contents of the Trie*/
	public void display() {
		StringBuilder sb = new StringBuilder();
		//we pass in a root node, string builder, and a level (index) to insert chars at
		displayHelper(root, sb, 0);
	}
	private void displayHelper(TrieNode node, StringBuilder str, int level) {
		//base case for displaying a full word (key)
		//if a node is the end of a word (boolean), we print
		if(node.isEOW) {
			//clear any chars remaining from previous words inserted into the string builder
			str.delete(level, str.length()); 
			System.out.println(str.toString());
		}

		//loop through all the indices through a child array
		//if a non null child is found, append the character to the String 'str'
		//and recursively call the helper method on its child node
		for(int i = 0; i < TrieNode.ALPHABET_SIZE; i++) {
			if(node.children[i] != null) {
				//insert a char at the level index

				//example: level = 2, char is 'y'
				//our current string builder contains: 
				//t r a n k s b y e a....
				//_ _ _ _ _ _ _ _ _ _

				//now, we replace
				//t r y <--insert at index 2, we'll clear other chars at the base case
				//_ _ _
				str.insert(level, Character.toString((char) (i + 'a')));
				displayHelper(node.children[i], str, level + 1);
			}
		}
	}

	public String getMatchingPrefix(String input)  { 
		String result = ""; // Initialize resultant string 
		int length = input.length();  // Find length of the input string 
		int index;

		// Initialize reference to traverse through Trie 
		TrieNode ptr = root;    

		// Iterate through all characters of input string 'str' and traverse 
		// down the Trie 
		int level, prevMatch = 0; 
		for( level = 0 ; level < length; level++ ) 
		{ 
			// Find current character of str 
			index = input.charAt(level) - 'a';     

			// HashMap of current Trie node to traverse down 
			//HashMap<Character,TrieNode> child = ptr.getChildren();                         

			// See if there is a Trie edge for the current character 
			if(ptr.children[index] != null) 
			{ 
				result = result + (char) (index + 'a');          //Update result 
				ptr = ptr.children[index]; //Update crawl to move down in Trie 

				// If this is end of a word, then update prevMatch 
				if( ptr.isEOW ) 
					prevMatch = level + 1; 
			} 
			else  break; 
		} 

		// If the last processed character did not match end of a word, 
		// return the previously matching prefix 
		if( !ptr.isEOW) 
			return result.substring(0, prevMatch);         

		else return result; 
	} 	

	void displayContacts(String str) 
	{ 
		TrieNode prevNode = root; 

		// 'flag' denotes whether the string entered 
		// so far is present in the Contact List 

		String prefix = ""; 
		int len = str.length(); 

		// Display the contact List for string formed 
		// after entering every character 
		int i; 
		for (i = 0; i < len; i++) 
		{ 
			// 'str' stores the string entered so far 
			prefix += str.charAt(i); 

			// Get the last character entered 
			int lastChar = prefix.charAt(i) - 'a'; 

			// Find the Node corresponding to the last 
			// character of 'str' which is pointed by 
			// prevNode of the Trie 
			TrieNode curNode = prevNode.children[lastChar]; 

			// If nothing found, then break the loop as 
			// no more prefixes are going to be present. 
			if (curNode == null) 
			{ 
				System.out.println("nNo Results Found for "+ prefix + " "); 
				i++; 
				break; 
			} 

			// If present in trie then display all 
			// the contacts with given prefix. 
			System.out.println("nSuggestions based on "+ prefix + " are : "); 
			displayContactsUtil(curNode, prefix); 

			// Change prevNode for next prefix 
			prevNode = curNode; 
		} 

		for ( ; i < len; i++) 
		{ 
			prefix = prefix + str.charAt(i); 
			System.out.println("nNo Results Found for "+ prefix + " "); 
		} 
	} 

	public void displayContactsUtil(TrieNode curNode, 
			String prefix) 
	{ 
		// Check if the string 'prefix' ends at this Node 
		// If yes then display the string found so far 
		if (curNode.isEOW) 
			System.out.println(prefix); 

		// Find all the adjacent Nodes to the current 
		// Node and then call the function recursively 
		// This is similar to performing DFS on a graph 
		for (char i = 'a'; i <= 'z'; i++) 
		{ 
			TrieNode nextNode = curNode.children[i-'a']; 
			if (nextNode != null) 
			{ 
				displayContactsUtil(nextNode, prefix + i); 
			} 
		} 
	} 




} 


