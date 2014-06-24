package org.bpt.cpp.math.fib;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import junit.framework.TestCase;

public class BrickWallPatternsTest extends TestCase {
	public void testInput() throws IOException {
		String in = 
				"1\n" +
				"2\n" +
				"3\n" +
			    "0\n";
		
		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(in.getBytes()));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		BrickWallPatterns.mainWork(new BufferedReader(isr), ps);
		
		String out =
				"1\n" +
				"2\n" +
				"3\n";
		
		assertEquals(out, baos.toString()); 
	}
}