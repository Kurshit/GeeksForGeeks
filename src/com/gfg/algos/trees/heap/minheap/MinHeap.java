package com.gfg.algos.trees.heap.minheap;

import java.util.ArrayList;

public class MinHeap {

    private ArrayList<Integer> list;

    public MinHeap() {

        this.list = new ArrayList<Integer>();
    }

    public MinHeap(ArrayList<Integer> items) {

        this.list = items;
        buildHeap();
    }

    public void insert(int item) {

        list.add(item);
        int i = list.size() - 1;
        int parent = parent(i);

        while (parent != i && list.get(i) < list.get(parent)) {

            swap(i, parent);
            i = parent;
            parent = parent(i);
        }
    }

    public void buildHeap() {

        for (int i = list.size() / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }
    
    //Same as Delete operation - We can not del any other node but root

    public int extractMin() {

        if (list.size() == 0) {

            throw new IllegalStateException("MinHeap is EMPTY");
        } else if (list.size() == 1) {

            int min = list.remove(0);
            return min;
        }
        
        /* 
         *  DO NOT use list.remove(0) - it will shift rest of elements to curr index
         *  
         *  Use remove() only on last element in list 
         */
        
        // remove the last item ,and set it as new root
        int min = list.get(0);
        int lastItem = list.remove(list.size() - 1);
        list.set(0, lastItem);

        // bubble-down until heap property is maintained
        minHeapify(0);

        // return min key
        return min;
    }

    public void decreaseKey(int i, int key) {

        if (list.get(i) < key) {

            throw new IllegalArgumentException("Key is larger than the original key");
        }

        list.set(i, key);
        int parent = parent(i);

        // bubble-up until heap property is maintained
        while (i > 0 && list.get(parent) > list.get(i)) {

            swap(i, parent);
            i = parent;
            parent = parent(parent);
        }
    }

    private void minHeapify(int i) {

        int left = left(i);
        int right = right(i);
        int smallest = -1;
                
        // find the smallest key between current node and its children.
        if (left <= list.size() - 1 && list.get(left) < list.get(i)) {
            smallest = left;
        } else {
            smallest = i;
        }

        if (right <= list.size() - 1 && list.get(right) < list.get(smallest)) {
            smallest = right;
        }

        // if the smallest key is not the current key then bubble-down it.
        if (smallest != i) {

            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    public int getMin() {

        return list.get(0);
    }

    public boolean isEmpty() {

        return list.size() == 0;
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
    
    public void print() {
    	
    	for(int e : list) {
    		System.out.print(e + " ");
    	}
    }

}