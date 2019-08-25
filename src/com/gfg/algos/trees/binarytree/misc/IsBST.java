package com.gfg.algos.trees.binarytree.misc;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

public class IsBST {
	
	static int lastValue = 0;
	
	public static boolean isBST(Node newRoot) {
		
		if(newRoot == null) {
			return true;
		}
		
		boolean leftResult = isBST(newRoot.left);
		
		if(!leftResult)
			return false;
		
		if(lastValue > newRoot.data )
			return false;
		else 
			lastValue = newRoot.data;
		
		return isBST(newRoot.right);
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.root = new Node(5);
		
		btree.root.left = new Node(1);
		btree.root.right = new Node(4);
		
		btree.root.right.left = new Node(3);
		btree.root.right.right = new Node(6);
		
		/*btree.add(50);
		btree.add(40);
		btree.add(60);
		btree.add(30);
		btree.add(41);
		btree.add(55);
		btree.add(60);
		*/
		btree.inorder();
		
		System.out.println(isBST(btree.root));
	}

}
