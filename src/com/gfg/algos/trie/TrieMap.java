/*package com.gfg.algos.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieMap {
	
	private class TrieMapNode {
        Map<Character, TrieMapNode> children;
        boolean endOfWord;
        public TrieMapNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    private final TrieMapNode root;
    public TrieMap() {
        root = new TrieMapNode();
    }

    *//**
     * Iterative implementation of insert into trie
     *//*
    public void insert(String word) {
        TrieMapNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieMapNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieMapNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        //mark the current nodes endOfWord as true
        current.endOfWord = true;
    }

    *//**
     * Recursive implementation of insert into trie
     *//*
    public void insertRecursive(String word) {
        insertRecursive(root, word, 0);
    }


    private void insertRecursive(TrieMapNode current, String word, int index) {
        if (index == word.length()) {
            //if end of word is reached then mark endOfWord as true on current node
            current.endOfWord = true;
            return;
        }
        char ch = word.charAt(index);
        TrieMapNode node = current.children.get(ch);

        //if node does not exists in map then create one and put it into map
        if (node == null) {
            node = new TrieMapNode();
            current.children.put(ch, node);
        }
        insertRecursive(node, word, index + 1);
    }

    *//**
     * Iterative implementation of search into trie.
     *//*
    public boolean search(String word) {
        TrieMapNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieMapNode node = current.children.get(ch);
            //if node does not exist for given char then return false
            if (node == null) {
                return false;
            }
            current = node;
        }
        //return true of current's endOfWord is true else return false.
        return current.endOfWord;
    }

    *//**
     * Recursive implementation of search into trie.
     *//*
    public boolean searchRecursive(String word) {
        return searchRecursive(root, word, 0);
    }
    private boolean searchRecursive(TrieMapNode current, String word, int index) {
        if (index == word.length()) {
            //return true of current's endOfWord is true else return false.
            return current.endOfWord;
        }
        char ch = word.charAt(index);
        TrieMapNode node = current.children.get(ch);
        //if node does not exist for given char then return false
        if (node == null) {
            return false;
        }
        return searchRecursive(node, word, index + 1);
    }

    *//**
     * Delete word from trie.
     *//*
    public void delete(String word) {
        delete(root, word, 0);
    }

    *//**
     * Returns true if parent should delete the mapping
     *//*
    private boolean delete(TrieMapNode current, String word, int index) {
        if (index == word.length()) {
            //when end of word is reached only delete if currrent.endOfWord is true.
            if (!current.endOfWord) {
                return false;
            }
            current.endOfWord = false;
            //if current has no other mapping then return true
            return current.children.size() == 0;
        }
        char ch = word.charAt(index);
        TrieMapNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        //if true is returned then delete the mapping of character and trienode reference from map.
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            //return true if no mappings are left in the map.
            return current.children.size() == 0;
        }
        return false;
    }
	
	public static void main(String[] args) {
		
		
		TrieMap trieMap = new TrieMap();
		
		trieMap.insert("amaze");
		trieMap.insert("amazing");
		trieMap.insert("amazement");
		trieMap.insert("amuze");
		trieMap.insert("amuse");
		trieMap.insert("amusing");
		
		System.out.println(trieMap.search("amazing"));
		
	}

}
*/