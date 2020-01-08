package com.gfg.algos.linkedlist.singlell.revise;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * THis class is just for the revision
 */

public class SinglyLL {

	public SNode head;

	public static class SNode {
		SNode next;
		int data;

		public SNode(int data) {
			this.data = data;
		}
	}

	public void addFirst(int data) {
		SNode newNode = new SNode(data);

		if(head == null) {
			head = newNode;
			return;
		}

		newNode.next = head;
		head = newNode;
	}

	public void addFirstNode(SNode head, int data) {

		SNode newNode = new SNode(data);

		if(head == null) {
			head = newNode;
			return;
		}

		newNode = head;
		head = newNode;	

	}

	public void addLast(int data) {
		SNode newNode = new SNode(data);

		if(head == null) {
			head = newNode;
			return;
		}

		SNode ptr = head;

		while(ptr.next != null) {
			ptr = ptr.next;
		}

		ptr.next = newNode;
	}

	public void addLastNode(SNode head, int data) {

		SNode newNode = new SNode(data);

		if(head == null) {
			head = newNode;
			return;
		}

		SNode ptr = head;

		while(ptr.next != null) {
			ptr = ptr.next;
		}

		ptr.next = newNode;

	}

	public void printSLL() {
		printSLLNode(this.head);
		System.out.println();
	}

	public void printSLLNode(SNode head) {

		if(head == null) {
			return;
		}


		SNode ptr = head;

		while(ptr != null) {
			System.out.print(ptr.data + " ");
			ptr = ptr.next;
		}
	}

	public void addAtGivenPosition(int pos, int data) {

		if(this.head == null) {
			if(pos == 1) {
				this.head = new SNode(data);
				return;
			} else {
				System.out.println("Invalid pos");
				return;
			}
		}

		int count = 0;

		SNode ptr = this.head;

		SNode newNode = new SNode(data);

		while(ptr.next != null) {

			if(count+1 == pos) {

				newNode.next = ptr.next;
				ptr.next = newNode;
				return;
			}

			ptr = ptr.next;
			count++;
		}

		if(count + 1 == pos) {
			ptr.next = newNode;
			return;
		}

		System.out.println("Invalid position");
	}

	public int size() {

		SNode ptr = this.head;
		AtomicInteger result = new AtomicInteger(0);
		while(ptr != null) {
			result.addAndGet(1);
			ptr = ptr.next;
		}

		return result.intValue();
	}

	public void deleteLast() {

		if(head == null)
			return;

		SNode ptr = head;
		SNode prev = null;

		while(ptr.next != null) {

			prev = ptr;
			ptr = ptr.next;
		}

		if(prev != null) {
			prev.next = null;
		}
		else {
			head = null;
		}
	}

	public void deleteFirst() {

		if(this.head == null) {
			return;
		}

		if(head.next == null) {
			head = null;
			return;
		}

		head = head.next;
	}


	public void deleteGivenNo(int data) {
		
		SNode ptr = head;
		SNode prev  = null;
		
		if(ptr!= null && ptr.data == data ) {
			head = ptr.next;
			return;
		}
		
		while(ptr != null && ptr.data != data) {
			prev = ptr;
			ptr = ptr.next;
		}
		
		if(ptr == null) 
			return;
		
		prev.next = ptr.next;
	}
	
	public int sizeRecursively() {
		
		return sizeRecursively(this.head); 
		
	}
	
	public int sizeRecursively(SNode newHead) {
		
		if(newHead == null) 
			return 0;
		
		return 1 + sizeRecursively(newHead.next);
		
		
			
	}
	
	public int sizeRecursivelyUsingSizeClass() {
		
		Size size = new Size();
		
		return sizeRecursivelyUsingSizeClass(this.head, size);	
		
	}
	
	public int sizeRecursivelyUsingSizeClass(SNode newHead, Size size) {
		
		if(newHead == null) {
			return size.size;
		}
		
		size.size++;
		
		return sizeRecursivelyUsingSizeClass(newHead.next, size);
	}
	
	class Size {
		int size;
	}
	
	public SNode getNthNode(int n) {
		
		int count = 1;
		
		SNode ptr = this.head;
		
		while(ptr != null && count != n) {
			
			count++;
			ptr = ptr.next;
		}
		
		if(ptr != null)
			return ptr;
		
		return null;
	}
	
	public SNode getNthFromLast(int N) {
		
		SNode ptr = head;
		SNode sptr = head;
		int count = 0;
		
		while(ptr != null) {
			
			while(ptr != null && count != N) {
				ptr = ptr.next;
				count++;
			}
			
			sptr = sptr.next;
			ptr = ptr.next;
		}
		
		return sptr;
	}
	
	public SNode getMiddle() {
		
		if(this.head == null)
			return null;
		
		SNode ptr = this.head;
		SNode sptr = this.head;
		
		while(ptr != null && ptr.next != null) {
			
			ptr = ptr.next.next;
			sptr = sptr.next;
		}
		
		return sptr;
	}
}
