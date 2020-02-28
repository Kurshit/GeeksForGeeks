package com.gfg.algos.linkedlist.singlell.sorting.revise;

import com.gfg.algos.linkedlist.singlell.LinkedList;
import com.gfg.algos.linkedlist.singlell.LinkedList.SLNode;

public class MergeTwoLists {
	
	public SLNode mergeTwo(SLNode h1, SLNode h2) {
		
		if(h1 == null)
			return h2;
		
		if(h2 == null)
			return h1;
		
		SLNode dummy = new SLNode(-1);
		SLNode ptr = dummy;
		
		while(true) {
			
			if(h1 == null) {
				ptr.next = h2;
				break;
			}
			
			if(h2 == null) {
				ptr.next = h1;
				break;
			}
			
			if(h1.data <= h2.data) {
				ptr.next = h1;
				h1 = h1.next;
			} else {
				ptr.next = h2;
				h2 = h2.next;
			}
			
			ptr = ptr.next;
			
		}
		
		return dummy.next;
	}
	

	public static void main(String[] args) {
		
		LinkedList list1 = new LinkedList();
		
		list1.createSorted1();
		
		LinkedList list2 = new LinkedList();
		
		list2.createSorted2();
		
		MergeTwoLists merge = new MergeTwoLists();
		
		SLNode result =  merge.mergeTwo(list1.head, list2.head);
		
		list1.printGivenList(result);
		
		
		list1.clear();
		list2.clear();
		
			
		list1.createSorted5();
		
		/*
		 *   1 --> 2 --> 4
		 */	
		
		list2.createSorted6();
		
		/*
		 *   1 --> 3 --> 4
		 */
		
		System.out.println();
		result =  merge.mergeTwo(list1.head, list2.head);
		
		list1.printGivenList(result);

	}

}
