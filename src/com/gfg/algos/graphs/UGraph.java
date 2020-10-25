package com.gfg.algos.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class UGraph {
	
	public int V;
	public LinkedList<Integer>[] adj;
	
	
	public UGraph(int V) {
		this.V = V;
		adj = new LinkedList[V];
		
		for(int i=0; i<V; i++) {
			adj[i] = new LinkedList<>();
		}
		
	}	
	
	public void addEdge(int src, int dest) {
		adj[src].add(dest);
		adj[dest].add(src);
	}	
	
	public void bfs(int src) {
		boolean[] visited = new boolean[V];
		visited[src] = true;
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(src);
		
		while(!queue.isEmpty()) {
			
			src = queue.poll();
			
			System.out.print(src + " ");
			
			Iterator<Integer> itr = adj[src].iterator();
			
			while(itr.hasNext()) {
				int n = itr.next();
				if(!visited[n]) {
					queue.offer(n);
					visited[n] = true;
				}
			}
		}
		
		System.out.println();
	}
	
	public void dfs(int src) {
		
		boolean[] visited = new boolean[V];
		dfsUtil(src, visited);
		System.out.println();
	}
	
	private void dfsUtil(int src, boolean[] visited) {
		System.out.print(src + " ");
		visited[src] = true;
		
		Iterator<Integer> itr = adj[src].iterator();
		
		while(itr.hasNext()) {
			int n = itr.next();
			
			if(!visited[n]) {
				dfsUtil(n, visited);
				visited[n] = true;
			}
		}
	}
}
