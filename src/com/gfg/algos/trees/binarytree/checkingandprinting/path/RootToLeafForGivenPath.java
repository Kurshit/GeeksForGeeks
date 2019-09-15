package com.gfg.algos.trees.binarytree.checkingandprinting.path;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

/*
 * This prog shows it given sequence of path exists from root to leaf.
 * The path must end at leaf node from root node. In between path will node be considered.
 *  Given path is given in an array O(n)
 */

public class RootToLeafForGivenPath {
	
	public boolean pathExists(Node root, int[] arr) {
		return pathExists(root,arr,0);
	}
	
	public boolean pathExists(Node root, int[] arr, int index) {
		
		if(root == null) 
			return false;
		
		if(root.left == null && root.right == null && index < arr.length && root.data == arr[index] && root.data == arr[arr.length - 1])
			return true;
		boolean result = true; 
		if(index >= arr.length || root.data != arr[index]) {
			result = false;;
		}
		
		return result && (pathExists(root.left, arr, index +1) || pathExists(root.right, arr, index + 1));		
		
	}

	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		btree.createSampleBinaryTree1();
				
		RootToLeafForGivenPath path = new RootToLeafForGivenPath();
		
		
		System.out.println("{10,5,9,70} : " + path.pathExists(btree.root, new int[]{10,5,9,70}));
		System.out.println("{10,5,9,80} : " + path.pathExists(btree.root, new int[]{10,5,9,80}));
		System.out.println("{10,5,7,50} : " + path.pathExists(btree.root, new int[]{10,5,7,50}));
		System.out.println("{10,20,30} : " + path.pathExists(btree.root, new int[]{10,20,30}));
		System.out.println("{10,20,40} : " + path.pathExists(btree.root, new int[]{10,20,40}));
		
		System.out.println();
		System.out.println("{10,5,9,8,70} : " + path.pathExists(btree.root, new int[]{10,5,9,8,70}));
		System.out.println("{10,5,9,8,70} : " + path.pathExists(btree.root, new int[]{10,5,9,8,15,20,70}));
		System.out.println("{10,5,9,60} : " + path.pathExists(btree.root, new int[]{10,5,9,60}));
		System.out.println("{10,5,9} : " + path.pathExists(btree.root, new int[]{10,5,9}));
		System.out.println("{10,5,9,50} : " + path.pathExists(btree.root, new int[]{10,5,9,50}));
		System.out.println("{10,5,9,50} : " + path.pathExists(btree.root, new int[]{10,5,9,50}));

	}

}
