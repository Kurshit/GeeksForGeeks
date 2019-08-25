package com.gfg.algos.trees.binarytree.misc;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;


/* Given a binary tree and a target integer x, delete any of leaf nodes having value as x. 
 * 
 *  IF given value is not leaf node, ignore and keep tree intact.
 *  
 *  If there are more than one target value as leaf nodes, this shall delete them all
 * 
 * https://www.geeksforgeeks.org/delete-leaf-nodes-value-x/
 */

public class LeafNodeXDelete {

	public static Node anyLeafNodeDelete(Node newRoot, int x) {
		
		if(newRoot == null)
			return null;
		
		newRoot.left = anyLeafNodeDelete(newRoot.left, x);
		newRoot.right = anyLeafNodeDelete(newRoot.right, x);
		
		
		
		
		if (newRoot.data == x && newRoot.left == null && newRoot.right == null) {  
			//System.out.println("x node " + newRoot);  
	        return null;  
	    }  
		
		return newRoot;
		
	}
	
	
	
	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.createSampleBinaryTree1();
		
		btree.inorder();
		System.out.println();
		System.out.println("After deleting 60");
		anyLeafNodeDelete(btree.root, 60);
		System.out.println();
		
		btree.inorder();
		
		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \
		 * 				 70    80  50  60
		 * 
		 */
		
		BTREE btree2 = new BTREE();
		
		//duplicate leaf nodes - 50
		btree2.createSampleBinaryTree3();
		
		System.out.println();
		System.out.println();
		System.out.println("Before duplicate node deletion");
		btree2.inorder();
		
		anyLeafNodeDelete(btree2.root, 50);
		
		System.out.println();
		System.out.println();
		System.out.println("After duplicate 50 leaf node deletion");
		btree2.inorder();
		
		/*
		 * Tree 2 for duplicate leaf nodes
		 */
		
		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \
		 * 				 50    80  50  60
		 */
		
	}

}
