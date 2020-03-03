package com.gfg.algos.trees.binarytree.summation;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

public class SumAllLeftLeaves {

	public void sumAllLeftLeavesUtil(Node root, SumAll totalSum) {

		if (root == null)
			return;

		if (root.left != null) {
			if (root.left.left == null && root.left.right == null) {
				totalSum.totalSum = totalSum.totalSum + root.left.data;
			}
		}
		
		sumAllLeftLeavesUtil(root.left, totalSum);
		sumAllLeftLeavesUtil(root.right, totalSum);

	}

	public int sumAllLeftLeaves(Node root) {

		SumAll totalSum = new SumAll();
		
		sumAllLeftLeavesUtil(root, totalSum);
		
		return totalSum.totalSum;

	}

	public static void main(String[] args) {

		BTREE btree = new BTREE();
		btree.createSampleBinaryTree1();
		
		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \       /      \
		 *                   9       7     30       40
		 * 				  /    \    / \    
		 * 				 70    80  50  60 
		 */

		SumAllLeftLeaves sumLefts = new SumAllLeftLeaves();

		System.out.println(sumLefts.sumAllLeftLeaves(btree.root));

	}

	private class SumAll {
		int totalSum;
	}
}
