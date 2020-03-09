package com.gfg.algos.linkedlist.singlell.revise;

import com.gfg.algos.linkedlist.singlell.LinkedList;
import com.gfg.algos.linkedlist.singlell.LinkedList.SLNode;

public class AddTwoLists {
	
	SLNode res;
	SLNode curr;
	int carry;
	
	public SLNode addTwo(SLNode head1, SLNode head2) {
		
		if(head1 == null)
			return head2;
		
		if(head2 == null)
			return head1;
		
		int h1Size = getSize(head1);
		int h2Size = getSize(head2);
		
		
		if(h1Size == h2Size) {
			addSameSize(head1, head1);
		} else {
			
			if(h1Size < h2Size) {
				SLNode temp = head1;
				head1 = head2;
				head2 = temp;
			}
			
			SLNode temp = head1;
			int diff = Math.abs(h1Size - h2Size);
			
		}	
		
		if(carry > 0) {
			addFirst(carry);
		}
		
		return res;
		
		
		
	}
	
	public void addSameSize(SLNode h1, SLNode h2) {
		
		if(h1 == null)
			return;
		
		addSameSize(h1.next, h2.next);
		
		int sum = carry + h1.data + h2.data;
		
		carry = sum / 10;
		sum = sum % 10;
		
		addFirst(sum);
		
	}
	
	public void addFirst(int data) {
		SLNode newNode = new SLNode(data);
		
		if(res == null) {
			res = newNode;
			return;
		}
		
		newNode.next = res;
		res = newNode;	
		
	}
	
	public int getSize(SLNode head) {
		
		if(head == null)
			return 0;
		
		return 1 + getSize(head.next);
		
	}
	
	
	public static void main(String[] args) {
		
		LinkedList list1 = new LinkedList();
		
		list1.createIntegerToAddSLL1();
		
		LinkedList list2 = new LinkedList();
		
		list2.createIntegerToAddSLL1();
		
		AddTwoLists addThem = new AddTwoLists();
		
		SLNode result = addThem.addTwo(list1.head, list2.head);
		list1.printGivenList(result);
		
				
		

	}

}
