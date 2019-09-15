package com.gfg.algos.linkedlist.singlell.top30;

import com.gfg.algos.linkedlist.singlell.LinkedList;
import com.gfg.algos.linkedlist.singlell.LinkedList.SLNode;

public class LoopInSLLLocal {

	public boolean hasLoop(SLNode head) {

		if(head == null)
			return false;

		SLNode fptr = head;
		SLNode sptr = head;

		while(fptr != null && fptr.next != null) {

			fptr = fptr.next.next;
			sptr = sptr.next;

			if(fptr == sptr)
				return true;

		}

		return false;	

	}

	public SLNode loopedNode(SLNode head) {

		if(head == null)
			return null;

		SLNode fptr = head;
		SLNode sptr = head;

		while(fptr != null && fptr.next != null) {

			fptr = fptr.next.next;
			sptr = sptr.next;

			if(fptr == sptr)
				return fptr;

		}

		return null;

	}

	public static void main(String[] args) {

		LinkedList ll = new LinkedList();

		ll.createSampleSLL1();

		LoopInSLLLocal loop = new LoopInSLLLocal();

		System.out.println(loop.hasLoop(ll.head));

		ll.clear();

		ll.createFiveLoopSLL();

		System.out.println(loop.hasLoop(ll.head));

		System.out.println(loop.loopedNode(ll.head).data);

	}

}
