package com.gfg.algos.trees.binarytree.traversal.revised;

import java.util.Stack;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

public class PreOrderIteratively {


	public static void preOrderIteratively(Node root) {

		if(root == null) {
			return;
		}

		Node curr = root;

		Stack<Node> stack = new Stack<>();

		while(curr != null || !stack.isEmpty()) {

			while(curr != null) {
				
			}
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

		preOrderIteratively(btree.root);


	}

}
