package org.bpt.cpp.cs;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Solution to 725 - Division, see {@linktourl http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=666}
 * for full details
 */
public class Division {
	public static void main(String args[]) {
		mainWork(new BufferedReader(new InputStreamReader(System.in)), System.out);
	}

	public static void mainWork(BufferedReader reader, PrintStream ps) {
		StringBuilder sb;

		try (Scanner scanner = new Scanner(reader)) {
			sb = new StringBuilder();
		
			int n = 0;
			while ((n = scanner.nextInt()) != 0) {
				if (sb.length() > 0) {
					sb.append("\n");
				}

				findPairs(sb, n);
			}

			ps.append(sb);
		} catch (Exception e) {
			throw e;
		}
	}

	private static CharSequence findPairs(StringBuilder sb, int num) {
		boolean found = false;
		
		for (int denominator = 1234; denominator <= (98765 / num); denominator++) {
			int numerator = denominator * num;
			int used = 0;
			int n = numerator;
			int d = denominator;
			
			while (n > 0) {
				used |= 1 << (n % 10);
				used |= 1 << (d % 10);
				n = n / 10;
				d = d / 10;
			}
			
			if (used == 0b1111111111) {
				sb.append(String.format("%05d / %05d = %d\n", numerator, denominator, num));
				found = true;
			}
			
		}

		if (!found) {
			sb.append("There are no solutions for ").append(num).append(".\n");
		}
		
		return sb;
	}
}