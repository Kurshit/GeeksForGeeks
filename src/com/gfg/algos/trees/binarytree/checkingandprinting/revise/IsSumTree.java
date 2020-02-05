package com.gfg.algos.trees.binarytree.checkingandprinting.revise;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

public class IsSumTree {
	
	public static boolean isSumTree(Node root) {
		
		if(root == null)
			return true;
		
		if(root.left == null && root.right == null)
			return true;
		
		int left = 0;
		int right = 0;
		
		if(root.left != null)
			left = root.left.data;
		
		if(root.right != null)
			right = root.right.data;
		
		return (root.data == left + right) && isSumTree(root.left) && isSumTree(root.right);				
	
	}

	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.createSumTree();
		
		System.out.println(isSumTree(btree.root));

	}

}
