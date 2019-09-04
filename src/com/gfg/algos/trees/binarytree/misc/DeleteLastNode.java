package com.gfg.algos.trees.binarytree.misc;

import java.util.LinkedList;
import java.util.Queue;


public class DeleteLastNode {
	
	// to keep track of last processed nodes parent and node itself.	
	public static Node lastLevelLevelOrder;
	public static Node parentOfLastNode;

public void deleteLastNode(Node root) {
		
		if(root == null)
			return;
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			if(temp.left != null) {
				
				queue.offer(temp.left);
				
				if(temp.left.left == null && temp.left.right == null) {
					lastLevelLevelOrder = temp.left;
					parentOfLastNode = temp;
					
				}
			}
			
			if(temp.right != null) {
				queue.offer(temp.right);
				
				if(temp.right.left == null && temp.right.right == null) {
					lastLevelLevelOrder = temp.right;
					parentOfLastNode = temp;
					
				}
			}
			
			
		}
		
		if(lastLevelLevelOrder != null && parentOfLastNode != null) {
			
			if(parentOfLastNode.right != null)
				parentOfLastNode.right = null;
			else 
				parentOfLastNode.left = null;
		
		}
		else
			System.out.println("Empty Tree");
	
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(6);
		root.left = new Node(5);
		root.right = new Node(4);
		root.left.left = new Node(1);
		root.left.right = new Node(2);
		root.right.right = new Node(5);		
		
		DeleteLastNode deleteLastNode = new DeleteLastNode();
		System.out.println("Inorder traversal before deletion of last node : ");
		deleteLastNode.inorder(root);
		
		deleteLastNode.deleteLastNode(root);
		
		System.out.println("\nInorder traversal after deletion of last node : ");
		deleteLastNode.inorder(root);
		

	}
	
	public void inorder(Node root) {
		if(root == null)
			return;
		
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	static class Node {
		
		Node left, right;
		int data;
		
		Node(int data) {
			this.data = data;
		}
		
	}

}
