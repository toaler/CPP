package org.bpt.cpp.dp.ks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Solution to 10130 - {@code SuperSale}, see {@linktourl http://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1071} 
 * for full details
 */
public class SuperSale {

	public static void main(String[] args) throws Exception {
		mainWork(new BufferedReader(new InputStreamReader(System.in)),
				System.out);
	}

	public static void mainWork(BufferedReader reader, PrintStream ps) {
		Scanner scanner = new Scanner(reader);

		try {
			int scenarios = scanner.nextInt();
			StringBuilder sb = new StringBuilder();

			while (scenarios-- > 0) {
				// Read number of items and corresponding weights and values
				int n = scanner.nextInt();
				int[] values = new int[n];
				int[] weights = new int[n];

				for (int i = 0; i < n; i++) {
					values[i] = scanner.nextInt();
					weights[i] = scanner.nextInt();
				}

				// Read in number of people
				n = scanner.nextInt();

				// Read maximum capacity per person. Aggregate maximum value
				// that group can carry.
				int total = 0;
				for (int i = 0; i < n; i++) {
					total += maxValue(values, weights, scanner.nextInt());
				}

				sb.append(total).append("\n");
			}

			ps.append(sb);
		} catch (Exception e) {
			scanner.close();
			e.printStackTrace();
		}
	}

	public static int maxValue(int[] values, int[] weight, int capacity) {
		int memo[][] = new int[values.length][capacity];
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < capacity; j++) {
				memo[i][j] = Integer.MIN_VALUE;
			}
		}
		return maxValue(memo, values, weight, 0, capacity);
	}

	private static int maxValue(int[][] memo, int[] values, int[] weight,
			int currentItem, int capacity) {

		if (capacity == 0 || currentItem == values.length) {
			return 0;
		}

		int cached = memo[currentItem][capacity - 1];
		if (cached != Integer.MIN_VALUE) {
			return cached;
		}

		if (weight[currentItem] > capacity) {
			return memo[currentItem][capacity - 1] = maxValue(memo, values,
					weight, currentItem + 1, capacity); // skip current item
		}

		int a = maxValue(memo, values, weight, currentItem + 1, capacity);
		int b = values[currentItem]
				+ maxValue(memo, values, weight, currentItem + 1, capacity
						- weight[currentItem]);
		return memo[currentItem][capacity - 1] = Math.max(a, b);
	}

}