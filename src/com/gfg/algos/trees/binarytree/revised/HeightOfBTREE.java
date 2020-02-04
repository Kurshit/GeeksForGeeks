package com.gfg.algos.trees.binarytree.revised;

import java.util.LinkedList;
import java.util.Queue;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

public class HeightOfBTREE {
	
	public int height(Node root) {
		if(root == null) 
			return 0;
		
		int lh = height(root.left) + 1;
		int rh = height(root.right) + 1;
		
		return Math.max(lh, rh);
	}
	
	public int heightIteretively(Node root) {
		
		if(root == null)
			return 0;
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(root);
		int height = 0;
		
		while(true) {
			
			int nc = queue.size();
			
			if(nc == 0)
				return height;
			
			height++;
			
			while(nc > 0) {
				
				Node temp = queue.poll();
				
				if(temp.left != null)
					queue.offer(temp.left);
				
				if(temp.right != null)
					queue.offer(temp.right);
			
				nc--;
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

		
		HeightOfBTREE hot = new HeightOfBTREE();
		
		System.out.println(hot.height(btree.root));
		System.out.println(hot.heightIteretively(btree.root));

	}

}
