package org.bpt.cpp.cs;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import junit.framework.TestCase;

public class LottoTest extends TestCase {
	public void testInput() throws IOException {
		String in = 
				"7 1 2 3 4 5 6 7\n" +
			    "8 1 2 3 5 8 13 21 34\n" +
			    "0\n";
                		
		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(in.getBytes()));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		Lotto.mainWork(new BufferedReader(isr), ps);
		
		String out =
                "1 2 3 4 5 6\n" +
                "1 2 3 4 5 7\n" +
                "1 2 3 4 6 7\n" +
                "1 2 3 5 6 7\n" +
                "1 2 4 5 6 7\n" +
                "1 3 4 5 6 7\n" +
                "2 3 4 5 6 7\n" +
                "\n" +
                "1 2 3 5 8 13\n" +
                "1 2 3 5 8 21\n" +
                "1 2 3 5 8 34\n" +
                "1 2 3 5 13 21\n" +
                "1 2 3 5 13 34\n" +
                "1 2 3 5 21 34\n" +
                "1 2 3 8 13 21\n" +
                "1 2 3 8 13 34\n" +
                "1 2 3 8 21 34\n" +
                "1 2 3 13 21 34\n" +
                "1 2 5 8 13 21\n" +
                "1 2 5 8 13 34\n" +
                "1 2 5 8 21 34\n" +
                "1 2 5 13 21 34\n" +
                "1 2 8 13 21 34\n" +
                "1 3 5 8 13 21\n" +
                "1 3 5 8 13 34\n" +
                "1 3 5 8 21 34\n" +
                "1 3 5 13 21 34\n" +
                "1 3 8 13 21 34\n" +
                "1 5 8 13 21 34\n" +
                "2 3 5 8 13 21\n" +
                "2 3 5 8 13 34\n" +
                "2 3 5 8 21 34\n" +
                "2 3 5 13 21 34\n" +
                "2 3 8 13 21 34\n" +
                "2 5 8 13 21 34\n" +
                "3 5 8 13 21 34\n";
		
		assertEquals(out, baos.toString()); 
	}
}