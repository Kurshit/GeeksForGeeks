package com.gfg.algos.trees.bst.basicops;

import com.gfg.algos.trees.bst.BST;
import com.gfg.algos.trees.bst.BST.Node;

public class HeightOfATree {

	static BST bst = new BST();
	
	public static void main(String[] args) {
		bst.createSampleTree();
		
		HeightOfATree underTest = new HeightOfATree();
		System.out.println("Height is : " +underTest.findHeightOfATree(bst.root));

	}
	
	public int findHeightOfATree(Node newRoot) {
		
		if(newRoot == null) {
			return 0;
		}
		
		int lheight = findHeightOfATree(newRoot.left) +1;
		
		int rheight = findHeightOfATree(newRoot.right) + 1;
		
		
		if (lheight > rheight) 
            return lheight; 
        else 
        	return rheight;
		
	}

}
