package org.bpt.cpp.dp.twodim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * 
 * @author btoal
 *
 */
public class MaximumSum {
	public static void main(String[] args) throws Exception {
		mainWork(new BufferedReader(new InputStreamReader(System.in)),
				System.out);
	}

	public static void mainWork(BufferedReader is, PrintStream os) throws IOException {
		StringBuilder sb = new StringBuilder();
		try {
			int n = Integer.valueOf(is.readLine());
			int i = n * n;

			int[][] matrix = new int[n][n];
			
			while (i < (n*n)) {
				for (String num : is.readLine().split("\\w")) {
					matrix[n%i][i - (n%i) % i] = num;
				}
			}
			os.append(sb);
		} finally {
			is.close();
		}
	}
}