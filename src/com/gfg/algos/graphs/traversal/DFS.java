package com.gfg.algos.graphs.traversal;

import java.util.Iterator;

import com.gfg.algos.graphs.Graph;

public class DFS {
	
	public void dfsTraversal(Graph graph, int src) {
		
		boolean[] visited = new boolean[graph.V];
		
		dfsUtil(graph,src,visited);
		
	}
	
	public void dfsUtil(Graph graph, int src, boolean[] visited) {
		
		visited[src] = true;
		
		System.out.print(src + " ");
		
		Iterator<Integer> itr = graph.adjList[src].iterator();
		
		while(itr.hasNext()) {
			int item = itr.next();
			
			if(!visited[item]) {
				visited[item] = true;
				dfsUtil(graph, item, visited);
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Graph graph = new Graph(4);
		
		graph.createSampleGraphFourvertices();
		
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
		
		DFS dfs = new DFS();
		
		dfs.dfsTraversal(graph, 2);

	}

}
