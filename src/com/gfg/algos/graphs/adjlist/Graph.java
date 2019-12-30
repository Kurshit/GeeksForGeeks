package com.gfg.algos.graphs.adjlist;

import java.util.LinkedList;

public class Graph {
	
	private int V;
	private LinkedList<Integer>[] adjList;
	
	
	public Graph(int V) {
		this.V = V;
		adjList = new LinkedList[V];
		
		for(int i=0; i<V; i++) {
			adjList[i] = new LinkedList<>();
		}
		
	}
	
	
	public void addEdge(int src, int dest) {
		adjList[src].add(dest);
	}
	

	
	
}
