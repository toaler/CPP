package org.bpt.cpp.dp.cc;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import junit.framework.TestCase;

public class DollarsTest extends TestCase {
	public void testInput() throws IOException {
		String in = 
				"0.20\n" +
				"2.00\n" +
			    "0.00\n";
		
		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(in.getBytes()));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		Dollars.mainWork(new BufferedReader(isr), ps);
		
		String out =
				"  0.20                4\n" +
                "  2.00              293\n";
		
		assertEquals(out, baos.toString()); 
	}
}