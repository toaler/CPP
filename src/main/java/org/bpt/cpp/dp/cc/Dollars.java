package org.bpt.cpp.dp.cc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Solution to 147 - 'Let Me Count The Ways', see {@linktourl http://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=83} for full
 * details
 */
public class Dollars {
	static final int MAX_VALUE = 30000;
	static final int[] denom = { 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000 };
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
		StringBuffer sb;

		try {
			sb = new StringBuffer();

			while (scanner.hasNext()) {
				int value = ((int)(Math.round(scanner.nextDouble() * 100)));

				if (value == 0) 
					break;
				
				long distinct = ways[value];
				ps.append(String.format("%6.2f%17d\n", value/100.00, distinct));
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