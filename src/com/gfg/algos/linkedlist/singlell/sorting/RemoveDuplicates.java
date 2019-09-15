package com.gfg.algos.linkedlist.singlell.sorting;

import com.gfg.algos.linkedlist.singlell.LinkedList;
import com.gfg.algos.linkedlist.singlell.LinkedList.SLNode;

public class RemoveDuplicates {

	/*
	 * Removes duplicates from sorted Linked List
	 */

	public SLNode removeDuplicates(SLNode head) {
		
		SLNode curr = head;
		
		while(curr != null) {
			
			SLNode temp = curr;
			
			while(temp != null && temp.data == curr.data) {
				temp = temp.next;
			}
			
			curr.next = temp;
			curr = curr.next;
			
		}
		
		return head;
	}

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.createSortedDuplicateNodesList();
		
		System.out.println("Before removal : "); 
		list.printGivenList(list.head);
		
		RemoveDuplicates remove = new RemoveDuplicates();
		
		SLNode node = remove.removeDuplicates(list.head);
		System.out.println("After removal of duplicates : ");
		list.printGivenList(node);
		
		
		
		

	}

}
