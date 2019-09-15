package com.gfg.algos.linkedlist.leetcode.trees;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

public class MaxPathNoRoot {


	int maxSum = Integer.MIN_VALUE;

	public int maxGain(Node node) {
		if (node == null) return 0;

		// max sum on the left and right sub-trees of node
		int leftGain = Math.max(maxGain(node.left), 0);  // zeros are for negative cases
		int rightGain = Math.max(maxGain(node.right), 0);

		// the price to start a new path where `node` is a highest node
		int price_newpath = node.data + leftGain + rightGain;

		// update max_sum if it's better to start a new path
		maxSum = Math.max(maxSum, price_newpath);

		// for recursion :
		// return the max gain if continue the same path
		return node.data + Math.max(leftGain, rightGain);
	}

	public int maxPathSum(Node root) {
		
		maxGain(root);
		return maxSum;
	}
	
	public static void main(String[] args) {
		
		MaxPathNoRoot maxPath1 = new MaxPathNoRoot();
		
		BTREE btree = new BTREE();
		btree.createSampleBinaryTree1();
		System.out.println(maxPath1.maxPathSum(btree.root));
		
		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \
		 * 				 70    80  50  60
		 */
		
		BTREE btree2 = new BTREE();
		MaxPathNoRoot maxPath2 = new MaxPathNoRoot();
		btree2.createMaxPathSubTree1();
		System.out.println(maxPath2.maxPathSum(btree2.root));
		
		/*
		 * 							   -10
		 * 						 	  /	    \
		 * 						     9		 20
		 * 								   /    \
		 * 								 15      7
		 * 
		 */

		

		
		
		
		
	}


}
