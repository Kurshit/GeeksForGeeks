package com.gfg.algos.trees.bst;

public class BSTSampleApp {

	public static void main(String[] args) {
		
		BST bst = new BST();
		bst.createSampleTree();
		bst.inorder();
		bst.preOrder();
		
		System.out.println(bst.search(40));
		
		bst.delete(30);
		bst.inorder();
	}

}
