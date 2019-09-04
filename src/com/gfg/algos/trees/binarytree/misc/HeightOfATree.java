package com.gfg.algos.trees.binarytree.misc;

import java.util.LinkedList;
import java.util.Queue;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

public class HeightOfATree {
	
	/*
	 * Time Complexity : O(n)
	 */

	public static int height(Node newRoot) {
		
		if(newRoot == null)
			return 0;
		
		int lheight = height(newRoot.left) + 1;
		int rheight = height(newRoot.right) + 1;
		
		//return lheight;
		//return rheight;
		
		return Math.max(lheight, rheight);
		
	}
	
	
	/*
	 * Time Complexity : O(n)
	 */
	
	public static int heightIteratively(Node newRoot) {
		
		if(newRoot == null) {
			return 0;
		}
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(newRoot);
		int height = 0;
		 
		while(true) {
			
			int nodeCount = queue.size();
			
			if(nodeCount == 0)
				return height;
			
			height++;
			
			while(nodeCount > 0) {
				Node temp = queue.poll();
				
				if(temp.left != null) 
				{
					queue.offer(temp.left);
				} 
				
				if(temp.right != null) {
					queue.offer(temp.right);
				}
				
				nodeCount--;
			}
			
		}		
		
		//return height - unreachable statement
	}
	
	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.createSampleBinaryTree1();
		
		System.out.println(height(btree.root));
		
		System.out.println(heightIteratively(btree.root));

	}

}
