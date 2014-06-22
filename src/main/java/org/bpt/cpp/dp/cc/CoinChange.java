package org.bpt.cpp.dp.cc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;


/**
 * Solution to 674 - Coin Change, see {@linktourl http://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=615} 
 * for full details
 */

public class CoinChange {
	static final int MAX_VALUE = 10000;
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
				
				ps.append(String.valueOf(waysRecursion(0, value))).append("\n");
			}
			ps.append(sb);
		} catch (Exception e) {
			scanner.close();
			e.printStackTrace();
		}
	}

		
	public static class Frame {
		public Frame(int type, int value) {
			this.type = type;
			this.value = value;
			this.line = 0;
		}
		protected int type;
		protected int value;
		public int line;
		public int a, b;
		
		@Override
		public String toString() {
			return String.format("{%d, %d}", type, value);
		}
	}

	public static int ways(int t, int v) {
		
		int retval = 0;
		Stack<Frame> stack = new Stack<>();
		stack.add(new Frame(t, v));
		
		while (!stack.isEmpty()) {
			Frame curr = stack.pop();
			int line = curr.line++;
			
			
			switch (line) {
			case 0:
				if (curr.value == 0)
					retval = 1;
				else
					stack.push(curr);
				break;
			case 1:
				if (curr.value < 0 || curr.type == denom.length)
					retval = 0;
				else
					stack.push(curr);
				break;
			case 2:
				if (memor[curr.type][curr.value] != Integer.MIN_VALUE) {
					retval = memor[curr.type][curr.value];
				} else  {
					stack.push(curr);
				}
				break;
			case 3:
				stack.push(curr); stack.push(new Frame(curr.type + 1, curr.value));
				break;
			case 4:
				curr.a = retval;
				stack.push(curr);
				stack.push(new Frame(curr.type, curr.value - denom[curr.type]));
				break;
			case 5:
				curr.b = retval;
				
				stack.push(curr);
				break;

			case 6:
				retval = curr.a + curr.b;
				memor[curr.type][curr.value] = retval;
				break;

			default:
				break;
			}
		}

		return retval;
}
	
	
	public static int waysRecursion(int type, int value) {
		if (value == 0) return 1;
		if (value < 0 || type == denom.length) return 0;
		
		if (memor[type][value] == Integer.MIN_VALUE) {
			memor[type][value] = waysRecursion(type + 1, value) + waysRecursion(type, value - denom[type]);
		}

		return memor[type][value];
	}

	public static void main(String args[]) {
		mainWork(new BufferedReader(new InputStreamReader(System.in)),
				System.out);
	}
}