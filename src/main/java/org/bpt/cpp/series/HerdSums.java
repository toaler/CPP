package org.bpt.cpp.series;

/**
 * The cows in farmer John's herd are numbered and branded with consecutive
 * integers from 1 to N (1 <= N <= 10,000,000). When the cows come to the
 * barn for milking, they always come in sequential order from 1 to N.
 * 
 * Farmer John, who majored in mathematics in college and loves numbers,
 * often looks for patterns. He has noticed that when he has exactly 15 cows
 * in his herd, there are precisely four ways that the numbers on any set of
 * one or more consecutive cows can add up to 15 (the same as the total
 * number of cows). They are: 15, 7+8, 4+5+6, and 1+2+3+4+5.
 * 
 * When the number of cows in the herd is 10, the number of ways he can sum
 * consecutive cows and get 10 drops to 2: namely 1+2+3+4 and 10.
 * 
 * Write a program that will compute the number of ways farmer John can sum
 * the numbers on consecutive cows to equal N. Do not use precomputation to
 * solve this problem.
 * 
 * 
 * N sum = i = N (N+J) / 2 i=J
 * 
 * 
 * N sum = ai = N ( N + 1 ) i=1
 * 
 * N sum = ai = (n (2a1 + n - 1)) / 2 i=J
 * 
 * sum = a1+a2+...+an 
 * sum = an+...+a2+a1
 * 
 * n = number of terms 
 * a1 = first value
 * 
 * 2sum = n(a1+an) 
 * an = a1+ (n-1)
 * 
 * 2sum = n(2a1+n-1)
 * 
 * eg1: sum=15; 
 * 
 * 2sum = 30 = n(2a1+n-1)
 * 
 * 2sum = n * (2*a1+n-1) 
 * 30 = 1 * 30 ==> 30 = 2*a1+1-1 ==> a1=15 (n=1) 
 * = 2 * 15 ==> 15 = 2*a1+2-1 ==> a1=7 (n=2)
 * = 3 * 10 ==> 10 = 2*a1+3-1 ==> a1=4 (n=3) 
 * = 5 * 6 ==> 6 = 2*a1+5-1 ==> a1=1 (n=5)
 * 
 */
public class HerdSums {

	public static int numberOfConsecutiveSequences(int n) {
		int s = 1;

		for (int i = 2; i <= (Math.sqrt((double) (1 + 8 * n)) - 1) / 2; ++i) {
			if (2 * n % i == 0 && (2 * n / i - i + 1) % 2 == 0)
				s++;
		}

		return s;
	}
}