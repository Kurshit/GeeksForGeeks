package com.gfg.algos.trie;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Raw {

	public static void main(String[] args) throws Exception {
		
		Student s = new Student();
		
		//s.id = -5;
		
		s.setId(-5);
		
		
		
		System.out.println(s.getId());
	}

}

class Student {
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) throws Exception {
		
		if(id<0) {
			throw new Exception("Invalid");
		}
		
		this.id = id;
	}
	
	
}
