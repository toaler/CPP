package org.bpt.cpp.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;

/**
 * /**
 * Solution to 787 - Maximum Sub-sequence Product, see {@linktourl http://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=728} 
 * for full details
 */
public class MaximumSubsequenceProduct {
	public static void main(String[] args) throws Exception {
		mainWork(new BufferedReader(new InputStreamReader(System.in)),
				System.out);
	}

	public static void mainWork(BufferedReader is, PrintStream os) throws IOException {
		StringBuilder sb = new StringBuilder();
		
		String line;
		while ((line = is.readLine()) != null) {
			BigInteger nums[] = parseLine(line);
			sb.append(findMaxSubsequenceProduct(nums)).append("\n");
		}
		
		os.append(sb);
	}
	
	private static BigInteger findMaxSubsequenceProduct(BigInteger[] nums) {
		BigInteger minEndingHere = BigInteger.valueOf(1);
		BigInteger maxEndingHere = BigInteger.valueOf(1);
		BigInteger max = BigInteger.valueOf(0);
		
		boolean isZeroArray = true;
		
		if (nums.length == 1) {
			return nums[0];
		}
		
		if (nums.length == 3 && nums[1].equals(BigInteger.ZERO))
			return BigInteger.ZERO;
		
		for (int i = 0; i < nums.length; i++) {
			BigInteger num = nums[i];
			
			if (nums[i].compareTo(BigInteger.ZERO) != 0)
				isZeroArray = false;
			
			if (num.compareTo(BigInteger.ZERO) == -1) {
				BigInteger tmp = BigInteger.ZERO.add(maxEndingHere);
				maxEndingHere = minEndingHere.multiply(num).max(BigInteger.ONE);
				minEndingHere = tmp.multiply(num);                         // pos * neg
			} else if (num.compareTo(BigInteger.ZERO) == 0) {
				// zero
				minEndingHere = BigInteger.ONE;
				maxEndingHere = BigInteger.ONE;
			} else {
				// positive
				maxEndingHere = maxEndingHere.multiply(num);               // pos * pos
				minEndingHere = minEndingHere.multiply(num).min(BigInteger.ONE);  // neg * pos
				
			}
			
			if (maxEndingHere.compareTo(max) == 1) {
				max = maxEndingHere;
			}
		}

		return isZeroArray == true ? BigInteger.ZERO : max;
	}

	private static BigInteger[] parseLine(String line) {
		String[] strings = line.split(" ");
		
		BigInteger[] nums = new BigInteger[strings.length - 1];
		for (int i = 0; i < nums.length ; i++) {
			nums[i] = BigInteger.valueOf(Long.valueOf(strings[i]));
		}
		
		return nums;
	}
}