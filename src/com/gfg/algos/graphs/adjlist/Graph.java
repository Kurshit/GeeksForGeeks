package com.gfg.algos.graphs.adjlist;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	
	LinkedList<Integer> adjList[];
	int V;
	
	
	
	Graph(int V) {
		this.V = V;
		adjList = new LinkedList[V];
		
		for(int i =0; i<adjList.length; i++) {
			adjList[i] = new LinkedList<>();
		}		
				
	}
	
	public void addEdge(int src, int tar) {
		
		adjList[src].add(tar);	
		
	}
	
	public void levelOrderTraversal(int src) {
		
		boolean[] visited = new boolean[V];
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(src);
		
		visited[src] = true;
		
		while(!queue.isEmpty()) {
			
			int temp = queue.poll();
			
			System.out.print(temp + " ");
			
			for(int i : adjList[temp]) {
				if(!visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
			
		}
		
		
	}
	
	public void depthFirstTraversal(int src) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(src);
		
		
		
	}
	
	public void printGraph() {
		for(int i = 0; i<adjList.length; i++) {
			System.out.print("Vertex V " + i+ " -> ");
			for(int element : adjList[i]) {
				System.out.print(element + " - ");
			}
			System.out.println();
		}
	}
	
}
