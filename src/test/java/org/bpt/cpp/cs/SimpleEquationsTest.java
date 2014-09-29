package org.bpt.cpp.cs;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import junit.framework.TestCase;

public class SimpleEquationsTest extends TestCase {
	public void testInput() throws IOException {
		String in = 
				"2\n" +
				"1 2 3\n" +
                "6 6 14\n";
                		
		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(in.getBytes()));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		SimpleEquations.mainWork(new BufferedReader(isr), ps);
		
		String out =
                "No solution.\n" +
                "1 2 3\n";
		
		assertEquals(out, baos.toString()); 
	}
}