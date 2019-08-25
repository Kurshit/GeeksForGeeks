package com.gfg.algos.trees.bst.basicops;

import com.gfg.algos.trees.bst.BST;
import com.gfg.algos.trees.bst.BST.Node;

public class BFSLevelOrderTraversal {

	private static BST bst = new BST();
	
	private static HeightOfATree hot = new HeightOfATree();
	
	private static NodesAtLevelL nodesAtL = new NodesAtLevelL();
	
	public static void main(String[] args) {
		
		bst.createSampleTree();
		
		BFSLevelOrderTraversal underTest = new BFSLevelOrderTraversal();
		underTest.bfsTraversal(bst.root);
		

	}
	
	public void bfsTraversal(Node newRoot) {
		
		int height = hot.findHeightOfATree(bst.root);
		
		for(int i = 1; i <= height; i++) {
			nodesAtL.printNodeAtL(bst.root,i);
		}
		
	}

}
