package org.bpt.cpp.math.fib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Solution to 10862 - 'Connect the Cable Wires', see {@linktourl http://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1803} for full
 * details
 */
public class ConnectTheCableCars {
	static final int MAX_VALUE = 2000;
	static final BigInteger[] ways = new BigInteger[MAX_VALUE + 1];

	static {
		ways[0] = BigInteger.ZERO;
		ways[1] = BigInteger.ONE;
		
		for (int i = 2; i < ways.length; i++) {
			ways[i] = ways[i-1].add(ways[i-2]);
		}
	}

	public static void mainWork(BufferedReader reader, PrintStream ps) {
		Scanner scanner = new Scanner(reader);
		StringBuffer sb;

		try {
			sb = new StringBuffer();

			while (scanner.hasNext()) {
			    final int value;
			    if ((value = scanner.nextInt()) == 0) {
			    	break;
			    }
			    
				ps.append(String.format("%d\n", ways[value * 2]));
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
