package com.gfg.algos.trees.binarytree.misc;

import java.util.LinkedList;
import java.util.Queue;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;


/* Given a binary tree and a target integer x, delete any of leaf nodes having value as x. 
 * 
 *  IF given value is not leaf node, ignore and keep tree intact.
 *  
 *  If there are more than one target value as leaf nodes, this shall delete them all
 * 
 * https://www.geeksforgeeks.org/delete-leaf-nodes-value-x/
 * 
 * Approach 1: Do postorder traversal and keep track of parent and check if visited node is leaf and matches
 * with X. Set parent = null
 * 
 * Approach 2: Do level order traversal and check if visited node is leaf and if it matches with X. 
 * If Yes, set parent to null. --
 * 
 * 
 */

public class LeafNodeXDelete {
	
	//Approach 1

	public Node anyLeafNodeDelete(Node newRoot, int x) {
		
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
	
	//Approach 2: 
	
	public void deleteXLeafNodeLevelOrder(Node root, int x) {
		
		if(root == null) { 
			System.out.println("Empty Tree");
			return;
		}
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			if(temp.left != null) {
				
				queue.offer(temp.left);
				
				if(temp.left.data == x && temp.left.left == null && temp.left.right == null) {
					temp.left = null;
				}
			}
			
			if(temp.right != null) {
				
				queue.offer(temp.right);
				
				if(temp.right.data == x && temp.right.left == null && temp.right.right == null) {
					temp.right = null;
				}
			}
			
			
		}
	}
	
	
	public static void main(String[] args) {
		
		BTREE btree1 = new BTREE();
		LeafNodeXDelete lnxd = new LeafNodeXDelete();
		btree1.createSampleBinaryTree1();
		
		btree1.inorder();
		System.out.println();
		System.out.println("After deleting 60");
		lnxd.anyLeafNodeDelete(btree1.root, 60);
		System.out.println();
		
		btree1.inorder();
		
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
		
		lnxd.anyLeafNodeDelete(btree2.root, 50);
		
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
		
		
		System.out.println("\nUsing Level order traversal :\n");
		
		BTREE btree3 = new BTREE();
		
		btree3.createSampleBinaryTree1();
		
		System.out.println("Before deletion of 50 : \n");
		btree3.inorder();
		
		lnxd.deleteXLeafNodeLevelOrder(btree3.root, 50);
		
		/* BTREE 3
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \
		 * 				 70    80  50  60
		 * 
		 */
		
		System.out.println("\nAfter deletion : \n");
		btree3.inorder();
		
		BTREE btree4 = new BTREE();
		
		btree4.createSampleBinaryTree3();
		
		System.out.println("Before DUPLICATE deletion of 50 : \n");
		btree4.inorder();
		
		lnxd.deleteXLeafNodeLevelOrder(btree4.root, 50);
		
		/*
		 * BTREE 4 - duplicate node 50
		 * 
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \
		 * 				 50    80  50  60
		 */
		
		System.out.println("\nAfter deletion of 50: \n");
		btree4.inorder();
		
		
		
		
		
	}

}
