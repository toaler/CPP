package org.bpt.cpp.dp.tsp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Solution to 10496 - {@code Collecting Beepers}, see {@linktourl http://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1437} 
 * for full details
 */
public class CollectingBeepers {
	private static int[][] memorizer;
	private static int[][] distance;
	
	public static void main(String[] args) throws Exception {
		mainWork(new BufferedReader(new InputStreamReader(System.in)),
				System.out);
	}

	public static void mainWork(BufferedReader reader, PrintStream ps) {
		Scanner scanner = new Scanner(reader);

		try {
			int scenarios = scanner.nextInt();

			while (scenarios-- > 0) {
				scanner.nextInt(); // skip x
				scanner.nextInt(); // skip y

				List<Node> nodes = new ArrayList<>();
				nodes.add(new Node(scanner.nextInt(), scanner.nextInt()));

				final int beepers = scanner.nextInt();
				for (int beeper = 0; beeper < beepers; beeper++) {
					nodes.add(new Node(scanner.nextInt(), scanner.nextInt()));
				}

				distance = new int[beepers + 1][beepers + 1]; 
				for (int i = 0; i < nodes.size(); i++) {
					for (int j = 0; j < nodes.size(); j++) {
						Node start = nodes.get(i);
						Node end = nodes.get(j);
						distance[i][j] = end.distance(start);
					}
				}

				memorizer = new int[distance.length][1 << distance.length]; 
				for (int i = 0; i < distance.length; i++) {
					for (int j = 0; j < (1 << distance.length); j++) {
						memorizer[i][j] = -1;
					}
				}

				StringBuilder sb = new StringBuilder();
				sb.append("The shortest path has length ")
						.append(String.valueOf(tsp(0, 1))).append("\n");
				ps.append(sb);
			}
		} catch (Exception e) {
			scanner.close();
			e.printStackTrace();
		}
	}

	private static int tsp(int currentNode, int visitedNodes) {
		if (visitedNodes == (1 << distance.length) - 1) {
			return distance[currentNode][0];
		}

		if (memorizer[currentNode][visitedNodes] != -1) {
			return memorizer[currentNode][visitedNodes];
		}

		int min = Integer.MAX_VALUE;
		for (int next = 0; next < distance.length; next++) {
			if (next != currentNode && ((visitedNodes & (1 << next)) == 0)) {
				min = Math.min(
						min,
						distance[currentNode][next]
								+ tsp(next, visitedNodes | (1 << next)));
			}
		}

		return memorizer[currentNode][visitedNodes] = min;
	}

	private static class Node {
		private int x;
		private int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int distance(Node start) {
			return Math.abs(x - start.x) + Math.abs(y - start.y);
		}

		@Override
		public String toString() {
			return "{" + x + ", " + y + "}";
		}
	}
}