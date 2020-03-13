package com.gfg.algos.graphs.traversal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import com.gfg.algos.graphs.Graph;

public class BFS {
	
	public void bfTraversal(Graph graph, int src) {
		
		boolean[] visited = new boolean[graph.V];

		
		visited[src] = true;
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(src);
		
		while(!queue.isEmpty()) {
			
			int item = queue.poll();
			
			System.out.print(item + " ");
			
			Iterator<Integer> iterator = graph.adjList[item].iterator();
			
			while(iterator.hasNext()) {
				
				int node = iterator.next();
				
				if(!visited[node]) {
					queue.offer(node);
					visited[node] = true;
				}
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
		
		BFS bfs = new BFS();
		
		bfs.bfTraversal(graph, 2);
		
		
		
	}

}
