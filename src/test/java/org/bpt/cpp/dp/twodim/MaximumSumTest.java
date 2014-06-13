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
				"4\n" +
			    "0 -2 -7  0 9  2 -6  2\n" +
                "-4  1 -4  1 -1\n" +
                "8  0 -2\n";
		
		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(in.getBytes()));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		MaximumSum.mainWork(new BufferedReader(isr), ps);
		
		String out =
				"15\n";
		
		assertEquals(out, baos.toString()); 
	}
}
