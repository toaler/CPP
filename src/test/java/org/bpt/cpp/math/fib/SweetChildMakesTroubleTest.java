package org.bpt.cpp.math.fib;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import junit.framework.TestCase;

public class SweetChildMakesTroubleTest extends TestCase {
	public void testInput() throws IOException {
		String in = 
				"2\n" +
				"3\n" +
				"4\n" +
				"-1\n";
		
		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(in.getBytes()));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		SweetChildMakesTrouble.mainWork(new BufferedReader(isr), ps);
		
		String out = 
			    "1\n" +
			    "2\n" + 
			    "9\n";
		
		assertEquals(out, baos.toString()); 
	}
}