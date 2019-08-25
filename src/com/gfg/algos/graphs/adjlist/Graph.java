package com.gfg.algos.graphs.adjlist;

import java.util.LinkedList;

public class Graph {

	int V;
	
	LinkedList<Integer>[] adj;
	
	public Graph(int noOfVertices)
	{
		this.V = noOfVertices;
		adj = new LinkedList[V];
		
		for(int i=0; i< V; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	// adds an edge in undirected graph
	
	public void addEdge(int src,int dest) {
		
		// add edge from scr - which is index of given array , to dest
		adj[src].add(dest);
		
		//since graph is undirected, add an edge from dest to src also
		
		adj[dest].add(src);				
		
	}
	
	// Utility method to display the content of adj[] list - graph nodes
	
	public void printGraph() {		
		
		
		for(int i=0; i<V; i++) {
			
			System.out.println("Adjacency list of vertex :" + i);
			System.out.print("head - ");
			
			for(Integer element : adj[i]) {
				
				System.out.print(" -> " + element);
			}
			
			System.out.println("\n");
		}
	}
	
	
	public static void main(String[] args) {
		
		int V = 5; 
        Graph graph = new Graph(V); 
        graph.addEdge(0, 1); 
        graph.addEdge(0, 4); 
        graph.addEdge(1, 2); 
        graph.addEdge(1, 3); 
        graph.addEdge(1, 4); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 4); 
       
        // print the adjacency list representation of  
        // the above graph 
        graph.printGraph(); 
		

	}

}
