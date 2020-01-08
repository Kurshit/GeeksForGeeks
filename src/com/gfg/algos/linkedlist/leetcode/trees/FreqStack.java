package com.gfg.algos.linkedlist.leetcode.trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * Implement FreqStack, a class which simulates the operation of a stack-like data structure.
 * FreqStack has two functions:
 * 		1. push(int x), which pushes an integer x onto the stack.
 * 		2. pop(), which removes and returns the most frequent element in the stack.
 *  If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
 */

class FreqStack {
	Map<Integer, Integer> freq;
	Map<Integer, Stack<Integer>> group;
	int maxfreq;

	public FreqStack() {
		freq = new HashMap();
		group = new HashMap();
		maxfreq = 0;
	}

	public void push(int x) {
		int f = freq.getOrDefault(x, 0) + 1;
		freq.put(x, f);
		if (f > maxfreq)
			maxfreq = f;

		group.computeIfAbsent(f, z-> new Stack()).push(x);
	}

	public int pop() {
		Stack<Integer> tempStack = group.get(maxfreq);
		
		if(tempStack == null || tempStack.isEmpty())
			return 0;
		
		int x = tempStack.pop();
		
		freq.put(x, freq.get(x) - 1);
		if (group.get(maxfreq).size() == 0)
			maxfreq--;
		return x;
	}

	public static void main(String[] args) {

		FreqStack stack = new FreqStack();

		stack.push(5);
		stack.push(7);
		stack.push(5);
		stack.push(7);
		stack.push(4);
		stack.push(4);
		stack.push(4);
		stack.push(4);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(9);

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());


	}
}