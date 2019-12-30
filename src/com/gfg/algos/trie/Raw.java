package com.gfg.algos.trie;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Raw {

	public static void main(String[] args) {
		
		List<Integer> list =Arrays.asList(1,2,3,4);
		
		Iterator itr = list.iterator();
		int i = 0;
		while(itr.hasNext()) {
			System.out.println(i);
		}

	}

}
