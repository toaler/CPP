package org.bpt.cpp.dp.twodim;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import junit.framework.TestCase;

public class MaximumSumTest extends TestCase {
	public void testInput() throws IOException {
		String in = 
				"2\n" + 
				"12 -4\n" + 
				"-10 4\n";
		
		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(in.getBytes()));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		MaximumSum.mainWork(new BufferedReader(isr), ps);
		
		String out =
				"The maximum winning streak is 13.\n" +
		        "Losing streak.\n" +
		        "The maximum winning streak is 26.\n";
		
		assertEquals(out, baos.toString()); 
	}
}
