package com.gfg.algos.trees.binarytree.traversal;

//Java program to con string from binary tree 
import java.util.LinkedList;
import java.util.Queue;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node; 
class DiagonalTraversalIterative 
{ 


	//A binary tree node has data, pointer to left 
	//child and a pointer to right child 

	//Helper function that allocates a new node 

	//Iterative function to print diagonal view 
	static void diagonalPrint(Node root) 
	{ 
		// base case 
		if (root == null) 
			return; 

		// inbuilt queue of Treenode 
		Queue<Node> q= new LinkedList<Node>(); 

		// add root 
		q.add(root); 

		// add delimiter 
		q.add(null); 

		while (q.size()>0) { 
			Node temp = q.peek(); 
			q.remove(); 

			// if current is delimiter then insert another 
			// for next diagonal and cout nextline 
			if (temp == null) { 

				// if queue is empty return 
				if (q.size()==0) 
					return; 

				// output nextline 
				System.out.println(); 

				// add delimiter again 
				q.add(null); 
			} 
			else { 
				while (temp!=null) { 
					System.out.print( temp.data + " "); 

					// if left child is present 
					// add into queue 
					if (temp.left!=null) 
						q.add(temp.left); 

					// current equals to right child 
					temp = temp.right; 
				} 
			} 
		} 
	} 

	//Driver Code 
	public static void main(String args[]) 
	{ 
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


		diagonalPrint(btree.root); 
	} 
} 
//contributed by Arnab Kundu 
