package com.gfg.algos.linkedlist.singlell.revise;

import com.gfg.algos.linkedlist.singlell.LinkedList;
import com.gfg.algos.linkedlist.singlell.LinkedList.SLNode;

public class IntersectionOfSortedList {
	
	public static SLNode intersectSortedList(SLNode head1, SLNode head2) {
		
		if(head1 == null)
			return head2;
		
		if(head2 == null)
			return head1;
		
		SLNode dummyNode = new SLNode(0);
		SLNode ptr = dummyNode;
		
		while(head1 != null || head2 != null) {		
			
			if(head1 == null)
				break;
			
			if(head2 == null)
				break;
			
			if(head1.data > head2.data) {
				head2 = head2.next;
			} else if(head1.data < head2.data) {
				head1 = head1.next;
			} else {
				ptr.next = head1;
				ptr = ptr.next;
				head1 = head1.next;
				head2 = head2.next;
			}		
			
		}
		
		ptr.next = null;
		return dummyNode.next;
		
	}
	
	public static void main(String[] args) {
		
		LinkedList list1 = new LinkedList();
		list1.createIntersectionList2();
		
		LinkedList list2 = new LinkedList();
		list2.createIntersectionList1();
		
		SLNode result = intersectSortedList(list1.head, list2.head);
		
		list1.printGivenList(result);

	}

}
