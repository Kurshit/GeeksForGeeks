package com.gfg.algos.trees.heap.minheap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxHeap {
	
	ArrayList<Integer> list;
	
	public MaxHeap() {
		this.list = new ArrayList<>();
	}
	
	public MaxHeap(ArrayList<Integer> items) {

        this.list = items;
        buildMaxHeap();
    }
	
	private void buildMaxHeap() {

        for (int i = list.size() / 2; i >= 0; i--) {
            heapify(i);
        }
    }
	
	private int right(int i) {

        return 2 * i + 2;
    }

    private int left(int i) {

        return 2 * i + 1;
    }

    private int parent(int i) {

    	return (i - 1) / 2;
    }

    private void swap(int i, int parent) {

        int temp = list.get(parent);
        list.set(parent, list.get(i));
        list.set(i, temp);
    }
    
    public void insert(int key) {
    	
    	list.add(key);
    	int index = list.size() - 1;
    	int parent = parent(index);
    	
    	while(index != parent && list.get(index) > list.get(parent)) {
    		
    		swap(index, parent);
    		index = parent;
    		parent = parent(parent);
    		
    	}    	
    }
    
    public int extractMax() {
    	
    	if(list.size() == 0)
    		return -1;
    	
    	if(list.size() == 1)
    		return list.remove(0);
    	
    	int max = list.get(0);
    	int lastItem = list.remove(list.size() - 1);
    	
    	list.set(0, lastItem);
    	
    	heapify(0);
    	return max;   	
    	
    }
    
    public void heapify(int i) {
    	
    	int left = left(i);
    	int right = right(i);
    	int largest = Integer.MAX_VALUE;
    	
    	if(left <= list.size() -1 && list.get(left) > list.get(i)) {
    		largest = left;
    	} else {
    		largest = i;
    	}
    	
    	if(right <= list.size() - 1 && list.get(right) > list.get(largest)) {
    		largest = right;
    	}
    	
    	if(largest != i) {
    		swap(largest,i);
    		heapify(largest);
    	}
    	
    }
    
    public void print() {
    	
    	for(int e : list) {
    		System.out.print(e + " ");
    	}
    }

    
    
    
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(4);
		list.add(10);
		list.add(3);
		list.add(5);
		list.add(1);
		list.add(8);
		list.add(2);
		list.add(20);
		
		
		MaxHeap max = new MaxHeap(list);
		
		max.print();
		
/*		max.insert(20);
		max.insert(30);
		max.insert(2);
		max.insert(10);
		max.insert(5);
		max.insert(50);
		max.insert(60);
		
		System.out.println(max.list);
		System.out.println(max.extractMax());
		System.out.println(max.list); */
	}

}
