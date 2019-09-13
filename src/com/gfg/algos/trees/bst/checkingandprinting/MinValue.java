package com.gfg.algos.trees.bst.checkingandprinting;

import com.gfg.algos.trees.bst.BST;
import com.gfg.algos.trees.bst.BST.Node;

public class MinValue {
	
	public int minValue(Node root) {
		
		if(root == null)
			return -1;
		
		int min = root.data;
		
		while(root != null) {
			min = root.data;
			root = root.left;
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		
		BST bst = new BST();
		
		bst.createSampleTree();
		
		MinValue minValue = new MinValue();
		
		System.out.println(minValue.minValue(bst.root));
		
		

	}

}
