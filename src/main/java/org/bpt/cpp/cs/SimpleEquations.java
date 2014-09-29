package org.bpt.cpp.cs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Solution to 11565 - Simple Equations, see {@linktourl http://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2612}
 * for full details
 */
public class SimpleEquations {

	public static void main(String args[]) {
		mainWork(new BufferedReader(new InputStreamReader(System.in)), System.out);
	}

	public static void mainWork(BufferedReader reader, PrintStream ps) {
		StringBuilder sb;

		try (Scanner scanner = new Scanner(reader)) {
			sb = new StringBuilder();
		
			int n = scanner.nextInt();
			for (int i = 0; i < n; i++) {
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				int c = scanner.nextInt();
				
				int[] results = search(a, b, c);
				
				if (results == null) {
					sb.append("No solution.\n");
				} else {
					sb.append(String.format("%d %d %d\n", results[0], results[1], results[2]));
				} 
			}
			
			ps.append(sb);

		} catch (Exception e) {
			throw e;
		}
	}

	private static int[] search(int a, int b, int c) {
		int[] results = new int[3];
		
		for (int x = -100; x <= 100; x++) {
			for (int y = -100; y <= 100; y++) {
				for (int z = -100; z <= 100; z++) {
					if ((x != y && x != z && y != z) &&
							x + y + z == a &&
							x * y * z == b &&
							x * x + y * y + z * z == c) {
						results[0] = x;
						results[1] = y;
						results[2] = z;
						
						return results;
					}
				}
			}
		}

		return null;
	}


}
