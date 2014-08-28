package org.bpt.cpp.math.fib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Solution to 900 - 'Brick Wall Patterns', see {@linktourl http://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=841} for full
 * details
 */
public class BrickWallPatterns {
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
		StringBuilder sb;

		try {
			sb = new StringBuilder();

			while (scanner.hasNext()) {
				int value = scanner.nextInt();

				if (value == 0) 
					break;
				
				long distinct = ways[value + 1];
				ps.append(String.valueOf(distinct)).append("\n");
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