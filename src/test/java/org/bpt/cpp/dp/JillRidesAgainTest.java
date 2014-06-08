package org.bpt.cpp.dp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import junit.framework.TestCase;

public class JillRidesAgainTest extends TestCase {

	public void testMaxRangeSumQuery1() {
		int[] stops = { -1, 6 };

		int[] actualRange = JillRidesAgain.maxRangeSumQuery(stops);
		assertEquals(2, actualRange.length);
		assertEquals(2, actualRange[0]);
		assertEquals(3, actualRange[1]);
	}

	public void testMaxRangeSumQuery2() {
		int[] stops = { 4, -5, 4, -3, 4, 4, -4, 4, -5 };

		int[] actualRange = JillRidesAgain.maxRangeSumQuery(stops);
		assertEquals(2, actualRange.length);
		assertEquals(3, actualRange[0]);
		assertEquals(9, actualRange[1]);
	}

	public void testMaxRangeSumQuery3() {
		int[] stops = { -2, -3, -4 };
		assertNull(JillRidesAgain.maxRangeSumQuery(stops));
	}
	
	public void testInput() throws IOException {
		String in = 
		    "3\n" +
			"3\n" +
			"  -1\n" +
			"   6\n" +
			"10\n" +
			"   4\n" +
			"  -5\n" +
			"   4\n" +
			"  -3\n" +
			"   4\n" +
			"   4\n" +
			"  -4\n" +
			"   4\n" +
			"  -5\n" +
			"4\n" +
			"  -2\n" +
			"  -3\n" +
			"  -4";
		
		InputStream is = new ByteArrayInputStream(in.getBytes());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		JillRidesAgain.mainWork(is, ps);
		
		String out =
				"The nicest part of route 1 is between stops 2 and 3\n" +
				"The nicest part of route 2 is between stops 3 and 9\n" +
				"Route 3 has no nice parts\n";
		
		assertEquals(out, baos.toString()); 
	}
}
