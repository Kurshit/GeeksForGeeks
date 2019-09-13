package com.gfg.algos.linkedlist.singlell;

public class LinkedList {

	public SLNode head;

	public static class SLNode {
		public SLNode next;
		public int data;

		public SLNode(int data) {
			this.data = data;
		}
	}

	/*
	 * Appends in the end O(n)
	 */
	public void add(int key) {

		SLNode ptr = head;

		if(ptr ==  null) {
			head = new SLNode(key);
			return;
		}	

		while(ptr.next != null) {
			ptr = ptr.next;
		}

		ptr.next = new SLNode(key);	

	}

	public int size() {

		int count = 0;

		SLNode ptr = head;

		if(ptr == null)
			return 0;

		while(ptr != null) {
			count++;
			ptr = ptr.next;
		}

		return count;

	}
	
	public int sizeIterative(SLNode head) {
		
		if(head == null)
			return 0;
		
		return 1 + sizeIterative(head.next);
				
		
		
	}

	public void printSL() {
		SLNode ptr = head;

		while(ptr != null)
		{
			System.out.print(ptr.data + " ");
			ptr = ptr.next;
		}
		
		System.out.println();

	}
	
	public void printGivenList(SLNode head) {
		
		if(head == null)
			return;
		
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		
		System.out.println();
	}

	public void clear() {
		head = null;
	}


	public void createSampleSLL1() {

		add(10);
		add(20);
		add(30);
		add(40);
		add(50);
		add(60);
		add(70);
		add(80);
		add(90);
		add(100);		

	}

	public void createOneNodeSLL() {

		add(10);


	}

	public void createTwoNodeSLL() {

		add(10);
		add(20);

	}

	public void createFifteenNodeSLL() {

		add(10);
		add(20);
		add(30);
		add(40);
		add(50);
		add(60);
		add(70);
		add(80);
		add(90);
		add(100);
		add(110);
		add(120);
		add(130);
		add(140);
		add(150);
	}

	public void createSevenNodeSLL() {

		add(10);
		add(20);
		add(30);
		add(40);
		add(50);
		add(60);
		add(70);

	}
	
	/*
	 *  Creates loop at 60th node. 100.next points to 50
	 * 
	 */
	
	public void createFiveLoopSLL() {

		add(10);
		add(20);
		add(30);
		add(40);
		add(50);
		add(60);
		add(70);
		add(80);
		add(90);
		add(100);
		
		SLNode ptr = head;
		SLNode loopPtr;
		while(ptr.data != 60) {
			ptr = ptr.next;
			loopPtr = ptr;		
		}
		
		loopPtr = ptr;
		
		while(ptr.next != null) {
			ptr = ptr.next;
		}
		
		ptr.next = loopPtr;		

	}
	
	public void createSevenLoopSLL() {

		add(10);
		add(20);
		add(30);
		add(40);
		add(50);
		add(60);
		add(70);
		add(80);
		add(90);
		add(100);
		
		SLNode ptr = head;
		SLNode loopPtr;
		while(ptr.data != 30) {
			ptr = ptr.next;
			loopPtr = ptr;		
		}
		
		loopPtr = ptr;
		
		while(ptr.next != null) {
			ptr = ptr.next;
		}
		
		ptr.next = loopPtr;		

	}
	
	public void createSortedDuplicateSLL() {

		add(10);
		add(20);
		add(30);
		add(30);
		add(30);
		add(40);
		add(50);
		add(50);
		add(50);
		add(60);
		add(70);
		add(70);
		add(70);
		add(70);
		add(70);
	}
	
	public void createIntegerToAddSLL1() {
		add(7);
		add(4);
		add(5);
	}
	
	public void createIntegerToAddSLL2() {
		add(2);
		add(3);
		add(6);
	}
	
	public void createIntegerWithSize3ToAddSLL3() {
		add(9);
		add(9);
		add(9);
	}
	
	public void createIntegerWithSize2ToAddSLL4() {
		add(1);
		add(8);
		
	}
	
	public void createSorted1() {
		add(5);
		add(8);
		add(12);
		add(16);
	}
	
	public void createSorted2() {
		add(2);
		add(4);
		add(9);
		add(18);
	}
	
	public void createSorted3() {
		add(1);
		add(3);
		add(15);
		add(25);
	}
	
	public void createSorted4() {
		add(0);
		add(7);
		add(11);
		add(23);
	}


}
