package com.gfg.algos.graphs.traversal;

import java.util.Iterator;

import com.gfg.algos.graphs.UGraph;

import com.gfg.algos.graphs.Graph;

public class TransitiveClosure {

	/*
	 * Reachability matrix of 1's and 0's. Shows if path exists of no for every pair of vertices. Two approaches - 
	 * 1. Using Floyd Warshall: O(n3).
	 * 2. Using DFS O(n2).
	 *  
	 */

	
	/*  Approach 1:
	 * This approach uses matrix as input. This is based on FLoyds Warshall Algorithm. O(n3).
	 * Where in the given matrix will have only direct path given. Not indirect. We need to create a new matrix, that will show 1 for 
	 * vertices if path - direct/indirect exists between them. * 
	 * 
	 */


	public int[][] transitiveClosure(int[][] arr, int V) {

		int[][] result = new int[V][V];

		for(int i=0; i< V; i++) {
			for(int j =0; j< V; j++) {
				result[i][j] = arr[i][j];
			}
		}


		for(int k=0; k < V; k++) {
			for(int i=0; i<V; i++) {
				for(int j=0; j<V; j++) {
					result[i][j] = (result[i][j] != 0) || ((result[i][k] != 0) && (result[k][j] != 0)) ? 1 : 0;  
				}
			}
		}

		return result;


	}
	
	/*
	 * Approach 2 : Using DFT
	 */
	
	int V = 4;
	UGraph graph = new UGraph(V);
	int[][] tcResult = new int[V][V];
	
	public void transitiveClosureUsingDFS() {
		
		for(int i=0; i< V; i++) {
			dfsUtil(i,i);
		}
		
	}
	
	public void dfsUtil(int src, int dest) {
		
		tcResult[src][dest] = 1;
		
		Iterator<Integer> itr = graph.adj[dest].iterator();	
		
		while(itr.hasNext()) {
			
			int item = itr.next();
			
			if(tcResult[src][item]  == 0) {
				dfsUtil(src, item);
			}
		}
		
	}
	
	
	public static void main(String[] args) {

		int in[][] = new int[][]
			{{1, 1, 0, 1}, 
			{0, 1, 1, 0}, 
			{0, 0, 1, 1}, 
			{0, 0, 0, 1} 
		}; 

		int V = 4;
		TransitiveClosure tc = new TransitiveClosure();

		int[][] res = tc.transitiveClosure(in,V);
		
		tc.printArray(res, V);
		
		tc.graph.addEdge(0, 1);
		tc.graph.addEdge(0, 3);
		tc.graph.addEdge(1, 2);
		tc.graph.addEdge(2, 3);
		
	/*	
		tc.graph.addEdge(0, 1); 
		tc.graph.addEdge(0, 2); 
		tc.graph.addEdge(1, 2); 
		tc.graph.addEdge(2, 0); 
		tc.graph.addEdge(2, 3); 
		tc.graph.addEdge(3, 3); 
        */
		
		tc.transitiveClosureUsingDFS();
		
		
		System.out.println();
		
		tc.printArray(tc.tcResult, V);
		
		/*1 1 1 1
		0 1 1 1
		0 0 1 1
		0 0 0 1 */

	}

	public void printArray(int[][] arr, int V) {

		for(int i=0; i< V; i++) {
			for(int j =0; j< V; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}


}
