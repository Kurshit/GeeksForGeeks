package com.gfg.algos.trees.binarytree.revised;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

public class IsSumTree {
	
	public boolean isSumTree(Node root) {
		
		if(root == null)
			return true;

		if(root.left == null && root.right == null)
			return true;
				
		int leftSum = 0;
		int rightSum = 0;
		
		if(root.left != null)
			leftSum = root.left.data;
		
		if(root.right != null)
			rightSum = root.right.data;
		
		return root.data == leftSum + rightSum && isSumTree(root.left) && isSumTree(root.right);
	}

	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.createSampleBinaryTree1();
		
		IsSumTree sum = new IsSumTree();
		
		System.out.println(sum.isSumTree(btree.root));
		
		btree.clear();
		
		btree.createSumTree();
		
		System.out.println(sum.isSumTree(btree.root));

	}

}
