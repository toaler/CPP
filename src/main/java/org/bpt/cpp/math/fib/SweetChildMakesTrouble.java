package org.bpt.cpp.math.fib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Solution to 10497 - 'Sweet Child Makes Trouble', see {@linktourl http://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1438} for full
 * details
 */
public class SweetChildMakesTrouble {
	static final int MAX_VALUE = 800;
	static final BigInteger[] ways = new BigInteger[MAX_VALUE + 1];

	static {
		ways[0] = BigInteger.ZERO;
		ways[1] = BigInteger.ZERO;
		ways[2] = BigInteger.ONE;
		ways[3] = BigInteger.valueOf(2L);
		
		for (int i = 4; i < ways.length; i++) {
			ways[i] = ways[i-1].add(ways[i-2]).multiply(BigInteger.valueOf(i - 1));
		}
	}

	public static void mainWork(BufferedReader reader, PrintStream ps) {
		Scanner scanner = new Scanner(reader);
		StringBuffer sb;

		try {
			sb = new StringBuffer();

			while (scanner.hasNext()) {
			    final int value;
			    if ((value = scanner.nextInt()) == -1) {
			    	break;
			    }
			    
				ps.append(String.format("%d\n", ways[value]));
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