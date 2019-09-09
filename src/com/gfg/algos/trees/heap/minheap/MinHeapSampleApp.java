package com.gfg.algos.trees.heap.minheap;

import java.util.ArrayList;
import java.util.Arrays;

public class MinHeapSampleApp {

	public static void main(String[] args) {
		
		MinHeap mHeap = new MinHeap();
		
		mHeap.insert(40);
		mHeap.insert(10);
		mHeap.insert(20);
		mHeap.insert(70);
		mHeap.insert(90);
		mHeap.insert(50);
		mHeap.insert(5);
		
		mHeap.print();
		
		mHeap.buildHeap();
		
		mHeap.decreaseKey(2, 4);
		
		System.out.println();
		mHeap.print();
		
		System.out.println("\nMin :" + mHeap.extractMin());
		
		mHeap.print();
		System.out.println();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(40);
		list.add(10);
		list.add(5);
		list.add(70);
		list.add(80);
		list.add(2);
		
		MinHeap minHeap = new MinHeap(list);
		minHeap.print();
		
	}

}
