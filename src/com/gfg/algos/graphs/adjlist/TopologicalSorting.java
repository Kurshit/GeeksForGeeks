package com.gfg.algos.graphs.adjlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSorting 
{ 
	private int V; // No. of vertices 
	private LinkedList<Integer> adj[]; // Adjacency List 

	//Constructor 
	TopologicalSorting(int v) 
	{ 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 

	// Function to add an edge into the graph 
	void addEdge(int v,int w) { adj[v].add(w); } 

	// A recursive function used by topologicalSort 
	void topologicalSortUtil(int v, boolean visited[], 
							Stack stack) 
	{ 
		// Mark the current node as visited. 
		visited[v] = true; 
		
		Iterator<Integer> it = adj[v].iterator(); 
		while (it.hasNext()) 
		{ 
			int i = it.next(); 
			if (!visited[i]) 
				topologicalSortUtil(i, visited, stack); 
		} 

		// Push current vertex to stack which stores result 
		stack.push(new Integer(v)); 
	} 

	// The function to do Topological Sort. It uses 
	// recursive topologicalSortUtil() 
	void topologicalSort() 
	{ 
		Stack stack = new Stack(); 

		// Mark all the vertices as not visited 
		boolean visited[] = new boolean[V]; 
		
		for (int i = 0; i < V; i++) 
			if (!visited[i]) 
				topologicalSortUtil(i, visited, stack); 

		// Print contents of stack 
		while (stack.empty()==false) 
			System.out.print(stack.pop() + " "); 
	} 

	// Driver method 
	public static void main(String args[]) 
	{ 
		// Create a graph given in the above diagram 
		TopologicalSorting g = new TopologicalSorting(6); 
		g.addEdge(5, 2); 
		g.addEdge(5, 0); 
		g.addEdge(4, 0); 
		g.addEdge(4, 1); 
		g.addEdge(2, 3); 
		g.addEdge(3, 1); 

		System.out.println("Following is a Topological " + 
						"sort of the given graph"); 
		g.topologicalSort(); 
	} 
} 

