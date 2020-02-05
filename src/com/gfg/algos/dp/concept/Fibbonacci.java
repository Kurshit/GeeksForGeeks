package com.gfg.algos.dp.concept;

public class Fibbonacci {


	int fibbonacci(int n) {

		if( n == 0)
			return 0;

		if(n == 1)
			return 1;

		return fibbonacci(n-1) + fibbonacci(n-2);
	}

	/*
	 *  Memoization is a TOP DOWN approach. It looks up a look-up table to see if sub problems are already solved and fetches its answer from this table.
	 *  If it has precomputed value of sub problem, it returns it. 
	 *  
	 *  This differs from Tabulation. The memoization uses recurssion to find solution. The normal recurssion has Overlapping Subproblem property. The solution to these sub problems
	 *  are stored in lok-up table.
	 */
	
	public int fibbonacciUsingMemoization(int n) {
		int[] fib = new int[n+1];
		return fibbonacciUsingMemoization(n, fib);

	}

	public int fibbonacciUsingMemoization(int n, int[] fib ) {

		if(n == 0)
			return 0;

		if(n==1)
			return 1;

		if(fib[n] != 0) {
			return fib[n];
		} else {
			fib[n] = fibbonacciUsingMemoization(n-1, fib) + fibbonacciUsingMemoization(n -2, fib);
			return fib[n];
		}		


	}
	
	/*
	 *  Tabulation - is a bottom-up approach. 
	 *  This builds the table in bottom up fasion and returns thelast entry from table as a result. 
	 *  For following example, we calculate fib(0)first then fib(1) then fib(2) .. so on. So we are essentially building solution of subproblems bottom-up.
	 */

	public int fibbonacciUsingTabulation(int n) {

		int[] fib = new int[n+1];

		fib[0] = 0;
		fib[1] = 1;

		for(int i =2; i<=n; i++) {

			fib[i] = fib[i-2] + fib[i-1];

		}

		return fib[n];
	}


	public static void main(String[] args) {

		Fibbonacci fib = new Fibbonacci();

		int result = fib.fibbonacci(9);

		System.out.println("Using recursiion :" +result);

		result = fib.fibbonacciUsingTabulation(9);
		System.out.println("Using tabulation : "+ result);


	}

}
