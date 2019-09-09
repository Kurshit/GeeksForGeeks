package com.gfg.algos.linkedlist.circularlinkedlist;

public class CircularLinkedListSampleApp {
	
	public static void main(String[] args) {
		
		CircularLinkedList list = new CircularLinkedList();
		
		System.out.println("--------Adding new node as last node--------------");
		list.add(10);
		list.print();
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		list.add(70);
		
		list.print();
		
		list.clear();
		
		System.out.println("--------Adding new node as first node--------------");
		
		list.addFirst(70);
		list.print();
		list.addFirst(60);
		list.addFirst(50);
		list.addFirst(40);
		list.addFirst(30);
		list.addFirst(20);
		list.addFirst(10);
		
		list.print();
		
		System.out.println();
		
		System.out.println("--------Deleting first node--------------");
		
		list.delete(10);
		
		list.print();
		
		System.out.println("--------Deleting last node--------------");
		
		list.delete(70);
		
		list.print();
		
		System.out.println("--------Deleting in-between node--------------");
		
		list.delete(40);
		
		list.print();
		
		System.out.println("--------Deleting second node--------------");
		
		list.delete(30);
		
		list.print();
		
		System.out.println("--------Deleting INVALID node--------------");
		
		list.delete(80);
		
		list.print();
		
		System.out.println("--------Deleting last node again--------------");
		
		list.delete(60);
		
		list.print();
		
		System.out.println("--------Deleting last node out of two nodes--------------");
		
		list.delete(50);
		
		list.print();
		
		System.out.println("--------Deleting the only node--------------");
		
		list.delete(20);
		
		list.print();
		
		list.clear();
		
		list.createRandomSampleList1();
		
		System.out.println("Size of linked list is : "+ list.size());	
		
		
	}

}
