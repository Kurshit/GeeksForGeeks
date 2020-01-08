package com.gfg.algos.trees.binarytree.checkingandprinting.path;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

public class MaxPathSumLeaves { 

	static Node root; 

	// A utility function to find the maximum sum between any 
	// two leaves.This function calculates two values: 
	// 1) Maximum path sum between two leaves which is stored 
	// in res. 
	// 2) The maximum root to leaf path sum which is returned. 
	// If one side of root is empty, then it returns INT_MIN 
	int maxPathSumUtil(Node node, Res res) { 

		// Base cases 
		if (node == null) 
			return 0; 
		if (node.left == null && node.right == null) 
			return node.data; 

		// Find maximum sum in left and right subtree. Also 
		// find maximum root to leaf sums in left and right 
		// subtrees and store them in ls and rs 
		int ls = maxPathSumUtil(node.left, res); 
		int rs = maxPathSumUtil(node.right, res); 

		// If both left and right children exist 
		if (node.left != null && node.right != null) { 

			// Update result if needed 
			res.val = Math.max(res.val, ls + rs + node.data); 

			// Return maxium possible value for root being 
			// on one side 
			return Math.max(ls, rs) + node.data; 
		} 

		// If any of the two children is empty, return 
		// root sum for root being on one side 
		return (node.left == null) ? rs + node.data 
				: ls + node.data; 
	} 

	// The main function which returns sum of the maximum 
	// sum path between two leaves. This function mainly 
	// uses maxPathSumUtil() 
	int maxPathSum(Node node) 
	{ 
		Res res = new Res(); 
		res.val = Integer.MIN_VALUE; 
			
		maxPathSumUtil(node, res); 
		return res.val; 
	} 
	
	public static void main(String[] string) {
		
		BTREE btree = new BTREE();
		
		btree.createSampleBinaryTree1();
		

		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \
		 * 				 70    80  50  60
		 */

		
		MaxPathSumLeaves max = new MaxPathSumLeaves();
		
		System.out.println(max.maxPathSum(btree.root));
	}

	

} 

class Res { 
    int val; 
} 

