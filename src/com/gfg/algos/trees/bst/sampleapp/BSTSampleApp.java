package com.gfg.algos.trees.bst.sampleapp;

import com.gfg.algos.trees.bst.BST;
import com.gfg.algos.trees.bst.BST.Node;

public class BSTSampleApp {

	public static void main(String[] args) {
		
		BST bst = new BST();
		
		bst.add(50);
		bst.add(60);
		bst.add(40);
		bst.add(70);
		bst.add(10);
		bst.add(65);
		bst.add(45);
		bst.add(48);
		
		bst.inorder();
		
		Node searchResult = bst.search(77);
		
		if(searchResult != null)
			System.out.println(searchResult.getData());
		else
			System.out.println("Not found");
		
		
		//bst.delete(10);
		//bst.delete(70);
		
		bst.delete(40);
		
		bst.inorder();
	}

}
