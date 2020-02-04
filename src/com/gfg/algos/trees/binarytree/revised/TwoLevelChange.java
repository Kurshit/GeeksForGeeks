package com.gfg.algos.trees.binarytree.revised;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

public class TwoLevelChange {

	public void twoLevelChange(Node root) {

		if(root == null)
			return;

		if(root.left == null && root.left == null) {
			System.out.println(root.data);
			return;
		}

		Queue<Node> queue = new LinkedList<>();

		Stack<Node> stack = new Stack<>();

		queue.offer(root);

		int nc = 0;

		int level = 0;

		boolean rightToLeft = false;

		while(!queue.isEmpty()) {
			System.out.println();

			nc = queue.size();

			level++;

			while(nc > 0) {

				Node temp = queue.poll();

				if(!rightToLeft) {
					System.out.print(temp.data + " ");
				} else {
					stack.push(temp);
				}

				if(temp.left != null) 
					queue.offer(temp.left);

				if(temp.right != null)
					queue.offer(temp.right);

				nc--;

			}

			System.out.println();
			
			if(rightToLeft) {

				while(!stack.isEmpty()) {

					System.out.print(stack.pop().data + " ");
				}
			}

			if(level == 2) {
				rightToLeft = !rightToLeft;
				level = 0;
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
		
		TwoLevelChange two = new TwoLevelChange();
		
		two.twoLevelChange(btree.root);
		
		btree.clear();
		
		btree.createSampleBinaryTree4();
		
		System.out.println();
		
		System.out.println("Second ex ");
		
		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \   / \     / \  
		 * 				 50    80  50  60 70 80  90  100
		 * 				/  \  /   \
		 * 			 110  120 130 140
		 * 
 		 */
		
		two.twoLevelChange(btree.root);

	}

}
