package com.gfg.algos.linkedlist.singlell.sorting;

import com.gfg.algos.linkedlist.singlell.LinkedList;
import com.gfg.algos.linkedlist.singlell.LinkedList.SLNode;

public class MergeTwoSortedLists {
	
	public SLNode mergeTwoLists(SLNode head1, SLNode head2) {
		
		if(head1 == null)
			return head2;
		
		if(head2 == null)
			return head2;
		
		SLNode dummy = new SLNode(-1);
		SLNode ptr = dummy;
		
		while(head1 != null || head2 != null) {
			
			if(head1 == null) {
				ptr.next = head2;
				break;
			}
			
			if(head2 == null) {
				ptr.next = head1;
				break;
			}
			
			if(head1.data > head2.data) {
				ptr.next = head2;
				head2 = head2.next;
				
			} 
			else {
				ptr.next = head1;
				head1 = head1.next;
				
			}			
			
			ptr = ptr.next;
		}
		
		
		return dummy.next;
	}

	public static void main(String[] args) {
		
		LinkedList list1 = new LinkedList();
		
		list1.createSortedList1();
		
		LinkedList list2 = new LinkedList();
		
		list2.createSortedList2();
		
		MergeTwoSortedLists merge = new MergeTwoSortedLists();
		
		SLNode result = merge.mergeTwoLists(list1.head, list2.head);
		
		list1.printGivenList(result);
		
	}

}
