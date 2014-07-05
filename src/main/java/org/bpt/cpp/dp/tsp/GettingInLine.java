package org.bpt.cpp.dp.tsp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Solution to 216 - {@code Getting In Line}, see {@linktourl http://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=152} 
 * for full details
 */
public class GettingInLine {

	private static double[][] memorizer;
	private static double[][] distance;

	public static void main(String[] args) throws Exception {
		mainWork(new BufferedReader(new InputStreamReader(System.in)),
				System.out);
	}

	public static void mainWork(BufferedReader reader, PrintStream ps) {
		Scanner scanner = new Scanner(reader);

		try {
			int cnt = scanner.nextInt();
			int id = 1;

			while (cnt > 0) {

				List<Node> nodes = new ArrayList<>();
				for (int i = 0; i < cnt; i++) {
					nodes.add(new Node(scanner.nextInt(), scanner.nextInt()));
				}

				distance = new double[cnt][cnt];
				for (int i = 0; i < nodes.size(); i++) {
					for (int j = 0; j < nodes.size(); j++) {
						Node start = nodes.get(i);
						Node end = nodes.get(j);
						distance[i][j] = end.distance(start);
					}
				}

				memorizer = new double[distance.length][1 << distance.length];
				for (int i = 0; i < distance.length; i++) {
					for (int j = 0; j < (1 << distance.length); j++) {
						memorizer[i][j] = -1.0;
					}
				}

				StringBuilder sb = new StringBuilder();
				sb.append("**********************************************************").append("\n");
				sb.append("Network #").append(id++).append("\n");
				
				int parent[][] = new int[distance.length][1 << distance.length];
				
				double min = tsp(0, 1, parent);

				
				int best = 0;
				int bitmask = 1 << best;

				for (int i = 0; i < parent.length - 1; i++) {
					int adj = parent[best][bitmask];

					sb.append(String.format("Cable requirement to connect (%d,%d) to (%d,%d) is %.2f feet.\n", nodes.get(best).x, nodes.get(best).y, nodes.get(adj).x, nodes.get(adj).y, nodes.get(adj).distance(nodes.get(best))));
				     bitmask |= 1 << adj;
		              best = adj;
				}
				
				sb.append("Number of feet of cable required is ")
				.append(String.format("%.2f", min)).append(".\n");
				ps.append(sb);

				cnt = scanner.nextInt();
			}
		} catch (Exception e) {
			scanner.close();
			e.printStackTrace();
		}
	}

	private static double tsp(int currentNode, int visitedNodes, int parent[][]) {
		if (visitedNodes == (1 << distance.length) - 1) {
			return 0;
		}

		if (memorizer[currentNode][visitedNodes] != -1.0) {
			return memorizer[currentNode][visitedNodes];
		}

		double min = Double.MAX_VALUE;
		for (int next = 0; next < distance.length; next++) {
			if (next != currentNode && ((visitedNodes & (1 << next)) == 0)) {
				double d = distance[currentNode][next] + tsp(next, visitedNodes | (1 << next), parent);
				
				if (d < min) {
					min = d;
					parent[currentNode][visitedNodes] = next;
				}
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

		public double distance(Node start) {
			return Math.sqrt(Math.pow(x - start.x, 2)
					+ Math.pow(y - start.y, 2)) + 16;
		}

		@Override
		public String toString() {
			return "{" + x + ", " + y + "}";
		}
	}
	
}
