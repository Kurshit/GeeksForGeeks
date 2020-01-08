package com.gfg.algos.linkedlist.singlell.revise;

public class SinglyLLSample {

	public static void main(String[] args) {
		
		
		SinglyLL list = new SinglyLL();
		
		list.addFirst(70);
		list.addFirst(60);
		list.addFirst(50);
		list.addFirst(40);
		list.addLast(80);
		list.addLast(90);
		list.addLast(100);
		
		list.addLastNode(list.head, 110);
		list.addLast(120);
		
		
		list.printSLL();
		
		System.out.println();
		
		list.printSLLNode(list.head);
		
		System.out.println("\nSize is : " + list.size());
		System.out.println("\nSize is : " + list.sizeRecursively());
		System.out.println("\nSize is : " + list.sizeRecursivelyUsingSizeClass());
		int n = 5;
		System.out.println("\nThe " + n + "th node in Linked list is : " +list.getNthNode(n).data);
		
		System.out.println("\nThe " + n + "th node from last in Linked list is : " +list.getNthFromLast(n).data);
		
		System.out.println("\nAdding element after 3rd node :");
		
		System.out.println("\nMiddle of linked list is : " +list.getMiddle().data);
		
		list.addAtGivenPosition(10, 65);
		
		list.printSLL();
		
		list.deleteLast();
		
		System.out.println("\nAfter deleting last element");
		
		list.printSLL();
		
		list.deleteFirst();
		list.printSLL();
		
		System.out.println("Deleting 50 ");
		list.deleteGivenNo(50);
		
		list.printSLL();
		
		System.out.println("Deleting 100 ");
		list.deleteGivenNo(100);
		
		list.printSLL();
		
		System.out.println("Deleting 80 ");
		list.deleteGivenNo(80);
		
		list.printSLL();
		
	}

}
