package com.gfg.algos.linkedlist.singlell.top30;

import com.gfg.algos.linkedlist.singlell.LinkedList;
import com.gfg.algos.linkedlist.singlell.LinkedList.SLNode;


public class MiddleOfLinkedList {

	public SLNode middleOfSLL(SLNode head) {

		SLNode slowPtr = head;
		SLNode fastPtr = head;

		if(slowPtr == null)
			return null;

		if(slowPtr.next == null)
			return slowPtr;

		while(fastPtr.next != null && fastPtr.next.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
		}

		return slowPtr;
	}

	public static void main(String[] args) {

		LinkedList ll = new LinkedList();

		ll.createSampleSLL1();

		MiddleOfLinkedList mid = new MiddleOfLinkedList();

		SLNode result = mid.middleOfSLL(ll.head);
		if(result != null)
			System.out.println(result.data);

		ll.clear();

		ll.createOneNodeSLL();

		result = mid.middleOfSLL(ll.head);

		if(result != null)
			System.out.println(result.data);

		ll.clear();
		
		ll.createTwoNodeSLL();

		result = mid.middleOfSLL(ll.head);

		if(result != null)
			System.out.println(result.data);

		ll.clear();
		
		ll.createSevenNodeSLL();

		result = mid.middleOfSLL(ll.head);

		if(result != null)
			System.out.println(result.data);


	}

}
