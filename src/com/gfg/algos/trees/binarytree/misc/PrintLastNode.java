package com.gfg.algos.trees.binarytree.misc;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

/*
 *  This program would print the last node in a BTREE. 
 *  
 *  Last Node - the last node (right or left) in last level
 * 
 *   ** IMP** This approach is wrong - check following examples
 *  Approach 1: Do preorder traversal and keep track of last processed node and print it once done with preorder
 *    			A. Preorder recursively
 *    			B. Pre order using stack
 *  
 *   // This is a correct approach 
 *  Approach 2: Get all nodes of Last level of TRee and print last node of it
 */



public class PrintLastNode {
	
	public static Node lastNode;
	
	//Approach 1 A: -- Wrong output
		
	public void printLastNodeRecursively(Node root) {
		
		inorder(root);
		
		if(lastNode != null)
			System.out.println(" ** Incorrect ** Last Node in tree : " + lastNode.data);
		else
			System.out.println("Tree is empty");
		
		
	}
	
	public void inorder(Node root) {
		
		if(root == null)
			return;
		
		lastNode = root;
		
		inorder(root.left);
		inorder(root.right);
		
	}
	
	// Approach 2:
	
	public int height(Node root) {
		
		if(root == null)
			return 0;
		
		int lheight = height(root.left) + 1;
		int rheight = height(root.right) + 1;
		
		return Math.max(lheight, rheight);
		
	}
	
	public void printLastNodeLevelOrder(Node root) {
		
		int levelOfLastNode = height(root);
		nodesAtGivenLevel(root, levelOfLastNode);
		
		if(lastLevelLevelOrder != null)
			System.out.println("Last node in a tree : " +lastLevelLevelOrder.data);
		else
			System.out.println("Empty Tree");
		
	}
	
	public static Node lastLevelLevelOrder;
	
	public void nodesAtGivenLevel(Node root, int level) {
		
		if(root == null)
			return;
		
		if(level == 1)
			lastLevelLevelOrder = root;
		
		nodesAtGivenLevel(root.left, level - 1);
		nodesAtGivenLevel(root.right, level - 1);
			
		
	}
	
	public static void main(String[] args) {
			
		BTREE btree1 = new BTREE();
		btree1.createSampleBinaryTree1();
		
		BTREE btree2 = new BTREE();
		btree2.createSampleBinaryTree2();
		
		PrintLastNode pln = new PrintLastNode();
		
		//following is a wrong approach and prints wrong values 
		
		pln.printLastNodeRecursively(btree1.root);
		pln.printLastNodeRecursively(btree2.root);
		
		pln.printLastNodeLevelOrder(btree1.root);
		pln.printLastNodeLevelOrder(btree2.root);
		
		/*Sample tree
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \
		 * 				 70    80  50  60
		 */
		
		/* Tree 2 
		 * 
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /   
		 *                   9    
		 * 			
		 */
		

	}

}
