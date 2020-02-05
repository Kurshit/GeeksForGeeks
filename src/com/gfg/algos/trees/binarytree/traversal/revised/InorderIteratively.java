package com.gfg.algos.trees.binarytree.traversal.revised;

import java.util.Stack;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

public class InorderIteratively {
	
	public static void inorderIteratively(Node root) {
		
		if(root == null)
			return;
		
		Node curr = root;
		
		Stack<Node> stack = new Stack<>();
		
		
		while(curr != null || !stack.isEmpty()) {
				
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
		
		inorderIteratively(btree.root);
		
	}

}
