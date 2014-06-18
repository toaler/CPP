package org.bpt.cpp.dp.lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class WhatGoesUp {
	public static void mainWork(BufferedReader reader, PrintStream ps) {

		String line;
		StringBuffer sb;

		try {
			sb = new StringBuffer();
			List<Integer> nums = new ArrayList<Integer>();

			while ((line = reader.readLine()) != null) {
				nums.add(Integer.valueOf(line));
			}

			Triple triple = findLisFast(nums);

			sb.append(triple.lis).append("\n").append("-").append("\n");

			Stack<Integer> lifo = new Stack<Integer>();
			int i = triple.lisPos;
			while (i >= 0) {
				lifo.push(nums.get(i));
				i = triple.prevs[i];
			}

			while (!lifo.isEmpty()) {
				sb.append(lifo.pop()).append("\n");
			}

			ps.append(sb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Triple findLisFast(List<Integer> nums) {     // O(n * log(n))
		Triple triple = new Triple(nums.size());

		// numsIndex - index represents the position in L and value corresponds to index in nums
		// prevs - index represents the position in nums and value is previous entry in the LIS
		int[] numsIndex = new int[nums.size()], prevs = new int[nums.size()];
		int lis = 0, lis_end = 0;
		List<Integer> L = new ArrayList<>();
		
		for (int i = 0; i < nums.size(); i++) {                 // O(n)
			int pos = Collections.binarySearch(L, nums.get(i)); // O(log(n))

			if (pos < 0) {
				pos = -1 * (pos + 1);    // derive insertion point
			}

			if (pos >= L.size()) {
				L.add(nums.get(i));
			} else {
				L.set(pos, nums.get(i));
			}

			numsIndex[pos] = i;
			prevs[i] = pos > 0 ? numsIndex[pos - 1] : -1;

			if (pos + 1 >= lis) {
				lis = pos + 1;
				lis_end = i;
			}
		}

		triple.lis = L.size();
		triple.lisPos = lis_end;
		triple.prevs = prevs;

		return triple;
	}

	static void reconstruct_print(int lis_end, List<Integer> nums, int[] P) {
		Stack<Integer> s = new Stack<>();
		
		int x;
		for (x = lis_end; P[x] >= 0; x = P[x])
			s.push(nums.get(x));
		System.out.printf("[%d", nums.get(x));
		for (; !s.isEmpty(); s.pop())
			System.out.printf(", %d", s.peek());
		System.out.printf("]\n");
	}

	private static Triple findLis(List<Integer> nums) {    // O(n^2)
		Triple triple = new Triple(nums.size());
		int[] lis = new int[nums.size()];

		for (int i = 0; i < nums.size(); i++) {            // O(n)
			lis[i] = 1;
			triple.prevs[i] = -1;
			for (int j = 0; j < i; j++) {                  // O(n)
				if (nums.get(j) < nums.get(i) && (lis[i] <= (lis[j] + 1))) { 
					lis[i] = lis[j] + 1;
					triple.prevs[i] = j;
				}
			}

			if (lis[i] >= triple.lis) {
				triple.lis = lis[i];
				triple.lisPos = i;
			}
		}

		return triple;
	}

	private static class Triple {
		private int lis;
		private int lisPos;
		private int prevs[];

		Triple(int size) {
			lis = Integer.MIN_VALUE;
			lisPos = Integer.MIN_VALUE;
			prevs = new int[size];
		}
	}
}