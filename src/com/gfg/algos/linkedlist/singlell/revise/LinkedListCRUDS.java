package com.gfg.algos.linkedlist.singlell.revise;

import com.gfg.algos.linkedlist.singlell.LinkedList.SLNode;

public class LinkedListCRUDS {
	
	SLNode head;
	
	public void addLast(int data) {
		SLNode newNode = new SLNode(data);
		
		if(head == null) {
			head = newNode;
			return;
		}
		
		SLNode ptr = head;
		
		while(ptr.next != null) { 
			ptr = ptr.next;
		}
		
		ptr.next = newNode;
	}
	
	public void addFirst(int data) {
		SLNode newNode = new SLNode(data);
		
		if(head == null) {
			head = newNode;
			return;
		}
		
		newNode.next = head;
		head = newNode;			
	}
	
	public void addAfterNth(int data,int N) {
		
		SLNode newNode = new SLNode(data);
		
		if(head == null) {
			return;
		}
		
		SLNode ptr = head;
		int count = 1;
		while(ptr != null && count <= N) {
			
			if(count == N) {
				newNode.next = ptr.next;
				ptr.next = newNode;
				return;
			}
			
			ptr = ptr.next;
			count++;
		}
		
		if(count != N) {
			throw new IllegalArgumentException("N greater than list");
		}
	}
	
	public void addBeforeNth(int data, int N) {
		
		SLNode newNode = new SLNode(data);
		SLNode prev = null;
		SLNode ptr = head;
		int count = 1;
		
		if(N == 1) {
			addFirst(data);
			return;
		}
		
		while(ptr != null && count <= N) {
			
			if(count == N) {
				newNode.next = ptr;
				prev.next = newNode;
				return;
			}
			
			
			count++;
			prev = ptr;
			ptr = ptr.next;
		}
		
		if(count != N ) {
			throw new IllegalArgumentException("N is greater than List");
		}
		
	}
	
	public void deleteLast() {
		if(head == null)
			return;
		
		if(head.next == null) {
			head = null;
			return;
		}
		
		SLNode ptr = head;
		SLNode prev = null;
		while(ptr.next != null) {
			
			prev = ptr;
			ptr = ptr.next;
		}
		
		prev.next = null;
			
	}
	
	public void deleteFirst() {
		if(head == null)
			return;
		
		head = head.next;
	}
	
	public void printSL() {
		
		if(head == null)
			return;
		
		SLNode ptr = head;
		
		while(ptr != null) {
			System.out.print(ptr.data + " ");
			ptr = ptr.next;
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		
			LinkedListCRUDS ll = new LinkedListCRUDS();
			
			ll.addLast(30);
			ll.addLast(50);
			ll.addLast(60);
			ll.addLast(70);
			
			ll.printSL();
			
			ll.addFirst(10);
			
			
			ll.printSL();
			
			ll.addAfterNth(55, 3);
			ll.printSL();
			
			ll.addAfterNth(75, 6);
			ll.printSL();
			
			ll.addAfterNth(72, 6);
			ll.printSL();
			
			ll.addAfterNth(5, 1);
			ll.printSL();
			
			ll.addBeforeNth(40, 4);
			ll.printSL();
			
			ll.addBeforeNth(4, 1);
			ll.printSL();
			
			ll.deleteLast();
			ll.printSL();
			
			ll.deleteFirst();
			ll.printSL();
	}
	
	
}
