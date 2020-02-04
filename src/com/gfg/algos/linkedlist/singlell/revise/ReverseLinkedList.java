package com.gfg.algos.linkedlist.singlell.revise;

import com.gfg.algos.linkedlist.singlell.LinkedList;
import com.gfg.algos.linkedlist.singlell.LinkedList.SLNode;

public class ReverseLinkedList {

	public static SLNode reverseIt(SLNode head) {
		
		if(head == null)
			return null;
		
		SLNode curr = head;
		SLNode prev = null;
		SLNode next = null;
		
		while(curr != null) {
			
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			
		}
		
		head = prev;
		
		return head;
	}
	
	
	public static void main(String[] args) {
			
		LinkedList list = new LinkedList();
		
		list.createSampleSLL1();
		
		list.printGivenList(list.head);
		
		SLNode result = reverseIt(list.head);
		
		list.printGivenList(result);

	}

}
