package com.gfg.algos.graphs.traversal;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import com.gfg.algos.graphs.UGraph;

/* 
 * 	Given an Undirected graph which is a TREE, find farthest node from given source and return result in terms of following
 * queries :  
 * 
 * 	1. Return distance of farthest node from given source
 *  2. Return node itself (integer value) which is farthest from given source
 *  3. Return both
 * 
 */

public class FarthestNodeFromSource {
	
	LinkedList<Integer>[] adj;
	int V;
		
	public FarthestNodeFromSource(UGraph graph) {
		this.adj = graph.adj;
		this.V = graph.V;
	}

	public static void main(String[] args) {
		
		UGraph graph = new UGraph(10);
		
		graph.addEdge(1, 0);
		graph.addEdge(1, 6);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(2, 9);
		graph.addEdge(4, 5);
		graph.addEdge(6, 7);
		graph.addEdge(6, 8);
				
		FarthestNodeFromSource fnrs = new FarthestNodeFromSource(graph);
		
		int src = 1;
		
		System.out.println(fnrs.dfsFurthestNodeDistance(src));
		System.out.println(fnrs.dfsFurthestNodeItself(src));
		Pair pair = fnrs.dfsFurthestNodeAndDistance(src);
		
		System.out.println("Distance : " +pair.maxDistance + "  Node itself : " + pair.maxNodeItself );
	}
	
	/*
	 *  1. Returns the number of nodes the given source node is away from the farthest node.
	 *  
	 *  If there are more than one node farthest with equal distance, any one would be returned.
	 */
	
	public int dfsFurthestNodeDistance(int src) {
		
		int[] visited = new int[V];
		Arrays.fill(visited, -1);
		
		visited[src] = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(src);
		
		
		while(!queue.isEmpty()) {
			
			src = queue.poll();
						
			Iterator<Integer> itr = adj[src].iterator();
			
			while(itr.hasNext()) {
				int n = itr.next();
				
				if(visited[n] == -1) {
					queue.offer(n);
					visited[n] = visited[src] + 1;
				}
			}
		}
		
		for(int i : visited) {
			System.out.print(i+ " ");
		}
		
		System.out.println();
		
		int max = Integer.MIN_VALUE;
		
		for(int i =0; i < visited.length; i++) {
			
			max = Math.max(max, visited[i]);
		}
		
		return max;
	}
	
	/*
	 * 2. Returns the node itself that is farthest from given source node.
	 * If there are more than one node farthest with equal distance, any one would be returned.
	 */
	
	public int dfsFurthestNodeItself(int src) {
		
		int[] visited = new int[V];
		Arrays.fill(visited, -1);
		
		visited[src] = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(src);
		
		
		while(!queue.isEmpty()) {
			
			src = queue.poll();
						
			Iterator<Integer> itr = adj[src].iterator();
			
			while(itr.hasNext()) {
				int n = itr.next();
				
				if(visited[n] == -1) {
					queue.offer(n);
					visited[n] = visited[src] + 1;
				}
			}
		}		
		
		int max = Integer.MIN_VALUE;
		int indexOfMax = -1;
		for(int i =0; i < visited.length; i++) {
			
			if(max < visited[i]) {
				max = visited[i];
				indexOfMax = i;
			}		
		}		
		return indexOfMax;
	}

	public Pair dfsFurthestNodeAndDistance(int src) {
		Pair pair = new Pair();
		int[] visited = new int[V];
		Arrays.fill(visited, -1);
		
		visited[src] = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(src);
		
		
		while(!queue.isEmpty()) {
			
			src = queue.poll();
						
			Iterator<Integer> itr = adj[src].iterator();
			
			while(itr.hasNext()) {
				int n = itr.next();
				
				if(visited[n] == -1) {
					queue.offer(n);
					visited[n] = visited[src] + 1;
				}
			}
		}		
		
		
		for(int i =0; i < visited.length; i++) {
			
			if(pair.maxDistance < visited[i]) {
				pair.maxDistance = visited[i];
				pair.maxNodeItself = i;
			}		
		}		
		return pair;
	}

	static class Pair {
		int maxDistance;
		int maxNodeItself;
	}

}
