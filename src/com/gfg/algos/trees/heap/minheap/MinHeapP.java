package com.gfg.algos.trees.heap.minheap;

import java.util.ArrayList;

public class MinHeapP {
	
	ArrayList<Integer> list;
	
	public MinHeapP() {
		this.list = new ArrayList<>();
	}
	
	public int left(int i) {
		return 2*i + 1;
	}
	
	public int right(int i) {
		return 2 * i + 2;
	}
	
	public int parent(int i) {
		return (i-1)/2;
	}
	
	public void swap(int childIndex, int parentIndex) {
		int temp = list.get(childIndex);
		list.set(childIndex, list.get(parentIndex));
		list.set(parentIndex, temp);
	}
	
	public int getMin() {
		return list.get(0);
	}
	
	public int extractMin() {
		
		if(list.size() == 0)
			return -1;
		if(list.size() == 1)
			return list.remove(0);
		
		int min = list.get(0);
		int lastItem = list.remove(list.size()-1);
		list.set(0, lastItem);
		
		minify(0);
		
		return min;
		
	}
	
	public void add(int key) {
		list.add(key);
		int index = list.size() - 1;
		int parent = parent(index);
		
		while(parent != index && list.get(index) < list.get(parent)) {
			swap(parent,index);
			index = parent;
			parent = parent(parent);
		}
	}
	 
	public void minify(int i) {
		
		int leftIndex = left(i);
		int rightIndex = right(i);
		int smallest = -1;
		
		if(leftIndex <= list.size() -1 && list.get(leftIndex) < list.get(i))
		{
			smallest = leftIndex;
		} else 
		{
			smallest = i;
		}
		
		if(rightIndex <= list.size() - 1 && list.get(rightIndex) < list.get(smallest)) {
			smallest = rightIndex;
		}
		
		if(smallest != i) {
			swap(i,smallest);
			minify(smallest);
		}
		
	}
	
	public static void main(String[] args) {
		MinHeapP heap = new MinHeapP();
		
		heap.add(20);
		heap.add(2);
		heap.add(30);
		heap.add(40);
		heap.add(1);
		heap.add(5);
		
		System.out.println(heap.list);
		
		System.out.println(heap.extractMin());
		System.out.println(heap.list);
		
	}
	
}
