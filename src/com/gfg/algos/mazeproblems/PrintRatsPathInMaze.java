package com.gfg.algos.mazeproblems;

public class PrintRatsPathInMaze {

	public void printRatsPathInMaze(int[][] maze, int n) {
		
		int[][] solution = new int[n][n];
		
		printRatsPathInMazeUtil(maze, n, 0, 0, solution);
		
	}
	
	public void printRatsPathInMazeUtil(int[][] maze, int n, int x, int y, int[][] solution) {
		
		if( x == n-1 && y == n-1) {
			solution[x][y] = 1;
			printSolution(solution,n);
			System.out.println();
			return;
		}
		
		if(x < 0 || x >= n || y <0 || y >= n || solution[x][y] == 1 || maze[x][y] == 0) {
			return;
		}
		solution[x][y] = 1;
		printRatsPathInMazeUtil(maze, n, x, y+1, solution);
		printRatsPathInMazeUtil(maze, n, x, y-1, solution);
		printRatsPathInMazeUtil(maze, n, x+1, y, solution);
		printRatsPathInMazeUtil(maze, n, x-1, y, solution);
		solution[x][y] = 0;
		
	}
	
	public void printSolution(int[][] solution, int n) {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(solution[i][j] +" ");
			}			
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		int n = 3;
		
		int[][] maze = {{1,1,0},{1,1,1},{1,1,1}};
		
		PrintRatsPathInMaze ratMaze = new PrintRatsPathInMaze();
		ratMaze.printRatsPathInMaze(maze, n);
		
		

	}

}
