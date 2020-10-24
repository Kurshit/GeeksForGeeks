package com.gfg.algos.graphs.adjlist.traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


/*
 * Hopefully you know how to find the diameter of a tree. That's the first part
 * of tree basics, after all! But this problem is completely different: now, you
 * need to find the circumference of a tree!
 *
 * As you probably know, pi is equal to the ratio between something's
 * circumferance and its diameter. Also, as you may not know, math is a lie and
 * pi is really equal to 3. Rumor has it, this is where the number tree(3) comes
 * from.
 * 
 * Assuming pi equals 3, what is the circumference of the given tree?
 * 
 * Input The first line will contain a single integer n, the number of nodes in
 * the tree. n−1 lines follow, each containing two different integers,
 * describing the edges of the tree. Additional constraint on input: these edges
 * will form a tree.
 * 
 * 1≤n≤3∗105 Output Output a single integer: the circumference of the tree.
 * 
 * Example :
 *
 * 1. Input : 3 3 2 2 1
 *
 * Output: 6
 * 
 * 2. Input : 5 4 2 1 4 5 4 3 4
 * 
 * Output: 6
 *
 *
 */


public class CircumFerenceOfTree {
	
	int V;
	LinkedList<Integer>[] adj;
	
	public CircumFerenceOfTree(int v) {
		this.V = v;
		this.adj = new LinkedList[V+1];
		for(int i=1; i <=V; i++ ) {
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int src, int tar) {
		adj[src].add(tar);
		adj[tar].add(src);
	}


	public Pair dfsFurthestNodeAndDistance(int src) {
		Pair pair = new Pair();
		int[] visited = new int[V + 1];
		Arrays.fill(visited, -1);

		visited[src] = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(src);

		while (!queue.isEmpty()) {

			src = queue.poll();

			Iterator<Integer> itr = adj[src].iterator();

			while (itr.hasNext()) {
				int n = itr.next();

				if (visited[n] == -1) {
					queue.offer(n);
					visited[n] = visited[src] + 1;
				}
			}
		}

		for (int i = 0; i < visited.length; i++) {

			if (pair.maxDistance < visited[i]) {
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
	
	public static void main(String[] args) {
		
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
		
			int V = Integer.parseInt(br.readLine());
			
			if(V == 1) {
				System.out.println(0);
				return;
			}
				
			
			CircumFerenceOfTree c = new CircumFerenceOfTree(V);
			
			for(int i =0; i < V - 1; i++) {
				String[] inputAray = br.readLine().split(" ");
				int src = Integer.parseInt(inputAray[0]);
				int tar = Integer.parseInt(inputAray[1]);
				
				c.addEdge(src, tar);
			}
			
			Pair pair = c.dfsFurthestNodeAndDistance(1);
			pair = c.dfsFurthestNodeAndDistance(pair.maxNodeItself);
			
			int result = pair.maxDistance * 3;
			System.out.println(result);
			
		
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}		
	

}
