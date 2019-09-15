package com.gfg.algos.trees.binarytree.checkingandprinting.path;

import java.util.ArrayList;
import java.util.List;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

public class PathFromRootToGivenNode {

	public void pathFromRootToX(Node root, int x) {

		List<Integer> arr = new ArrayList<>(); 
		

		if(hasPath(root,x, arr)) {
			for(int i=0; i<arr.size(); i++) {
				System.out.print(arr.get(i) + " ");
			}
			System.out.println();
		}
	}

	public boolean hasPath(Node root, int x, List<Integer> arr) {

		if(root == null)
			return false;

		arr.add(root.data);

		if(root.data == x)
			return true;

		if( hasPath(root.left, x, arr) || hasPath(root.right, x, arr)) {
			return true;
		}

		arr.remove(arr.size() - 1); // this is necessary

		return false;

	}
	


	public void pathFromRootToXUsingArr(Node root, int x) {

		int[] arr = new int[100];

		if(hasPathUsingArray(root,x, arr, 0)) {
			System.out.println("Path Exist");
		} else {
			System.out.println("No path");
		}
	}


	public boolean hasPathUsingArray(Node root, int x, int[] arr, int pl) {

		if(root == null)
			return false;

		arr[pl] = root.data;
		pl++;

		if(root.data == x) {
			for(int i=0; i<pl; i++) {
				System.out.print(arr[i] + " ");
			}
			return true;
		}

		return  hasPathUsingArray(root.left, x, arr,pl) || hasPathUsingArray(root.right, x, arr,pl) ;
	

	}
	public static void main(String[] args) {

		BTREE btree = new BTREE();
		btree.createSampleBinaryTree1();

		PathFromRootToGivenNode pathToX= new PathFromRootToGivenNode();

		pathToX.pathFromRootToX(btree.root, 7);
		pathToX.pathFromRootToXUsingArr(btree.root, 7);
		
		pathToX.pathFromRootToX(btree.root, 70);
		pathToX.pathFromRootToXUsingArr(btree.root, 70);
		
		pathToX.pathFromRootToX(btree.root, 30);
		pathToX.pathFromRootToXUsingArr(btree.root, 30);
		
		pathToX.pathFromRootToX(btree.root, 10);
		pathToX.pathFromRootToXUsingArr(btree.root, 10);
		
		System.out.println();
		
		pathToX.pathFromRootToX(btree.root, 105);
		pathToX.pathFromRootToXUsingArr(btree.root, 105);

	}

}
