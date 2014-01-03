package org.bpt.cpp.easy;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Solution to 10550 - CombinationLock, see {@linktourl http://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=3565} 
 * for full details
 */
class CombinationLock {
	private static final int RANGE_SIZE = 40;

	public static void main(String[] args) throws Exception {
		mainWork(System.in, System.out);
	}

	public static void mainWork(InputStream is, PrintStream os)
			throws IOException {
		Scanner s = new Scanner(is);

		try {
			while (s.hasNext()) {
				int init = s.nextInt();
				int a = s.nextInt();
				int b = s.nextInt();
				int c = s.nextInt();
				s.nextLine();

				if ((init + a + b + c) == 0) {
					break;
				}
				
				os.append(String.valueOf(totalDegrees(init, a, b, c))).append("\n");
			}
		} finally {
			s.close();
		}
	}

	public static int totalDegrees(final int init, final int a, final int b, final int c) {
		return 720 + 360 + (distanceInDegrees(false, init, a) + distanceInDegrees(true, a, b) + distanceInDegrees(false, b, c)) * 9;
	}

	public static int distanceInDegrees(boolean counterClockwise, int current, int next) {
		int z = !counterClockwise ? current - next : next - current;
		
		if (current == next) {
			return 0;
		}
		
		return counterClockwise ^ (next > current) ? RANGE_SIZE + z : z;
	}
}