package com.gfg.algos.trees.binarytree.misc;

import java.util.LinkedList;
import java.util.Queue;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

public class SizeOfATree {

	public static int size(Node newRoot) {
		if(newRoot == null)
			return 0;
		
		int lsize = size(newRoot.left);
		int rsize = size(newRoot.right);
		
		//System.out.print(newRoot.data + " " );  // uncomment this to see visiting sequence
		
		return lsize + rsize + 1;
		
		/*
		 *  keeping lsize and rsize is just a trick to make it behave like a counter.
		 *  
		 *  Those are anyway gonna return 0 for every case and adds previously added 1 to it.
		 *  
		 *  Alternatively calling size left and then right will result in following sequence visit
		 *  
		 *  70 80 9 50 60 7 5 30 40 20 10 
		 *  
		 *  Alternate approach using static counter is sizeStaticCounter
		 */		
	}
	
	public static int count = 0;
	
	public static int sizeStaticCounter(Node newRoot) {
		
		if(newRoot == null) 
			return 0;
		
		sizeStaticCounter(newRoot.left);
		sizeStaticCounter(newRoot.right);
		
		count = count + 1;
		
		return count;
		
		
	}
	
	public static int sizeIteratively(Node root) {
		
		if(root == null)
			return 0;
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(root);
		
		int count = 0;
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			count++;
			
			if(temp.left != null)
			{
				queue.offer(temp.left);
			}
			
			if(temp.right != null) {
				queue.offer(temp.right);
			}		
			
		}
		
		return count;
	}
	
	
	/*
	 *  Tree - 
	 *  
	 *  
	 *  					10
	 *  				/	 	 \
	 *  			  5            20
	 *			   /      \      /    \
	 *           9         7    30     40
	 *        /     \     / \
	 *      70       80  50  60
	 *       
	 */
	
	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		btree.createSampleBinaryTree1();
		
		System.out.println();
		
		System.out.println(size(btree.root));
		
		System.out.println(sizeStaticCounter(btree.root));
		
		System.out.println(sizeIteratively(btree.root));
		

	}

}
