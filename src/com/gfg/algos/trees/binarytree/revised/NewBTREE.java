package com.gfg.algos.trees.binarytree.revised;

import java.util.LinkedList;
import java.util.Queue;

public class NewBTREE {
	
	public class Node {
		int data;
		Node left, right;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public Node root;
	
	public void add(int data) {
		addNode(this.root, data);
	}
		
	public void addNode(Node newRoot, int data) {
		
		if(newRoot == null) {
			this.root = new Node(data);
			return;
		}
		
		Queue<Node> queue = new LinkedList<>();
		Node newNode = new Node(data);
		queue.offer(newRoot);
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			if(temp.left == null) {
				temp.left = newNode;
				break;
			} else {
				queue.offer(temp.left);
			}
			
			if(temp.right == null) {
				temp.right = newNode;
				break;
			} else {
				queue.offer(temp.right);
			}
			
		}		
	}
	
	public void inorder() {
		inorderNode(this.root);
		System.out.println();
	}
	
	public void inorderNode(Node newRoot) {
		
		if(newRoot == null)
			return;
		
		inorderNode(newRoot.left);
		System.out.print(newRoot.data + " ");
		inorderNode(newRoot.right);
	}
	
	public void levelOrderTraversal() {
		levelOrderTraversalNode(this.root);
		System.out.println();
	}
	
	public void levelOrderTraversalNode(Node newRoot) {
		
		if(newRoot == null)
			return;
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(newRoot);
		System.out.println("Level order Traversal is : " );
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
	
	public void levelOrderUsingRecurssion() {
		levelOrderUsingRecurssionNode(this.root);
	}
	
	public void levelOrderUsingRecurssionNode(Node newRoot) {
		
		if(newRoot == null)
			return;
		
		int height = heightNode(newRoot);
		
		for(int i=1; i<=height; i++ ) {
			printGivenLevel(i);
			System.out.println();
		}
		
	}
	
	public void printGivenLevel(int level) {
		printGivenLevelNode(this.root, level);
	}
	
	public void printGivenLevelNode(Node newRoot, int level) {
		
		if(newRoot == null)
			return;
		
		if(level == 1) {
			System.out.print(newRoot.data + " ");
			return;
		}
		
		printGivenLevelNode(newRoot.left, level - 1);
		printGivenLevelNode(newRoot.right, level - 1);
		
		
	}
	
	public int height() {
		return heightNode(this.root);
	}
	
	public int heightNode(Node newRoot) {
		
		if(newRoot == null)
			return 0;
		
		
		int lh = heightNode(newRoot.left) + 1;
		int rh = heightNode(newRoot.right) + 1;
		
		return Math.max(lh, rh);
	}
	
	public void inorderWithoutRecursion() {
		inorderWithoutRecursion(this.root);
	}
	
	public void inorderWithoutRecursion(Node newRoot) {
		
		if(newRoot == null)
			return;
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		NewBTREE btree = new NewBTREE();
		
		btree.add(10);
		btree.add(20);
		btree.add(30);
		btree.add(40);
		btree.add(50);
		
		btree.inorder();
		
		btree.levelOrderTraversal();
		
		System.out.println(btree.height());
		
		btree.printGivenLevel(4);
		
		System.out.println("Level order traversal using recursion is : ");
		
		btree.levelOrderUsingRecurssion();

	}
}
