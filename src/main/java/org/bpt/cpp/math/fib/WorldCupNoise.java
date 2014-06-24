package org.bpt.cpp.math.fib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Solution to 10450 - 'World Cup Noise', see {@linktourl http://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1391} for full
 * details
 */
public class WorldCupNoise {
	static final int MAX_VALUE = 50;
	static final long[] ways = new long[MAX_VALUE + 1];

	static {
		ways[0] = 0;
		ways[1] = 1;
		
		for (int i = 2; i < ways.length; i++) {
			ways[i] = ways[i-1] + ways[i-2];
		}
	}

	public static void mainWork(BufferedReader reader, PrintStream ps) {
		Scanner scanner = new Scanner(reader);
		StringBuffer sb;

		try {
			sb = new StringBuffer();

			final int scenarios = scanner.nextInt();
			for (int i = 0; i < scenarios; i++) {
				if (i > 0) {
					ps.append("\n");
				}
				int value = scanner.nextInt();

				ps.append(String.format("Scenario #%d:\n%d\n", i + 1, ways[value + 2]));
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