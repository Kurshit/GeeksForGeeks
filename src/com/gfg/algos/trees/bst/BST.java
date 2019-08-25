package com.gfg.algos.trees.bst;

public class BST {

	public Node root;
			
	public static class Node {
		public int data;
		public Node left, right;
		
		public Node(int data) {
			this.data = data;
			left = right = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
		}
		
		
		
		
		
	}
	
	public void add(int data) {
		root = addNode(root, data);
	}
	
	public Node addNode(Node newRoot, int data) {
		
		Node temp = new Node(data);
		
		if(newRoot == null)
			return newRoot = temp;
		
		if(data > newRoot.data)
			newRoot.right = addNode(newRoot.right, data);
		else 
			newRoot.left = addNode(newRoot.left, data);
		
		return newRoot;
	}
	
	public void inorder() {
		inorder(root);
	}
	
	public void inorder(Node newRoot) {
		if(newRoot == null)
			return;
		
		inorder(newRoot.left);
		System.out.print(newRoot.data + " ");
		inorder(newRoot.right);
	}
	
	public Node search(int data) {
		return searchNode(this.root, data);
	}
	
	public Node searchNode(Node newRoot, int data) {
		
		if(newRoot == null)
			return null;
		
		if(newRoot != null && newRoot.data == data)
			return newRoot;
		
		if(data > newRoot.data)
			return searchNode(newRoot.right, data);
		else
			return searchNode(newRoot.left, data);
	}
	
	public void delete(int data) {
		root = deleteNode(root,data);
	}
	
	public Node deleteNode(Node newRoot, int data) {
		
		if(newRoot == null)
			return null;
		
		if(data < newRoot.data) {
			newRoot.left = deleteNode(newRoot.left, data);
		}
		else if(data > newRoot.data) {
			newRoot.right = deleteNode(newRoot.right, data);
		}
		else {			
			if(newRoot.left == null)
				return newRoot.right;
			else if(newRoot.right == null)
				return newRoot.left;
			
			newRoot.data = minValue(newRoot.right);
			
			newRoot.right = deleteNode(newRoot.right, newRoot.data);
			
		}
		
		
		return newRoot;
	}
	
	public int minValue(Node newRoot) {
		int minValue = newRoot.data;
		
		while(newRoot.left != null) {
			minValue = newRoot.left.data;
			newRoot = newRoot.left;
		}
		
		return minValue;
	}
	
	
	public void createSampleTree() {
		 add(50);
		 add(30);
		 add(70);
		 add(20);
		 add(40);
		 add(60);
		 add(80);
		 add(15);
		 add(25);
		 add(35);
		 add(45);
		 add(75);
		 add(85);
		 add(10);	 
		 
	}

}
