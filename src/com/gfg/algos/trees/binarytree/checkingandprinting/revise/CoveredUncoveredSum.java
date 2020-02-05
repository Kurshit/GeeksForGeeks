package com.gfg.algos.trees.binarytree.checkingandprinting.revise;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

public class CoveredUncoveredSum {
	
	public static boolean isSumSameOfCoveredAndUncovered(Node root) {
		
		if(root == null)
			return true;
		
		int sumOfUncovered = uncoveredSum(root);
		
		int totalSum = totalSum(root);
		
		return sumOfUncovered == totalSum - sumOfUncovered;
		
	}
	
	public static int totalSum(Node root) {
		
		if(root == null)
			return 0;
		
		return root.data + totalSum(root.left) + totalSum(root.right);
	}
	
	public static int uncoveredSum(Node root) {
		
		int leftSubtree = uncoveredLeft(root.left);
		int rightSubtree = uncoveredRight(root.right);
		
		return root.data + leftSubtree + rightSubtree;
			
	}
	
	public static int uncoveredLeft(Node root) {
		
		if(root.left == null && root.right == null)
			return root.data;
		
		if(root.left != null)
			return root.data + uncoveredLeft(root.left);
		else 
			return root.data + uncoveredLeft(root.right);
		
	}
	
	public static int uncoveredRight(Node root) {
		
		if(root.left == null && root.right == null)
			return root.data;
		
		if(root.right != null)
			return root.data + uncoveredRight(root.right);
		else 
			return root.data + uncoveredRight(root.left);
		
	}	
	
	
	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.createUncoveredCoveredSumTree();
		
		System.out.println(isSumSameOfCoveredAndUncovered(btree.root));

	}

}
