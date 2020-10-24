package com.gfg.algos.linkedlist.singlell.revise;

import com.gfg.algos.linkedlist.singlell.LinkedList;
import com.gfg.algos.linkedlist.singlell.LinkedList.SLNode;

public class MiddleElement {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.createSampleSLL1();
		
		//10->20->30->40->50->60->70->80->90->100
		
		System.out.println(middleSLNode(ll.head).data);
		
	}

	public static SLNode middleSLNode(SLNode head) {
		if (head == null)
			return null;

		SLNode fptr = head;
		SLNode sptr = head;

		while (fptr.next != null && fptr.next.next != null) {
			fptr = fptr.next.next;
			sptr = sptr.next;
		}
		return sptr;
	}

}
