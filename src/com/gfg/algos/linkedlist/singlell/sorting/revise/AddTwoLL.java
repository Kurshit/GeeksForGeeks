package com.gfg.algos.linkedlist.singlell.sorting.revise;



import com.gfg.algos.linkedlist.singlell.LinkedList;
import com.gfg.algos.linkedlist.singlell.LinkedList.SLNode;

public class AddTwoLL {
	
	int carry = 0;
	SLNode res;
	SLNode curr;
	
	
	public SLNode addThem(SLNode h1, SLNode h2) {
		
		if(h1 == null)
			return h2;
		
		if(h2 == null)
			return h1;
		
		
		int s1 = getSize(h1);
		int s2 = getSize(h2);
		
		if(s1 == s2) {
			addSameSize(h1, h2);
		} else {
			
			if(s1 < s2) {
				SLNode temp = h1;
				h1 = h2;
				h2 = temp;
			}
			
			int diff = Math.abs(s1 - s2);
			
			SLNode temp = h1;
			
			while(diff-- >=0) {
				curr = temp;
				temp = temp.next;				
			}
			
			addSameSize(curr, h2);
			propogateCarry(h1);
			
		}
		
		if(carry > 0)
			addFirst(carry);
		
		
		return res;
		
	}
	
	public void propogateCarry(SLNode head) {
		
		if(head != curr) {
			propogateCarry(head.next);
			
			int sum = carry + head.data;
			
			carry = sum/10;
			sum = sum % 10;
			addFirst(sum);
			
		}
		
	}
	
	public void addSameSize(SLNode h1, SLNode h2) {
		
		if(h1 == null)
			return;
		
		addSameSize(h1.next, h2.next);
		
		int sum = carry + h1.data + h2.data;
		
		carry = sum / 10;
		sum = sum % 10;
		
		addFirst(sum);
	}
	
	public void addFirst(int data) {
		
		SLNode newNode = new SLNode(data); 
		if(res == null) {
			res = newNode;
			return;
		}
		
		newNode.next = res;
		res = newNode;
		
		
	}
	
	public int getSize(SLNode head) {
		
		if(head == null)
			return 0;
		
		return 1 + getSize(head.next);
			
	}
	
	public SLNode addUlte(SLNode h1, SLNode h2) {
		
		if(h1 == null) {
			res = h2;
			return res;
		}
		
		if(h2 == null) {
			res = h1;
			return res;
		}
		
		while(h1 != null || h2 != null) {
			
			int first = h1 != null ? h1.data : 0;
			int second = h2 != null ? h2.data : 0;
			
			int sum = carry + first + second;
			
			carry = sum / 10;
			sum = sum %10;
			
			addLast(sum);
			
			if(h1 != null)
				h1 = h1.next;
			
			if(h2 !=null)
				h2 = h2.next;
		}
		
		if(carry > 0)
			addLast(carry);
		
		return res;
		
		
	}
	
	public void addLast(int data) {
		SLNode newNode = new SLNode(data);
		
		if(res == null) {
			res = newNode;
			return;
		}
		
		SLNode ptr = res;
		
		while(ptr.next != null)
			ptr = ptr.next;
		
		ptr.next = newNode;
	}
	
	
	public static void main(String[] args) {
		
		LinkedList list1 = new LinkedList();
			
		LinkedList list2 = new LinkedList();
		
		list1.createIntegerWithSize2ToAddSLL4(); //  81
		list2.createIntegerWithSize3ToAddSLL3(); // 999
		
		//result : 		1017
		
		AddTwoLL add = new AddTwoLL();
		
		//SLNode result = add.addThem(list1.head, list2.head);
		
		//list1.printGivenList(result);
		
		SLNode result = add.addUlte(list1.head, list2.head);
		System.out.println();
		list1.printGivenList(result);
		
		
	}

}
