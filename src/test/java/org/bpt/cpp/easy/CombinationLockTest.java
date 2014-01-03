package org.bpt.cpp.easy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import junit.framework.TestCase;

public class CombinationLockTest extends TestCase {
	public void test() throws IOException {
		String in = 
				"0 30 0 30\n" +
				"5 35 5 35\n" +
				"0 20 0 20\n" +
				"7 27 7 27\n" +
				"0 10 0 10\n" +
				"9 19 9 19\n" +
				"0 0 0 0\n";
		
		String expected =
				"1350\n" +
				"1350\n" +
				"1620\n" +
				"1620\n" +
				"1890\n" +
				"1890\n";
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		
		CombinationLock.mainWork(toInputStream(in), ps);
		assertEquals(expected, baos.toString()); 
	}
	
	public static InputStream toInputStream(String input) {
		byte[] bytes = input.getBytes();
		return new ByteArrayInputStream(bytes);
	}
	
	public void testTotalDegrees() {
		assertEquals(1350, CombinationLock.totalDegrees(0, 30, 0, 30));
	}
	
	public void testTotalDegreesClockwiseNextGreaterThanCurrent() {
		assertEquals(10, CombinationLock.distanceInDegrees(false, 5, 35));
	}
	
	public void testTotalDegreesClockwiseNextLessThanCurrent() {
		assertEquals(5, CombinationLock.distanceInDegrees(false, 5, 0));
	}
	
	public void testTotalDegreesClockwiseNextEqualToCurrent() {
		assertEquals(0, CombinationLock.distanceInDegrees(false, 0, 0));
	}
	
	public void testTotalDegreesCounterClockwiseNextGreaterThanCurrent() {
		assertEquals(4, CombinationLock.distanceInDegrees(true, 35, 39));
	}
	
	public void testTotalDegreesCounterClockwiseNextLessThanCurrent() {
		assertEquals(10, CombinationLock.distanceInDegrees(true, 35, 5));
	}
	
	public void testTotalDegreesCounterClockwiseNextEqualToCurrent() {
		assertEquals(0, CombinationLock.distanceInDegrees(true, 0, 0));
	}
}
