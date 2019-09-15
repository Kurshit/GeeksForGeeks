package com.gfg.algos.linkedlist.singlell.sorting;

import com.gfg.algos.linkedlist.singlell.LinkedList;
import com.gfg.algos.linkedlist.singlell.LinkedList.SLNode;

public class IntersectionOfSorted {

	public SLNode intersect(SLNode head1, SLNode head2) {

		if(head1 == null || head2 == null)
			return null;

		SLNode dummy = new SLNode(-1);

		SLNode ptr = dummy;

		while(head1 != null && head2 != null) {


			if(head1.data == head2.data) {
				ptr.next = new SLNode(head1.data);

				head1 = head1.next;
				head2 = head2.next;
				ptr = ptr.next;
			} else if(head1.data < head2.data) {
				head1 = head1.next;
			} else {
				head2 = head2.next;
			}
		}


		return dummy.next;


	}
	
	
	
	public SLNode intersectRecursively(SLNode h1, SLNode h2) {
		
		if(h1 == null || h2 == null)
			return null;
		
		if(h1.data < h2.data)
			return intersectRecursively(h1.next, h2);
		
		if(h1.data > h2.data)
			return intersectRecursively(h1, h2.next);
		
		SLNode temp = new SLNode(h1.data);
		
		temp.next = intersectRecursively(h1.next, h2.next);
		
		return temp;		
		
	}

	public static void main(String[] args) {

		LinkedList list = new LinkedList();

		list.createIntersectionList1();

		LinkedList list2 = new LinkedList();

		list2.createIntersectionList2();
		
		IntersectionOfSorted intersect = new IntersectionOfSorted();
		
		SLNode result = intersect.intersect(list.head, list2.head);
		
		list.printGivenList(result);
		
		SLNode result2 = intersect.intersectRecursively(list.head, list2.head);
		
		System.out.println("Recursively : ");
		
		list.printGivenList(result2);

	}

}
