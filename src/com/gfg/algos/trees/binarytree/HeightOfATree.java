package com.gfg.algos.trees.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.gfg.algos.trees.bst.BST.Node;

public class HeightOfATree {

	public static int height(Node newRoot) {
		
		if(newRoot == null)
			return 0;
		
		int lheight = height(newRoot.left) + 1;
		int rheight = height(newRoot.right) + 1;
		
		//return lheight;
		//return rheight;
		
		return Math.max(lheight, rheight);
		
	}
	
	public static int heightIteratively(Node newRoot) {
		
		if(newRoot == null) {
			return 0;
		}
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(newRoot);
		int height = 0;
		
		while(!queue.isEmpty()) {
			
			height++;
			
			System.out.println("Nodes at given level " +queue.size());
			
			Node temp = queue.poll();
			
			if(temp.left != null) 
			{
				queue.offer(temp.left);
			} 
			
			if(temp.right != null) {
				queue.offer(temp.right);
			}
			
			
			
		}
		
		
		return height;
		
		
		
	}
	
	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.createSampleBinaryTree1();
		
		System.out.println(height(btree.root));
		
		System.out.println(heightIteratively(btree.root));

	}

}
