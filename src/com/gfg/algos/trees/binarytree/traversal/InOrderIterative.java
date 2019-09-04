package com.gfg.algos.trees.binarytree.traversal;

import java.util.Stack;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

/*
 * Write a prpogram to perform inorder traversal using Iterative approach
 */


public class InOrderIterative {
	
	
	public void inorderIterative(Node root) {
		
		if(root == null)
			return;
		
		Stack<Node> stack = new Stack<>();
		
		Node curr = root;
		
				
		while(curr != null || stack.size() > 0) {
			
			while(curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			
			curr = stack.pop();
			
			System.out.print(curr.data + " ");
			
			curr = curr.right;
			
		}
		
	}

	public static void main(String[] args) {
		
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
		
		InOrderIterative inorder = new InOrderIterative();
		
		inorder.inorderIterative(btree.root);
		

	}

}
