package com.gfg.algos.linkedlist.singlell;

import com.gfg.algos.linkedlist.singlell.LinkedList.SLNode;

/**
 * Definition for singly-linked list.
 * public class SLNode {
 *     int val;
 *     SLNode next;
 *     SLNode(int x) { val = x; }
 * }
 */


/*class SLNode {
	int val;
	SLNode next;
	SLNode(int x) { val = x; }
}*/

public class Solution {

	public void addLast(int sum) {

		SLNode ptr = result;

		if(ptr == null) {
			result = new SLNode(sum);
			return;
		}

		while(ptr.next != null) {
			ptr = ptr.next;
		}

		ptr.next = new SLNode(sum);



	}
	
	SLNode result = null;


	public SLNode addTwoNumbers(SLNode l1, SLNode l2) {

		if(l1 == null) {
			return l2;
		}    

		if(l2 == null) {
			return l1;
		}

		
		int sum = 0;
		int carry = 0;

		while(l1 != null || l2 != null) {

			int first = l1 != null ? l1.data : 0;
			int second = l2 != null ? l2.data : 0;

			sum = first + second + carry;

			if(sum >= 10)
				carry = 1;
			else 
				carry = 0;

			sum = sum % 10;

			addLast(sum);

			if(l1 != null)
				l1 = l1.next;

			if(l2 != null)
				l2 = l2.next;

		}

		if(carry > 0)
			addLast(1);

		return result;

	}
}