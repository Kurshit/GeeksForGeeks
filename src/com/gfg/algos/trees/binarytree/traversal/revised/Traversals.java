package com.gfg.algos.trees.binarytree.traversal.revised;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

public class Traversals {

	public void printGivenLevel(Node root, int level) {

		if(root == null)
			return;


		if(level == 1) {
			System.out.print(root.data + " ");
		}

		printGivenLevel(root.left, level - 1);
		printGivenLevel(root.right, level - 1);

	}

	public void printGivenLevel(Node root, int level, boolean itr) {

		if(root == null)
			return;


		if(level == 1) {
			System.out.print(root.data + " ");
		}

		if(itr) {
			printGivenLevel(root.right, level - 1, itr);
			printGivenLevel(root.left, level - 1, itr);
		} else {
			printGivenLevel(root.left, level - 1, itr);
			printGivenLevel(root.right, level - 1, itr);
		}



	}

	public int height(Node root) {

		if(root == null)
			return 0;

		int lheight = height(root.left) + 1;
		int rheight = height(root.right) + 1;

		return Math.max(lheight, rheight);

	}

	public int heightIteratively(Node root) {

		if(root == null)
			return 0;

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);

		int height = 0;

		while(true) {

			int nodeCount = queue.size();

			if(nodeCount == 0)
				return height;

			height++;


			while(nodeCount > 0) {
				Node temp = queue.poll();
				if(temp.left != null) {
					queue.offer(temp.left);
				}

				if(temp.right != null) {
					queue.offer(temp.right);
				}

				nodeCount--;


			}

		}


	}

	public void levelOrderUsingHeightAndLevel(Node root) {

		int h = height(root);

		for(int i=1; i <= h; i++) {
			printGivenLevel(root, i);
		}

	}

	public void levelOrderUsingQueue(Node root) {

		if(root == null)
			return;

		Queue<Node> queue = new LinkedList<>();

		queue.offer(root);

		while(!queue.isEmpty()) {

			Node temp = queue.poll();

			System.out.print(temp.data + " ");

			if(temp.left != null) {
				queue.offer(temp.left);
			}

			if(temp.right != null) {
				queue.offer(temp.right);
			}

		}



	}

	public void inorderIteratively(Node root) {

		if(root == null) {
			return;
		}

		Node curr = root;

		Stack<Node> stack = new Stack<>();

		while(curr !=  null || !stack.isEmpty()) {

			while(curr != null) {
				stack.push(curr);
				curr = curr.left;
			}

			curr = stack.pop();

			System.out.print(curr.data + " ");

			curr = curr.right;



		}

	}

	public void zigZagTraversal(Node root) {

		if(root == null)
			return;

		int h = height(root);
		boolean itr = false;
		for(int i=1; i<=h; i++) {
			printGivenLevel(root, i, itr);
			itr = !itr;
		}
	}
	
	public void leftRightTraversal(Node root) {
		
		if(root == null)
			return;
		
		System.out.print(root.data + " ");
		
		if(root.left != null)
			System.out.println(root.left.data + " " + root.right.data );
		
		if(root.left.left == null)
			return;		
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(root.left);
		queue.offer(root.right);
		
		Node first = null;
		Node second = null;
		
		while(!queue.isEmpty()) {
			
			first = queue.poll();
			second = queue.poll();
			
			System.out.print(first.left.data + " " + second.right.data + " " + first.right.data + " " + second.left.data + " ");
			
			if(first.left.left != null) {
				queue.offer(first.left);
				queue.offer(second.right);
				queue.offer(first.right);
				queue.offer(second.left);
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

		Traversals t1 = new Traversals();

		t1.levelOrderUsingHeightAndLevel(btree.root);

		System.out.println();

		t1.levelOrderUsingQueue(btree.root);

		System.out.println();

		System.out.println("Height is : ");

		System.out.println(t1.heightIteratively(btree.root));

		System.out.println();

		t1.inorderIteratively(btree.root);
		
		System.out.println("\nZigZag:");
		
		t1.zigZagTraversal(btree.root);
		
		System.out.println();
		
		BTREE btree2 = new BTREE();
		btree2.createSampleBinaryTree4();
		
		t1.leftRightTraversal(btree2.root);



	}

}
