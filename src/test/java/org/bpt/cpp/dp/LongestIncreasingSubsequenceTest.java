package org.bpt.cpp.dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestIncreasingSubsequenceTest {
	
	@Test
	public void sequence1() {
		int[] sequence = {2,4,6,3,5,7,9};
		int[] expectedSubsequence = {2,3,5,7,9};
		
		int[] r = LongestIncreasingSubsequence.lis(sequence);
		
		assertEquals(expectedSubsequence.length, r.length);
		assertArrayEquals(expectedSubsequence, r);
	}
	
	@Test
	public void sequence2() {
		int[] sequence =  {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};	
		int[] expectedSubsequence = {0, 2, 6, 9, 11, 15};
		
		int[] r = LongestIncreasingSubsequence.lis(sequence);
		
		assertEquals(expectedSubsequence.length, r.length);
		assertArrayEquals(expectedSubsequence, r);
	}

	
	@Test
	public void sequence3() {
		int[] sequence = {2, 6, 3, 4, 1, 2, 9, 5, 8};	
		int[] expectedSubsequence = {2, 3, 4, 5, 8};
		
		int[] r = LongestIncreasingSubsequence.lis(sequence);
		
		assertEquals(expectedSubsequence.length, r.length);
		assertArrayEquals(expectedSubsequence, r);
	}
}