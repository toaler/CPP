package org.bpt.cpp.series;

import org.junit.Test;

import junit.framework.TestCase;

public class HerdSumsTest extends TestCase {

	@Test
	public void testHerdSumsTest1() {
		assertEquals(4, HerdSums.numberOfConsecutiveSequences(15));
	}      
}