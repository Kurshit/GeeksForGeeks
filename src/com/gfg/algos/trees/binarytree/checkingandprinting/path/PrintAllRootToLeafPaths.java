package com.gfg.algos.trees.binarytree.checkingandprinting.path;

import java.util.HashMap;
import java.util.Stack;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;


public class PrintAllRootToLeafPaths {

	void printPaths(Node node)  
	{ 
		int path[] = new int[1000]; 
		printPathsRecur(node, path, 0); 
	} 

	/* Recursive helper function -- given a node, and an array containing 
       the path from the root node up to but not including this node, 
       print out all the root-leaf paths. */
	void printPathsRecur(Node node, int path[], int pathLen)  
	{ 
		if (node == null) 
			return; 

		/* append this node to the path array */
		path[pathLen] = node.data; 
		pathLen++; 

		/* it's a leaf, so print the path that led to here */
		if (node.left == null && node.right == null) 
			printArray(path, pathLen); 
		else
		{  
			/* otherwise try both subtrees */
			printPathsRecur(node.left, path, pathLen); 
			printPathsRecur(node.right, path, pathLen); 
		} 
	} 
	

	/* Utility that prints out an array on a line */
	void printArray(int ints[], int len)  
	{ 
		int i; 
		for (i = 0; i < len; i++)  
			System.out.print(ints[i] + " "); 
		System.out.println(""); 
	}

	public void printPathIteratively(Node root) {

		if(root == null)
			return;

		Stack<Node> stack = new Stack<>();

		stack.push(root);

		HashMap<Node,Node> parentMap = new HashMap<>();

		while(!stack.isEmpty()) {

			Node temp = stack.pop();

			if(temp.left == null && temp.right ==  null) {
				printTopToDownUsingStackAndMap(temp,parentMap);
				System.out.println();
			} 
			
			
			if(temp.right != null) {
				stack.push(temp.right);
				parentMap.put(temp.right, temp);
			}
			
			if(temp.left != null) {
				stack.push(temp.left);
				parentMap.put(temp.left, temp);
			}
		}    	

	}

	public void printTopToDownUsingStackAndMap(Node curr, HashMap<Node,Node> parentMap) {
		
		Stack<Node> pathStack = new Stack<Node>();
		
		while(curr != null) {
			
			pathStack.push(curr);
			curr = parentMap.get(curr);
		}

		while(!pathStack.isEmpty()) {
			
			Node temp = pathStack.pop();
			System.out.print(temp.data + " ");
			
		}

	}


	public static void main(String[] args) {

		BTREE btree = new BTREE();
		btree.createSampleBinaryTree1();

		PrintAllRootToLeafPaths path = new PrintAllRootToLeafPaths();

		//path.printPaths(btree.root);
		
		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \
		 * 				 70    80  50  60
		 */

		
		path.printPathIteratively(btree.root);

	}

}
