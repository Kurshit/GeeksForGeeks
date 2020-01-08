package com.gfg.algos.graphs.adjlist.traversal;

/*
 *  find the shortest path betweenevery pair of vertices. O(n3)
 */

public class FloydWarshallAlgo {

	public static int INF = 9999;
	public static int V = 4;

	public int[][] floydWarshallAlgo(int[][] pathMatrix) {

		int[][] result = new int[V][V];

		for(int i=0; i<V; i++) {

			for(int j=0; j<V; j++) {

				result[i][j] = pathMatrix[i][j];
			}
		}


		for(int k =0; k < V; k++) {
			for( int i = 0; i < V; i++) {
				for(int j = 0; j < V; j++) {

					result[i][j] = Math.min(result[i][j], result[i][k] + result[k][j]);

				}
			}
		}

		return result;


	}

	public static void main(String[] args) {

		int[][] pathMatrix = { {0,   5,  INF, 10},
				{INF,  0,  3,  INF},
				{INF, INF, 0,   1},
				{INF, INF, INF, 0} };

		FloydWarshallAlgo floyd = new FloydWarshallAlgo();

		int[][] result = floyd.floydWarshallAlgo(pathMatrix);

		floyd.printArray(result);

	}

	public void printArray(int[][] dist) {
		System.out.println("The following matrix shows the shortest "+ 
				"distances between every pair of vertices"); 
		for (int i=0; i<V; ++i) 
		{ 
			for (int j=0; j<V; ++j) 
			{ 
				if (dist[i][j]==INF) 
					System.out.print("INF "); 
				else
					System.out.print(dist[i][j]+"   "); 
			} 
			System.out.println(); 
		} 
	}

}
