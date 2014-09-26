package org.bpt.cpp.cs;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Solution to 441 - Lotto, see {@linktourl http://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=382}
 * for full details
 */
public class Lotto {
	public static void main(String args[]) {
		mainWork(new BufferedReader(new InputStreamReader(System.in)), System.out);
	}

	public static void mainWork(BufferedReader reader, PrintStream ps) {
		StringBuilder sb;

		try (Scanner scanner = new Scanner(reader)) {
			sb = new StringBuilder();
		
			int n = 0;
			while ((n = scanner.nextInt()) != 0) {

				int[] nums = new int[n];
				for (int i = 0; i < n; i++) {
					nums[i] = scanner.nextInt();
				}


				if (sb.length() != 0) {
					sb.append("\n");
				}
				
				sb.append(generateNumbers(nums));
			}
			
			ps.append(sb);

		} catch (Exception e) {
			throw e;
		}
	}

	private static CharSequence generateNumbers(int[] numbers) {
		StringBuilder sb = new StringBuilder();
		
		for (int a = 0; a < numbers.length - 5; a++) {
			for (int b = a + 1; b < numbers.length - 4; b++) {
				for (int c = b + 1; c < numbers.length - 3; c++) {
					for (int d = c + 1; d < numbers.length - 2; d++) {
						for (int e = d + 1; e < numbers.length - 1; e++) {
							for (int f = e + 1; f < numbers.length - 0; f++) {
								sb.append(String.format("%d %d %d %d %d %d\n", numbers[a], numbers[b], numbers[c], numbers[d], numbers[e], numbers[f]));
							}
						}
					}
				}
			}
		}
		
		return sb;
	}
}