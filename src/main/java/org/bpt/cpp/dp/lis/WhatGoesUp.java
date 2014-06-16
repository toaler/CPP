package org.bpt.cpp.dp.lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
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
			
			int[] lis = new int[nums.size()];
			int[] prevs = new int[nums.size()];
			
			int max = Integer.MIN_VALUE;
			int maxPos = Integer.MAX_VALUE;
			
			for (int i = 0; i < nums.size(); i++) {
				lis[i] = 1;
				prevs[i] = -1;
				for (int j = 0; j < i; j++) {
					if (nums.get(j) < nums.get(i)  && (lis[i] <= (lis[j] + 1))) {
						lis[i] = lis[j] + 1;
						prevs[i] = j;
					}
				}

				if (lis[i] >= max) {
					max = lis[i];
					maxPos = i;
				}
			}
			
			sb.append(max).append("\n").append("-").append("\n");
			
			Stack<Integer> lifo = new Stack<Integer>();
			int i = maxPos;
			while (i >= 0) {
				lifo.push(nums.get(i));
				i = prevs[i];
			}
			
			while(!lifo.isEmpty()) {
				sb.append(lifo.pop()).append("\n");
			}
			
			ps.append(sb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
