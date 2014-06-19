package org.bpt.cpp.dp.cc;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import junit.framework.TestCase;

public class LetMeCountTheWaysTest extends TestCase {
	public void testInput() throws IOException {
		String in = 
				"17\n" +
				"11\n" +
				"4\n";
		
		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(in.getBytes()));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		LetMeCountTheWays.mainWork(new BufferedReader(isr), ps);
		
		String out =
				"There are 6 ways to produce 17 cents change.\n" +
				"There are 4 ways to produce 11 cents change.\n" +
				"There is only 1 way to produce 4 cents change.\n";
		
		assertEquals(out, baos.toString()); 
	}
}