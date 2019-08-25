package com.gfg.algos.trees.binarytree;

import com.gfg.algos.trees.bst.basicops.HeightOfATree;

public class BTREESampleApp {

	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.add(1);
		btree.add(5);
		btree.add(9);
		btree.add(12);
		btree.add(13);
		btree.add(20);
		btree.add(19);
		btree.add(18);
		
		/*
		 * 								1
		 * 						    /       \
		 * 						   5		 9
		 * 						/     \    /   \
		 *                    12      13  20    19
		 *                  / 
		 *                18
		 * 
		 * 
		 */
		
		System.out.println("Inorder traversla is :");
		btree.inorder();
		
		System.out.println();
		
		System.out.println("Height is : " +btree.height());
		
		System.out.println("Level order traversal is");
		
		btree.levelOrderTraversal();
		
		System.out.println();
		
		int key = 19;
		
		System.out.println("Does element " + key + " exist in btree ? " + btree.search(key));
		
		btree.nodesAtGivenLevel(1);
		
		int heightOfNode = 5;
		
		System.out.println("Height of a node " + heightOfNode + " is :" + btree.heightOfAGivenNode(heightOfNode));
		
		int keyNode = 18;
		
		System.out.println("The level of node " + keyNode + " is :" +btree.getLevelOfANode(keyNode));

	}

}
