package org.bpt.cpp.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Solution to 10684 - The Jackpot, see {@linktourl http://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1625} 
 * for full details
 */
public class TheJackpot {
	public static void main(String[] args) throws Exception {
		mainWork(new BufferedReader(new InputStreamReader(System.in)),
				System.out);
	}

	public static void mainWork(BufferedReader is, PrintStream os) throws IOException {
		StringBuilder sb = new StringBuilder();
		try {

			int numBets = 0;
			while ((numBets = Integer.valueOf(is.readLine())) != 0) {
				String line;
				int sum = 0, max = 0;

				while (numBets > 0 && ((line = is.readLine()) != null)) {
					int[] bets = parseBets(line.split(" "));
					
					for (int i = 0; i < bets.length; i++) {
						sum += bets[i];
						sum = Math.max(sum, 0);
						max = Math.max(sum, max);
						numBets--;
					}
				}
				
				if (max == 0) {
					sb.append("Losing streak.\n");
				} else {
					sb.append("The maximum winning streak is " + max + ".\n");
				}
			}
			
			os.append(sb);
		} finally {
			is.close();
		}
	}

	private static int[] parseBets(String[] tokens) {
		int[] bets = new int[tokens.length];
		
		for (int i = 0; i < tokens.length; i++) {
			bets[i] = Integer.valueOf(tokens[i]);
		}
		
		return bets;
	}
}