package com.gfg.algos.graphs.traversal;

import java.util.Iterator;
import java.util.LinkedList;

public class BFT {

	
	public static void main(String[] args) {
			
		Graph graph = new Graph(4);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		System.out.println(" BFT is - ");
		
		graph.bfTraversal(2);
		graph.dfTraversal(2);
		

	}

}

class Graph {
	 
	int V;
	LinkedList<Integer>[] adj;
	
	Graph(int noOfVertices) {
		this.V = noOfVertices;
		
		adj = new LinkedList[V];
		
		for(int i=0; i<V; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	
	public void addEdge(int src, int dest) {
		
		adj[src].add(dest);
	}
	
	
	public void bfTraversal(int src) {

		boolean[] visited = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<>();
		
		visited[src] = true;
		
		queue.add(src);
		
		while(queue.size() != 0) {
			 
			src = queue.poll();
			
			System.out.print(src + " -> ");
			
			//get all adjacent nodes - explore src
			
			Iterator<Integer> i = adj[src].listIterator();
			
			while(i.hasNext()) {
				
				int n = i.next();
				
				// it given node is not visited before
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
			
			
		}	
		
	}
	
	//DFS uses a receursive DFSUtil 
	
	public void dfTraversal(int src) {
		
		boolean[] visited = new boolean[V];
		
		dfsUtil(src, visited);
	}
	
	public void dfsUtil(int src, boolean[] visited) {
		
		visited[src] = true;
		
		System.out.print(src + " ");
		
		Iterator<Integer> i = adj[src].listIterator();
		
		//For every eleement, suspend the current node and travers till depth, recursively
		
		while(i.hasNext()) {
			int n = i.next();
			
			if(!visited[n]) {
				dfsUtil(n, visited);
			}
		}
		
	}
	
}
