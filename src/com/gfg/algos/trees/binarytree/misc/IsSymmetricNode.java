package com.gfg.algos.trees.binarytree.misc;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

public class IsSymmetricNode {

	public boolean isSymmetric(Node root) {

		return isMirror(root,root);	

	}
	
	public boolean isMirror(Node root1, Node root2) {
		
		if(root1 == null && root2 == null)
			return true;
		
		if(root1 != null && root2!= null && root1.data == root2.data)
			return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
		
		return false;
	}




	public static void main(String[] args) {

		BTREE btree = new BTREE();

/*		btree.add(1);
		btree.add(2);
		btree.add(2);
		btree.add(3);
		btree.add(4);
		btree.add(4);
		btree.add(3);
		*/
		
		btree.root = new Node(1);
		btree.root = new Node(1);
		btree.root = new Node(1);
		btree.root = new Node(1);
		btree.root = new Node(1);
		
		
		IsSymmetricNode isIt = new IsSymmetricNode();

		System.out.println(isIt.isSymmetric(btree.root));

	}

}

