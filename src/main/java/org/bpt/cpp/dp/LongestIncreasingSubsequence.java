package org.bpt.cpp.dp;

/**
 * Given a sequence s[0..n−1], a subsequence is retrieved by picking any subset
 * of the sequence, but not changing the order of them. What is the longest
 * sequence such that each element is bigger than the previous one?
 * 
 * For example, in array {2,4,6,3,5,7,9} longest increasing sub sequence is of
 * length 5 {2,3,5,7,9}
 */
public class LongestIncreasingSubsequence {

	/**
	 * Given a array of integers returns int[] containing the longest increasing
	 * sub sequence. Runtime of this solution is O(N^2). This is not the optimal
	 * solution.
	 * 
	 * @param sequence
	 * @return int[] of longest increasing sub sequence
	 */
	public static int[] lis(int[] sequence) {
		int lis[] = new int[sequence.length];
		int prev[] = new int[sequence.length];
		int max = 1, bestEnd = 0;
		
		for (int i = 0; i < sequence.length; i++) {
			lis[i] = 1;
			prev[i] = -1;
			
		    for (int j = i - 1; j >= 0; j--) {
				if ((sequence[j] < sequence[i]) && (lis[i] < (lis[j] + 1))) {
					lis[i] = lis[j] + 1;
					prev[i] = j;
				}
			}
			
			if (lis[i] > max) {
				max = lis[i];
				bestEnd = i;
			}
		}
		
		int[] subsequence = new int[max];
		int i = bestEnd, j = max - 1;
		
		while(i != -1) {
			subsequence[j--] = sequence[i];
			i = prev[i];
		}
		
		return subsequence;
	}
}