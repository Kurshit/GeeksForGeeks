package com.gfg.algos.trees.binarytree.misc;

import java.util.LinkedList;
import java.util.Queue;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

/*
 *  This program would delete the last leaf node (could be left or right) in B-Tree without having any key value initially.
 *  
 *  Approach 1 : Find height of the tree. Process last level of tree and keep track of Last Processed node and its parent.
 *  
 *    Approach 2 : Perform the level order traversal and keep track of parent and last processed leaf nodes one level
 *    before. 
 *  
 *  
 */



public class DeletLastLeafNode {
	
	
	public int height(Node root) {
		
		if(root == null)
			return 0;
		
		int lheight = height(root.left) + 1;
		int rheight = height(root.right) + 1;
		
		return Math.max(lheight, rheight);
		
	}
	
	public void deleteLastNode(Node root) {
		
		int levelOfLastNode = height(root);
		getLastNodeAndItsParent(root, levelOfLastNode, null);
		
		if(lastLevelLevelOrder != null && parentOfLastNode != null) {
			System.out.println("Last node in a tree : " +lastLevelLevelOrder.data);
			System.out.println("Parent of above last node in a tree: " + parentOfLastNode.data);
			
			if(parentOfLastNode.right != null)
				parentOfLastNode.right = null;
			else 
				parentOfLastNode.left = null;
		
		}
		else
			System.out.println("Empty Tree");
		
	}	
	
	public static Node lastLevelLevelOrder;
	public static Node parentOfLastNode;
	
	public void getLastNodeAndItsParent(Node root, int level, Node parent) {
		
		if(root == null)
			return;
		
		if(level == 1) {
			lastLevelLevelOrder = root;
			parentOfLastNode = parent;
			
		}
		getLastNodeAndItsParent(root.left, level - 1, root);
		getLastNodeAndItsParent(root.right, level - 1, root);
			
		
	}
	
	public static Node lastLevelLevelOrderUsingQueue;
	public static Node parentOfLastNodeUsingQueue;
	
	public void getAndDeleteLastNodeAndItsParentUsingQueue(Node root) {
		
		if(root == null)
			return;
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			if(temp.left != null) {
				
				queue.offer(temp.left);
				
				if(temp.left.left == null && temp.left.right == null) {
					lastLevelLevelOrderUsingQueue = temp.left;
					parentOfLastNodeUsingQueue = temp;
					
				}
			}
			
			if(temp.right != null) {
				queue.offer(temp.right);
				
				if(temp.right.left == null && temp.right.right == null) {
					lastLevelLevelOrderUsingQueue = temp.right;
					parentOfLastNodeUsingQueue = temp;
					
				}
			}
			
			
		}
		
		if(lastLevelLevelOrderUsingQueue != null && parentOfLastNodeUsingQueue != null) {
			System.out.println("Last node in a tree : " +lastLevelLevelOrderUsingQueue.data);
			System.out.println("Parent of above last node in a tree: " + parentOfLastNodeUsingQueue.data);
			
			if(parentOfLastNodeUsingQueue.right != null)
				parentOfLastNodeUsingQueue.right = null;
			else 
				parentOfLastNodeUsingQueue.left = null;
		
		}
		else
			System.out.println("Empty Tree");
	
	}
	
	public static void main(String[] args) {
			
		BTREE btree1 = new BTREE();
		btree1.createSampleBinaryTree1();
		
		BTREE btree2 = new BTREE();
		btree2.createSampleBinaryTree2();
		
		DeletLastLeafNode pln = new DeletLastLeafNode();
		
		btree1.inorder();
		System.out.println();
		
			
		//pln.deleteLastNode(btree1.root);
		pln.getAndDeleteLastNodeAndItsParentUsingQueue(btree1.root);
		
		btree1.inorder();
		
		//btree2.inorder();
		System.out.println();
		
			
		//pln.deleteLastNode(btree2.root);
		
		//btree2.inorder();
		
		
		
		
		
		
		/*Sample tree
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \
		 * 				 70    80  50  60
		 */
		
		/* Tree 2 
		 * 
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /   
		 *                   9    
		 * 			
		 */
		

	}

}
