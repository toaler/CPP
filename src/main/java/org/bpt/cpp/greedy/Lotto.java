package org.bpt.cpp.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Solution to 441 - {@code Lotto}, see {@linktourl http://http://uva.onlinejudge.org/external/4/441.html} 
 * for full details
 */
public class Lotto {

	public static void mainWork(BufferedReader reader, PrintStream ps) {
		Scanner scanner = new Scanner(reader);
		
		try {
			
			StringBuilder sb = new StringBuilder();
			while (scanner.hasNext()) {
				int value = scanner.nextInt();
				
				if (value == 0)
					break;

				int[] s = new int[value];
				for (int i = 0; i < value; i++) {
					s[i] = scanner.nextInt();
				}
				
				if (!(sb.length() == 0)) {
					sb.append("\n");
				}
				
				sb.append(ways(s));			
			}
			
			ps.append(sb);

		} catch (Exception e) {
			scanner.close();
			e.printStackTrace();
		}
	}

	private static StringBuilder ways(int[] s) {
		StringBuilder sb = new StringBuilder();
		
		int k = s.length;
		for (int a = 0; a < (k - 5); a++) {
			for (int b = a + 1; b < (k - 4); b++) {
				for (int c = b + 1; c < (k - 3); c++) {
					for (int d = c + 1; d < (k - 2); d++) {
						for (int e = d + 1; e < (k - 1); e++) {
							for (int f = e + 1; f < (k - 0); f++) {
								sb.append(String.format("%d %d %d %d %d %d\n", s[a], s[b], s[c], s[d], s[e], s[f]));
							}
						}
					}
				}
			}
		}
		return sb;
	}

	public static void main(String args[]) {
		mainWork(new BufferedReader(new InputStreamReader(System.in)),
				System.out);
	}
}