package org.bpt.cpp.dp.twodim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

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
		Scanner scanner = new Scanner(is);
		StringBuilder sb = new StringBuilder();
		try {
			
			final int N = scanner.nextInt();
			int[][] nums = new int[N][N];
			

			// Load N x N matrix and calculate sum of sub matrix {0, 0} to {i, j}
			for (int i = 0; i < N; i++) {  // read row by row
				int curr = 0;
				for (int j = 0; j < N; j++) {  // read each element in row
					
					int prev = 0;
					if (i > 0) {
						prev = nums[i-1][j];
					}
					
					curr += scanner.nextInt();
					nums[i][j] = curr + prev;
				}
			}
			
			int max = 0;
			for (int i = 0; i < N; i++) { for (int j = 0; j < N; j++) {
					for (int k = i; k < N; k++) { for (int l = j; l < N; l++) {
							int sum = nums[k][l];
							if (i > 0) sum -= nums[i-1][l];
							if (j > 0) sum -= nums[k][j-1];
							if (i > 0 && j > 0) sum += nums[i-1][j-1];
							max = Math.max(max, sum);
						}
					}
				}
			}
			
			sb.append(max).append("\n");
			os.append(sb);
		} finally {
			scanner.close();
			is.close();
		}
	}
}