package com.gfg.algos.trees.binarytree.summation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import com.gfg.algos.trees.binarytree.BTREE;

public class DiagonalSumPrint {
	
	public void diagonalSumPrint(DNode root) {
		
		if(root == null)
			return;
		
		Queue<DNode> queue = new LinkedList<>();
		
		Map<Integer, Integer> sumMap = new HashMap<>();
		
		root.vd = 0; // by default 0 
		
		queue.offer(root);
		
		while(!queue.isEmpty()) {
					
			DNode curr = queue.poll();
			
			int currVd = curr.vd;
						
			while(curr != null) {
				
				int prevValue = sumMap.get(currVd) != null ? sumMap.get(currVd) : 0;
				
				sumMap.put(currVd, prevValue + curr.data);
				
				if(curr.left != null) {
					curr.left.vd  = currVd +1;
					queue.offer(curr.left);
				}
				
				curr = curr.right;
			}			
		}
		
		System.out.println(sumMap);	
		
	}

	public static void main(String[] args) {
		
		DiagonalSumPrint btree = new DiagonalSumPrint();
		btree.createSampleBinaryTree1();
		
		
		
		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \       /      \
		 *                   9       7     30       40
		 * 				  /    \    / \    
		 * 				 70    80  50  60 
		 */

		btree.diagonalSumPrint(btree.root);
	}
	
	private class DNode {
		
		public int data, vd; // verticle distance
		DNode left, right;
		
		public DNode(int data) {
			this.data = data;
		}		

	}
	
	public DNode root;

	public void add(int data) {
		addNode(root, data);
	}

	public void addNode(DNode newRoot, int data) {

		if(newRoot == null ) {
			root = new DNode(data);
			return;

		}

		Queue<DNode> queue = new LinkedList<>();

		queue.offer(newRoot);

		while(!queue.isEmpty()) {

			DNode temp = queue.poll();

			if(temp.left == null) {
				temp.left = new DNode(data);
				break;
			}
			else {
				queue.offer(temp.left);
			}

			if(temp.right == null) {
				temp.right = new DNode(data);
				break;
			} else
				queue.offer(temp.right);

		}	

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
		 * 					   /     \       /      \
		 *                   9       7     30       40
		 * 				  /    \    / \    
		 * 				 70    80  50  60 
		 */



	}

}
