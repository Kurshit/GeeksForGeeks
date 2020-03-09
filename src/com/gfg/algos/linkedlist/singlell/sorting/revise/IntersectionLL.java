package com.gfg.algos.linkedlist.singlell.sorting.revise;

import com.gfg.algos.linkedlist.singlell.LinkedList;
import com.gfg.algos.linkedlist.singlell.LinkedList.SLNode;

public class IntersectionLL {
	
	
	public SLNode intersect(SLNode h1, SLNode h2) {
		
		
		if(h1 == null || h2 == null) {
			return null;
		}
		
		SLNode dummy = new SLNode(-1);
		
		SLNode curr = dummy;
		
		while(h1 != null && h2 != null) {
			
			/*if(h1 == null) {
				break;
			}
			
			if(h2 == null) {
				break;
			}*/
			
			if(h1.data < h2.data) {
				h1 = h1.next;
			} else if( h1.data > h2.data) {
				h2 = h2.next;
			} else {
				curr.next = h1;
				h1 = h1.next;
				h2 = h2.next;
				curr = curr.next;
			}
			
		}
		
		curr.next = null;
		return dummy.next;
		
	}
	
	public static void main(String[] args) {
		
		IntersectionLL intersect = new IntersectionLL();
		
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		
		list1.createIntersectionList1();
		list2.createIntersectionList2();
		
		
		SLNode res = intersect.intersect(list1.head, list2.head);
		
		list1.printGivenList(res);
		

	}

}
