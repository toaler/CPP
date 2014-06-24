package org.bpt.cpp.math.fib;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import junit.framework.TestCase;

public class WorldCupNoiseTest extends TestCase {
	public void testInput() throws IOException {
		String in = 
				"2\n" +
				"3\n" +
				"1\n";
		
		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(in.getBytes()));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		WorldCupNoise.mainWork(new BufferedReader(isr), ps);
		
		String out = 
				"Scenario #1:\n" + 
			    "5\n" + 
			    "\n" + 
			    "Scenario #2:\n" +
			    "2\n";
		
		assertEquals(out, baos.toString()); 
	}
}