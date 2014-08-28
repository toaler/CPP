package org.bpt.cpp.dp.cc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Solution to 357 - 'Let Me Count The Ways', see {@linktourl http://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=293} for full
 * details
 */
public class LetMeCountTheWays {
	static final int MAX_VALUE = 30000;
	static final int[] denom = { 1, 5, 10, 25, 50 };
	static final long[] ways = new long[MAX_VALUE + 1];

	static {
		ways[0] = 1;

		for (int i = 0; i < denom.length; i++) {
			for (int j = denom[i]; j < ways.length; j++) {
				ways[j] += ways[j - denom[i]];
			}
		}
	}

	public static void mainWork(BufferedReader reader, PrintStream ps) {

		Scanner scanner = new Scanner(reader);
		StringBuilder sb;

		try {
			sb = new StringBuilder();

			while (scanner.hasNext()) {
				int value = scanner.nextInt();
				long distinct = ways[value];

				ps.append(distinct > 1 ? "There are " : "There is only ");
				ps.append(String.valueOf(distinct));
				ps.append(distinct > 1 ? " ways " : " way ");
				ps.append("to produce ").append(String.valueOf(value))
						.append(" cents change.").append("\n");
			}

			ps.append(sb);
		} catch (Exception e) {
			scanner.close();
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		mainWork(new BufferedReader(new InputStreamReader(System.in)),
				System.out);
	}
}