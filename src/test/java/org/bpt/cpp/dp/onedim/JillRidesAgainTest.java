package org.bpt.cpp.dp.onedim;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import junit.framework.TestCase;

public class JillRidesAgainTest extends TestCase {
	
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
		
		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(in.getBytes()));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		JillRidesAgain.mainWork(new BufferedReader(isr), ps);
		
		String out =
				"The nicest part of route 1 is between stops 2 and 3\n" +
				"The nicest part of route 2 is between stops 3 and 9\n" +
				"Route 3 has no nice parts\n";
		
		assertEquals(out, baos.toString()); 
	}
	
	public void testInput2() throws IOException {
		String in = 
		    "1\n" +
			"10\n" +
			"   2\n" +
			"   2\n" +
			"   2\n" +
			"   2\n" +
			"   2\n" +
			"   2\n" +
			"   -100\n" +
			"   5\n" +
			"   5\n";

		
		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(in.getBytes()));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		JillRidesAgain.mainWork(new BufferedReader(isr), ps);
		
		String out =
				"The nicest part of route 1 is between stops 1 and 7\n";
		
		assertEquals(out, baos.toString()); 
	}
	
	public void testInput3() throws IOException {
		String in = 
		    "1\n" +
			"5\n" +
			"   5\n" +
			"   5\n"+
			"   -100\n" +
			"   5\n" +
			"   5\n";

		
		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(in.getBytes()));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		JillRidesAgain.mainWork(new BufferedReader(isr), ps);
		
		String out =
				"The nicest part of route 1 is between stops 1 and 3\n";
		
		assertEquals(out, baos.toString()); 
	}
}