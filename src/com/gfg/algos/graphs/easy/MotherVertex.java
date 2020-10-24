package com.gfg.algos.graphs.easy;

import java.util.Iterator;

import com.gfg.algos.graphs.adjlist.UGraph;

public class MotherVertex {

	public static void findMotherVertex(UGraph graph, int V) {

		boolean[] visited = new boolean[V];

		int motherVertex = -1;

		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				DFSUtil(graph, i, visited);
				motherVertex = i;
			}
		}
		
		for (int i = 0; i < V; i++)
        {
            visited[i] = false;
        }
		
		DFSUtil(graph, motherVertex, visited);
        for(int i = 0; i < V; i++)
        {
            if(visited[i] == false)
            {
                System.out.println("Not a mother vertex.Node that wasn't connected :" + i);        
                return;
            }
        }
        System.out.println(" Mother Vertex: "  + motherVertex);
		

	}

	public static void DFSUtil(UGraph graph, int v, boolean visited[]) {
		// Mark the current node as visited and print it
		visited[v] = true;

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = graph.adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				DFSUtil(graph, n, visited);
		}
	}

	public static void main(String[] args) {

		int V = 7;

		UGraph graph = new UGraph(V);

		graph.addEdge(0, 2);
		graph.addEdge(0, 1);
		graph.addEdge(1, 3);
		graph.addEdge(4, 1);
		graph.addEdge(5, 2);
		graph.addEdge(5, 6);
		graph.addEdge(6, 4);
		graph.addEdge(6, 0);
		
		findMotherVertex(graph, V);

	}

}
