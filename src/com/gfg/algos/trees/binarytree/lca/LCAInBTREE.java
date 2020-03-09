package com.gfg.algos.trees.binarytree.lca;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

public class LCAInBTREE {
	
	public Node lca(Node root, int n1, int n2) {
		
		if(root == null)
			return null;
		
		if(root.data == n1 || root.data == n2) 
			return root;
		
		Node leftLca = lca(root.left, n1, n2);
		Node rightLca = lca(root.right, n1, n2);
		
		if(leftLca != null && rightLca != null)
			return root;
		
		return leftLca != null ? leftLca : rightLca;
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
		
		LCAInBTREE lca = new LCAInBTREE();
		
		Node result = lca.lca(btree.root, 70, 40);
		
		if(result != null)
			System.out.println("LCA is : " + result.data);

	}

}
