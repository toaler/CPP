package org.bpt.cpp.dp.onedim;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import junit.framework.TestCase;

public class TheJackpotTest extends TestCase {
	public void testInput() throws IOException {
		String in = 
                "2\n" +
                " 1 2\n" +
				"5\n" + 
				"12 -4\n" + 
				"-10 4\n" + 
				"9\n" + 
				"3\n" + 
				"-2 -1 -2\n" +
				"15\n" +
				"-3 4 8 -4 8 -5 3 4 8 -10 -2 -1 3 8 -6\n" +
				"1\n" +
				"1\n" +
				"5\n" +
                "12 -4\n" +
                "-3 4\n" +
                "9\n" +
                "6\n" +
                " 1  2   3     4    5    6\n" +
				"0\n";
		
		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(in.getBytes()));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		TheJackpot.mainWork(new BufferedReader(isr), ps);
		
		String out =
				"The maximum winning streak is 3.\n" +
				"The maximum winning streak is 13.\n" +
		        "Losing streak.\n" +
		        "The maximum winning streak is 26.\n" +
		        "The maximum winning streak is 1.\n" +
                "The maximum winning streak is 18.\n" +
                "The maximum winning streak is 21.\n";
		
		
		assertEquals(out, baos.toString()); 
	}
}
