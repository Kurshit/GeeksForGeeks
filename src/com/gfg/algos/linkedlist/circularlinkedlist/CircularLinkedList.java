package com.gfg.algos.linkedlist.circularlinkedlist;

import com.gfg.algos.linkedlist.singlell.LinkedList.SLNode;

public class CircularLinkedList {
	
	
	public SLNode head;
	
	/*
	 * Adds to last of linked list
	 */
	
	public void add(int data) {
		
		SLNode newNode = new SLNode(data);
		
		if(head == null) {
			newNode.next = newNode;
			head = newNode;
			return;			
		}
		
		SLNode ptr = head;
		
		while(ptr.next != head) 
			ptr = ptr.next;
		
		ptr.next = newNode;
		newNode.next = head;		
	}
	
	public void addFirst(int data) {
		
		SLNode newNode = new SLNode(data);
		
		if(head == null) {
			head = newNode;
			newNode.next = newNode;
			return;
		}
		
		SLNode ptr = head;
		
		newNode.next = head;
		
		while(ptr.next != head) {
			ptr = ptr.next;
		}
		
		ptr.next = newNode;
		
		head = newNode;	
	}
	
	public void delete(int data) {
		
		if(head == null)
			return;
		
		// if node to be deleted is first node
		
		SLNode ptr = head;
		if(head.data == data) {
			
			if(head.next == head) {
				head = null;
				return;
			}
			
			while(ptr.next != head)
				ptr = ptr.next;
			
			ptr.next = head.next;
			
			head = head.next;			
		}
		
		// if node deleted is in-between node
			
		SLNode prev = null;
		
		while(ptr.next != head) {
			
			if(ptr.data == data) {
				prev.next = ptr.next;
				return;
			}
			
			prev = ptr;
			ptr = ptr.next;
		}
		
		if(ptr.data == data)
			prev.next = ptr.next;
		
		
	}
	
	public int size() {
		
		if(head == null)
			return 0;
		
		SLNode ptr = head;
		int count = 0;
		do {
			ptr = ptr.next;
			count++;
		} while(ptr != head);
		
		return count;
		
	}
	
	public void print() {
		
		if(head == null)
			return;
		
		SLNode ptr = head;
		
		do {
			System.out.print(ptr.data + " ");
			ptr = ptr.next;
		}while(ptr != head); 
		
		System.out.println();
	}
	
	public void createRandomSampleList1() {
		
		add(50);
		add(70);
		add(90);
		add(30);
		add(20);
		add(100);
		add(10);
		add(60);
		add(40);
		add(80);
		
	}
	
	public void clear() {
		head = null;
	}

}
