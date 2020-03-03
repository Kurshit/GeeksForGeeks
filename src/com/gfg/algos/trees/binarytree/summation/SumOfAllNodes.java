package com.gfg.algos.trees.binarytree.summation;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

public class SumOfAllNodes {
	
	public int sumAll(Node root) {
		if(root  == null)
			return 0;
		
		return root.data + sumAll(root.left) + sumAll(root.right);
				
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
		
		SumOfAllNodes sumAll = new SumOfAllNodes();
		
		System.out.println(sumAll.sumAll(btree.root));

	}

}
