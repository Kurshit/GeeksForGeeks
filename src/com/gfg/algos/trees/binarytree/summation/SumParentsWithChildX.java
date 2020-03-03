package com.gfg.algos.trees.binarytree.summation;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

public class SumParentsWithChildX {
	
	public void sumAllParentsWithChildX(Node root, ParentsWithChildX parent, int x) {
		
		if(root == null)
			return;
		
		if(root.left != null && root.left.data == x || root.right != null && root.right.data == x)
			parent.totalSum += root.data;
		
		sumAllParentsWithChildX(root.left, parent, x);
		sumAllParentsWithChildX(root.right, parent, x);
		
	}
	
	public int sumAllParentsWithChildX(Node root, int x) {
		ParentsWithChildX parent = new ParentsWithChildX();
		sumAllParentsWithChildX(root,parent, x);
		return parent.totalSum;
	}

	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.createSampleBinaryTree3();


		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \
		 * 				 50    80  50  60
		 */
		
		SumParentsWithChildX sum = new SumParentsWithChildX();
		int x = 50;
		System.out.println(sum.sumAllParentsWithChildX(btree.root, x));

	}
	
	private class ParentsWithChildX {
		int totalSum;
	}

}
