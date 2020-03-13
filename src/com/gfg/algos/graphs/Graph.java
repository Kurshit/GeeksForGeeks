package com.gfg.algos.graphs;

import java.util.LinkedList;

public class Graph {
	
	public int V;
	public LinkedList<Integer>[] adjList;	
	
	public Graph(int V) {		this.V = V;
		adjList = new LinkedList[V];
		
		for(int i=0; i<V; i++) {
			adjList[i] = new LinkedList<>();
		}
		
	}
	
	
	public void addEdge(int src, int dest) {
		adjList[src].add(dest);
	}
	
	public void createSampleGraphFourvertices() {
		
		addEdge(0,1);		
		addEdge(0,2);
		addEdge(1,2);
		addEdge(2,0);
		addEdge(2,3);
		addEdge(3,3);
		
		
		/*
		 *				0 ----------------> 1
		 *				^				/
		 *				|			   /
		 *				|  			  /	
		 *				| 	     	 /
		 *				|			/
		 *				|		  /
		 *              |       /
		 *				|	  /
		 *				˅	˅
		 *				2 ----------------> 3 ----
		 *									^	 |
		 *									|	 |
		 *									|____|			
		 *      		
		 *      	
		 */
		
	}
	

	
	
}
