package com.gfg.algos.trees.bst.basicops;

import com.gfg.algos.trees.bst.BST;
import com.gfg.algos.trees.bst.BST.Node;

public class NodesAtLevelL {
	
	static BST bst = new BST();
	
	public static void main(String[] args) {
		
		NodesAtLevelL underTest = new NodesAtLevelL();
		
		bst.createSampleTree();
		
		underTest.printNodeAtL(bst.root, 4);
		
		
	}
	
	public void printNodeAtL(Node newRoot, int level) {
		
		if(newRoot == null)
			return;
		
		if(level == 1) {
			System.out.print(newRoot.getData() + " ");
			return;
		}
		else {	
		printNodeAtL(newRoot.left, level-1);
		printNodeAtL(newRoot.right, level-1);
		}
	}
	
	
	
	
	

}
