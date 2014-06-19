package org.bpt.cpp.dp.cc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class LetMeCountTheWays {
	static final int MAX_VALUE = 30000;
	static final int[] denom = { 1, 5, 10, 25, 50 };
	static final int[][] memor = new int[denom.length][MAX_VALUE];
	
	static {
		for (int i = 0; i < denom.length; i++) {
			for (int j = 0; j < MAX_VALUE; j++) {
				memor[i][j] = Integer.MIN_VALUE;
			}
		}
	}

	public static void mainWork(BufferedReader reader, PrintStream ps) {

		Scanner scanner = new Scanner(reader);
		StringBuffer sb;

		try {
			sb = new StringBuffer();

			while (scanner.hasNext()) {
				int value = scanner.nextInt();

				int ways = ways(0, value);

				ps.append(ways > 1 ? "There are " : "There is only ");
				ps.append(String.valueOf(ways));
				ps.append(ways > 1 ? " ways " : " way ");
				ps.append("to produce ").append(String.valueOf(value))
						.append(" cents change.").append("\n");
			}

			ps.append(sb);
		} catch (Exception e) {
			scanner.close();
			e.printStackTrace();
		}
	}

	private static int ways(int type, int value) {
		if (value == 0)
			return 1;
		if (value < 0 || type == denom.length)
			return 0;

		int ways = memor[type][value];
		
		if (ways != Integer.MIN_VALUE) {
			return ways;
		}
		
		return memor[type][value] = ways(type + 1, value) + ways(type, value - denom[type]);
	}
	
	public static void main(String args[]) {
		mainWork(new BufferedReader(new InputStreamReader(System.in)), System.out);
	}
}
