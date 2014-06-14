package org.bpt.cpp.dp.twodim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Solution to 836 - Largest Submatrix, see {@linktourl
 * http://uva.onlinejudge.org
 * /index.php?option=onlinejudge&page=show_problem&problem=777} for full details
 * 
 */
public class LargestSubmatrix {
	public static void main(String[] args) throws Exception {
		mainWork(new BufferedReader(new InputStreamReader(System.in)),
				System.out);
	}

	public static void mainWork(BufferedReader is, PrintStream os)
			throws IOException {
		Scanner scanner = new Scanner(is);
		try {
			StringBuilder sb = new StringBuilder();
			
			int cases = scanner.nextInt();
			scanner.nextLine();

			do {
				scanner.nextLine();
				sb.append(findMax(generateAggregates(scanner))).append("\n");
				cases--;
			} while (cases > 0);

			os.append(sb);
		} finally {
			scanner.close();
			is.close();
		}
	}

	private static int findMax(int[][] agg) {
		int i;
		int max = 0;

		for (i = 0; i < agg.length; i++) { for (int j = 0; j < agg.length; j++) {
				for (int k = i; k < agg.length; k++) { for (int l = j; l < agg.length; l++) {  // O(N^4)
						int sum = agg[k][l];			    // O(1)
						if (i > 0)
							sum -= agg[i - 1][l];           // O(1)
						if (j > 0)
							sum -= agg[k][j - 1];           // O(1)
						if (i > 0 && j > 0)
							sum += agg[i - 1][j - 1];       // O(1)

						if (((k - i) + 1) * ((l - j) + 1) == sum) {
							max = Math.max(max, sum);
						}
					}
				}
			}
		}
		return max;
	}

	private static int[][] generateAggregates(Scanner scanner) {
		int[][] agg = null;
		int len = 1;

		for (int i = 0; i < len; i++) {
			String line = scanner.nextLine();

			if (agg == null) { // Initialize aggregate count array
				agg = new int[line.length()][line.length()];
			}
			
			int curr = 0;
			for (int j = 0; j < line.length(); j++) {
				int prev = 0;
				if (i > 0) {
					prev = agg[i - 1][j];
				}

				curr += line.charAt(j) == '1' ? 1 : 0;
				agg[i][j] = curr + prev;
			}
			
			len = line.length();
		}

		return agg;
	}
}