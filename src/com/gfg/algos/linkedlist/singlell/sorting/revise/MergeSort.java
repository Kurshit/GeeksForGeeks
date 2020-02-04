package com.gfg.algos.linkedlist.singlell.sorting.revise;

import com.gfg.algos.linkedlist.singlell.LinkedList;
import com.gfg.algos.linkedlist.singlell.LinkedList.SLNode;

public class MergeSort {

	public SLNode merge(SLNode head) {

		if(head == null || head.next == null)
			return head;

		SLNode middle = getMiddle(head);

		SLNode nextOfMiddle = middle.next;

		middle.next = null;
		
		SLNode left = merge(head);
		SLNode right = merge(nextOfMiddle);

		SLNode result = mergeTwo(left, right);
		
		return result;


				
	}

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

	public SLNode getMiddle(SLNode head) {

		if(head == null)
			return null;

		SLNode ptr = head;

		SLNode fptr = head;

		while(fptr.next != null && fptr.next.next != null) {
			fptr = fptr.next.next;
			ptr = ptr.next;
		}

		return ptr;
	}

	public static void main(String[] args) {

		LinkedList list = new LinkedList();

		list.createSevenNodeSLL();

		MergeSort sort = new MergeSort();

		SLNode node = sort.merge(list.head);
		
		list.printGivenList(node);

	}

}
