package com.gfg.algos.graphs;

public class UGraphSampleApp {
	
	public static void main(String[] args) {
		
		UGraph graph = new UGraph(4);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		
		/*
		 *   
		 *   	0 ------ 1 -----2
		 *   	\
		 *   	 \
		 *   	  \
		 *   	   \
		 *   		3
		 */
		
		graph.bfs(0);
		graph.dfs(0);
		
	}

}
