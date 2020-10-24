package com.gfg.algos.linkedlist.singlell.revise;

import com.gfg.algos.linkedlist.singlell.LinkedList;
import com.gfg.algos.linkedlist.singlell.LinkedList.SLNode;

public class NthFromLast {

	public static void main(String[] args) {

		LinkedList ll = new LinkedList();

		ll.createFifteenNodeSLL();
		System.out.println(nthNodeFromLast(ll.head, 13).data);

	}

	public static SLNode nthNodeFromLast(SLNode head, int N) {

		if (head == null)
			return null;

		SLNode fptr = head;
		int count = 0;
		SLNode sptr = null;

		while (fptr != null && count != N) {
			fptr = fptr.next;
			count++;
		}

		if (fptr == null)
			return null;

		sptr = head;

		while (fptr != null) {
			fptr = fptr.next;
			sptr = sptr.next;
		}

		return sptr;

	}

}
