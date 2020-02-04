package com.gfg.algos.trees.binarytree.revised;

import java.util.LinkedList;
import java.util.Queue;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

public class LineByLine {

	private void lineByLineWithTwoQueues(Node root) {

		if(root == null)
			return;

		Queue<Node> q1 = new LinkedList<>();
		Queue<Node> q2 = new LinkedList<>();

		q1.offer(root);

		while(!q1.isEmpty() || !q2.isEmpty()) {

			while(!q1.isEmpty()) {
				Node temp = q1.poll();

				System.out.print(temp.data + " ");

				if(temp.left != null)
					q2.offer(temp.left);

				if(temp.right != null)
					q2.offer(temp.right);


			}

			System.out.println();

			while(!q2.isEmpty()) {;

			Node temp = q2.poll();

			System.out.print(temp.data + " ");

			if(temp.left != null)
				q1.offer(temp.left);

			if(temp.right != null)
				q1.offer(temp.right);
			}

			System.out.println();
		}

	}

	private void lineByLineUsingHeight(Node root) {

		if(root == null)
			return;

		int h = height(root);

		for(int i =1; i<=h; i++) {

			printGivenLevel(root, i);
			System.out.println();
		}

	}

	public void printGivenLevel(Node root, int level) {

		if(root == null)
			return;

		if(level == 1) {
			System.out.print(root.data + " ");
		}

		printGivenLevel(root.left, level - 1);
		printGivenLevel(root.right, level - 1);
	}

	public int height(Node root) {

		if(root == null)
			return 0;

		int lh = height(root.left) + 1;

		int rh = height(root.right) + 1;

		return Math.max(lh, rh);

	}

	private void lineByLineUsingNullDelim(Node root) {

		if(root == null)
			return;

		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);

		while(!queue.isEmpty()) {

			Node temp = queue.poll();

			if(temp == null) {
				if(queue.size() == 0)
					return;
				else {
					System.out.println();
					queue.offer(null);
				}
			} else {
				
				System.out.print(temp.data + " ");
				
				if(temp.left != null)
					queue.offer(temp.left);
				
				if(temp.right != null)
					queue.offer(temp.right);

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


		LineByLine lbl = new LineByLine();

		System.out.println("\nUsing Height : ");

		lbl.lineByLineUsingHeight(btree.root);

		System.out.println("\nUsing Two queues : ");

		lbl.lineByLineWithTwoQueues(btree.root);

		System.out.println("\nUsing NULL as Delim :");
		lbl.lineByLineUsingNullDelim(btree.root);
		
		System.out.println("\nUsing Node Counter approach :");
		lbl.lineByLineUsingNodeCounter(btree.root);

	}
	
	public void lineByLineUsingNodeCounter(Node root) {
		
		if(root == null)
			return;
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			
			int nc = queue.size();
			
			if(nc == 0)
				return;
			
			while(nc >0) {
				Node temp = queue.poll();
				
				System.out.print(temp.data + " ");
				
				if(temp.left != null)
					queue.offer(temp.left);
				
				if(temp.right != null)
					queue.offer(temp.right);
				
				nc--;
			}
			
			System.out.println();
		}
	}


}
