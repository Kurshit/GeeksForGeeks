package com.gfg.algos.graphs;

public class GraphSampleApp {
	
	public static void main(String[] args) {
		
		Graph graph = new Graph(4);
		
		graph.addEdge(0, 2);
		graph.addEdge(0, 1);
		graph.addEdge(1, 0);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 0);
		graph.addEdge(2, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		graph.addEdge(3, 2);	
		
		//graph.printGraph();
		
		//graph.levelOrderTraversal(2);
	}

}
