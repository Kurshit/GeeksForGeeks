package com.gfg.algos.trees.binarytree.revised;

import java.util.ArrayList;
import java.util.List;

import com.gfg.algos.trees.binarytree.BTREE;
import com.gfg.algos.trees.bst.BST.Node;

public class SumPrePostIn {
	
	public void sumPrePostIn(Node root) {
		
		List<Integer> list = new ArrayList<>();
		
		list.add(0);
		
		getInorderElements(root,list);
		
		list.add(0);
		
		System.out.println(list);
		Index index = new Index();
		index.i = 1;
		replaceSum(root,list,index);
	}
	
	
	
	public void replaceSum(Node root, List<Integer> list, Index index) {
		
		if(root == null)
			return;
		
		replaceSum(root.left, list, index);
		root.data = list.get(index.i - 1) + list.get(index.i + 1);
		index.i = index.i + 1;
		replaceSum(root.right, list, index);
	}
	
	
	public void getInorderElements(Node root, List<Integer> list) {
		
		if(root == null)
			return;
		
		getInorderElements(root.left, list);
		list.add(root.data);
		getInorderElements(root.right, list);
	}
	
	public static void main(String[] args) {
		
		BTREE btree = new BTREE();
		
		btree.createSampleBinaryTree1();
		
		/*
		 * 								10
		 * 							/	     \
		 * 						  5			   20
		 * 					   /     \      /      \
		 *                   9       7    30       40
		 * 				  /    \    / \
		 * 				 70    80  50  60
		 */
		
		SumPrePostIn sum = new SumPrePostIn();
		
		sum.sumPrePostIn(btree.root);
		btree.inorderNode(btree.root);
		
		/*
		 * Expected output
		 * 								90
		 * 							/	     \
		 * 						  130   	   70
		 * 					   /     \      /      \
		 *                   150    110    30       20
		 * 				  /    \    / \
		 * 				 9     14  12  17
		 */

		
		
	}

}

class Index {
	int i;
}