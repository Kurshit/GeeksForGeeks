package com.gfg.algos.trees.heap.minheap;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * Following code shows the implementations of Heaps using PriorityQUeue
 * 
 * Default Impl is of Min Heap
 */

public class HeapsUsingPriorityQueue {

	/*
	 *   When we create a Priority Queue using no arg constructed, it creates the MIN HEAP by default.
	 *   
	 *   To create the Max HEap tree, constructor needs to be provided mentioning to reverse the order
	 *   
	 *   using Collections.reverseOrder();
	 */
	
	public static void minHeap() {

		PriorityQueue<Integer> minPQ = new PriorityQueue<>();

		minPQ.offer(10);
		minPQ.offer(30);
		minPQ.offer(100);
		minPQ.offer(40);
		minPQ.offer(15);
		minPQ.offer(50);
		
		System.out.println("Min Heap is : ");
		System.out.println(minPQ);

		/*
		 * 				100 
		 * 			  /     \ 
		 * 			40 	 	 50 
		 * 		  /   \ 	 /  \ 
		 * 		 10    15   30
		 * 
		 * 
		 */

	}

	public static void maxHeap() {

		PriorityQueue<Integer> minPQ = new PriorityQueue<>(Collections.reverseOrder());

		minPQ.offer(10);
		minPQ.offer(30);
		minPQ.offer(100);
		minPQ.offer(40);
		minPQ.offer(15);
		minPQ.offer(50);
		
		System.out.println("Max Heap is : ");
		System.out.println(minPQ);


	}

	public static void main(String[] args) {

		minHeap();
		System.out.println();
		maxHeap();

	}

}
