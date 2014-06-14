package org.bpt.cpp.dp.onedim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Solution to 507 - Jill Rides Again, see {@linktourl http://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=448} 
 * for full details
 * 
 * Solved using Kadan algorithm which runtime is O(n), see {@linktourl http://en.wikipedia.org/wiki/Maximum_subarray_problem#Kadane.27s_algorithm}
 */
public class JillRidesAgain {
	public static void main(String[] args) throws Exception {
		mainWork(new BufferedReader(new InputStreamReader(System.in)),
				System.out);
	}

	public static void mainWork(BufferedReader is, PrintStream os) throws IOException {
		StringBuilder sb = new StringBuilder();
		try {
			int routes = Integer.parseInt(is.readLine());
			for (int route = 1; route <= routes; route++) {
				int init = Integer.parseInt(is.readLine().trim());

				int sum = 0, max = Integer.MIN_VALUE;
				int starting = 0, maxStarting = 0, maxEnding = 0;

				for (int j = 1; j < init; j++) {
					sum += Integer.parseInt(is.readLine().trim());

					if ((max < sum) || ((max == sum) && ((maxEnding - maxStarting) < (j - starting)))) {
						max = sum;
						maxStarting = starting;
						maxEnding = j;
					}

					if (sum < 0) {
						sum = 0;
						starting = j;
					}
				}

				if (max >= 0) {
					sb.append("The nicest part of route ").append(route).append(" is between stops ")
						.append(maxStarting + 1).append(" and ").append(maxEnding + 1).append("\n");
				} else {
					sb.append("Route ").append(route).append(" has no nice parts\n");
				}
			}

			os.append(sb);
		} finally {
			is.close();
		}
	}
}