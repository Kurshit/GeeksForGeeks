package com.gfg.algos.trees.binarytree.checkingandprinting.path;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

/*
 *  This code aint working
 */

public class LongestLeafToLeafPath {
	
	public int height(Node root)
	{
		if(root == null)
			return 0;
		
		int lh = 1 +height(root.left);
		int rh = 1 + height(root.right);
		
		return Math.max(lh, rh);
		
	}
	
	public void longestLeafToLeafPAth(Node root) {
		
		if(root == null)
			return;
		
		int ans = Integer.MIN_VALUE;
		int lh =0, rh =0;
		int index = 0;
		
		int heightOfTree = height(root);
		lh = height(root.left);
		int[] path = new int[1000];
		int pathLength = 0;
		
		printPathRecusrively(root.left, path, pathLength, lh, index );
		
	}
	
	public void printPathRecusrively(Node root, int[] path, int pathLength, int max, int index ) {
		
		
		if(root == null)
			return;
		
		path[pathLength] = root.data;
		pathLength++;
		
		if(root.left == null && root.right == null) {
			
			if(pathLength == max && (index == 0 || index == 1)) {
				printArray(path,pathLength, index);
				index = 2;
			}
		} 
		else {
			printPathRecusrively(root.left, path, pathLength, max, index);
			printPathRecusrively(root.right, path, pathLength, max, index);
		}
		
	}
	
	public void printArray(int[] arr, int pathLegth, int index) {
		
		int i;
		
		if(index == 0) {
			for(i = pathLegth - 1; i >=0; i--) {
				System.out.print(arr[i] + " ");
			}
		} 
		else if(index == 1) {
			for(i = 0; i < pathLegth; i++) {
				System.out.print(arr[i] + " ");
			}
		}
		
	}

	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.createSampleBinaryTree1();
		
		LongestLeafToLeafPath path = new LongestLeafToLeafPath();
		
		System.out.println(path.height(btree.root));
		
		path.longestLeafToLeafPAth(btree.root);

	}

}
