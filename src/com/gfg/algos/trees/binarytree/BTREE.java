package com.gfg.algos.trees.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.gfg.algos.trees.bst.BST.Node;

public class BTREE {

	public Node root;

	public void add(int data) {
		addNode(root, data);
	}

	public void addNode(Node newRoot, int data) {

		if(newRoot == null ) {
			root = new Node(data);
			return;

		}

		Queue<Node> queue = new LinkedList<>();

		queue.offer(newRoot);

		while(!queue.isEmpty()) {

			Node temp = queue.poll();

			if(temp.left == null) {
				temp.left = new Node(data);
				break;
			}
			else {
				queue.offer(temp.left);
			}

			if(temp.right == null) {
				temp.right = new Node(data);
				break;
			} else
				queue.offer(temp.right);

		}	

	}

	public void delete(int data) {

		deleteNode(this.root, data);

	}

	public void deleteNode(Node newRoot, int key) {

		if(newRoot == null)
			return;

		Queue<Node> queue = new LinkedList<>();

		queue.offer(newRoot);

		while(!queue.isEmpty()) {

			Node temp = queue.poll();

			if(temp.data == key ) {



			}
			else {

				if(temp.left != null)
					queue.offer(temp.left);

				if(temp.right != null)
					queue.offer(temp.right);


			}



		}


	}

	public void inorder() {
		inorderNode(root);
	}

	public void inorderNode(Node newRoot) {

		if(newRoot == null)
			return;

		inorderNode(newRoot.left);
		System.out.print(newRoot.data + " ");
		inorderNode(newRoot.right);

	}


	public int height() {
		return height(root);
	}

	public int height(Node newRoot) {

		if(newRoot ==null)
			return 0;

		int lheight = height(newRoot.left) + 1;
		int rheight = height(newRoot.right) + 1;

		return Math.max(lheight, rheight);

	}

	public int heightOfAGivenNode(int data) {
		return heightOfAGivenNode(root, data);
	}

	public int heightOfAGivenNode(Node newRoot, int data) {

		if(newRoot == null)
			return 0;

		Queue<Node> queue = new LinkedList<>();

		queue.offer(newRoot);

		while(!queue.isEmpty()) {

			Node temp = queue.poll();

			if(temp.data == data) {
				return height(temp);
			}

			if(temp.left != null) {
				queue.offer(temp.left);
			}

			if(temp.right != null) {
				queue.offer(temp.right);
			}
		}



		return 0;
	}

	public void levelOrderTraversal() {
		levelOrderTraversalNode(root);
	}

	public void levelOrderTraversalNode(Node newRoot) {

		if(newRoot == null) 
			return;

		Queue<Node> queue = new LinkedList<>();

		queue.offer(newRoot);

		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.data + " ");

			if(temp.left != null) {
				queue.offer(temp.left);
			} 

			if(temp.right !=null) {
				queue.offer(temp.right);
			}

		}

	}

	public void levelOrderTraversalUsingHeight() {

		int heightOfATree = height(root);

		for(int i=0; i<heightOfATree; i++) {
			nodesAtGivenLevel(i);
		}

	}

	public void nodesAtGivenLevel(int level) {
		nodesAtGivenLevelNode(root,level);
	}

	public void nodesAtGivenLevelNode(Node newRoot, int level) {

		if(level == 0) {
			return;
		}

		if(level == 1) {
			System.out.print(newRoot.data + " ");
			return;
		}

		nodesAtGivenLevelNode(newRoot.left, level - 1);
		nodesAtGivenLevelNode(newRoot.right, level - 1);



	}

	public boolean search(int data) {
		return searchNode(root,data);
	}

	public boolean searchNode(Node newRoot, int data) {

		if(newRoot == null) 
			return false;

		Queue<Node> queue = new LinkedList<>();

		queue.offer(newRoot);

		while(!queue.isEmpty()) {
			Node temp = queue.poll();

			if(temp.data == data) {
				return true;
			}

			if(temp.left != null) {
				queue.offer(temp.left);
			} 

			if(temp.right !=null) {
				queue.offer(temp.right);
			}

		}

		return false;

	}

	public int getLevelOfANode(int data) {
		return getLevelOfANodeNode(root, data, 1);
	}

	public int getLevelOfANodeNode(Node newRoot, int key, int level) {

		if(newRoot == null)
			return 0;

		if(newRoot.data == key) 
			return level;

		int resultLevel = getLevelOfANodeNode(newRoot.left, key, level + 1);

		/*
		 * The following check is must. If we right away write - 
		 * 
		 * getLevelOfANodeNode(newRoot.left, key, level + 1);
		 * getLevelOfANodeNode(newRoot.right, key, level + 1);
		 * 
		 *  -- considering for every valid search result if would return desired level. 
		 *  
		 *  This would always return 0 because the result value gets over ridden by next call to same method.
		 *  
		 *  Hence we save the value in first call, check if it is not zero - which would confirm if element was
		 *   found in left subtree or not.
		 *  
		 */


		if(resultLevel != 0) 
			return resultLevel;

		return getLevelOfANodeNode(newRoot.right, key, level + 1);


	}

	public void createSampleBinaryTree1() {

		add(10);
		add(5);
		add(20);
		add(9);
		add(7);
		add(30);
		add(40);
		add(70);
		add(80);
		add(50);
		add(60);


		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \
		 * 				 70    80  50  60
		 */



	}

	public void createSampleBinaryTree2() {

		add(10);
		add(5);
		add(20);
		add(9);


		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \
		 * 				 70    80  50  60
		 */



	}

	//WIth duplicateLeafNode

	public void createSampleBinaryTree3() {

		add(10);
		add(5);
		add(20);
		add(9);
		add(7);
		add(30);
		add(40);
		add(50);
		add(80);
		add(50);
		add(60);


		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \
		 * 				 50    80  50  60
		 */



	}

	public void createSampleBinaryTree4() {

		add(10);
		add(5);
		add(20);
		add(9);
		add(7);
		add(30);
		add(40);
		add(50);
		add(80);
		add(50);
		add(60);
		
		add(70);
		add(80);
		add(90);
		add(100);
		
		add(110);
		add(120);
		add(130);
		add(140);


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



	}

	
	public void createSumTree() {

		add(50);
		add(20);
		add(30);
		add(15);
		add(5);
		add(27);
		add(3);
		add(15);
		

		/*
		 * 								50
		 * 							/	     \
		 * 						  20		 30
		 * 					   /     \      /      \
		 *                   15       5    27       3
		 * 				  /      
		 * 				 15
		 * 
 		 */



	}

	public void createUncoveredCoveredSumTree() {

		root = new Node(10); 
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40); 
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        root.left.left.left = new Node(80);
        
        root.left.right.left = new Node(45);
         
        root.left.right.right = new Node(100); 
        
         
        root.left.left.left.right = new Node(5); 

		/*
		 * 								10
		 * 							/	     \
		 * 						  20		 30
		 * 					   /     \      /      \
		 *                   40       50    60      70
		 * 				  /          /  \    
		 * 				 80         45   100
		 *                 \
		 * 					5
 		 */



	}


	public void clear() {
		root = null;
	}


}
