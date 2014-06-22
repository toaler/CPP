package org.bpt.cpp.dp.cc;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import junit.framework.TestCase;

public class CoinChangeTest extends TestCase {
	public void testInput() throws IOException {
		String in = 
				"11\n" +
				"26\n";
		
		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(in.getBytes()));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		CoinChange.mainWork(new BufferedReader(isr), ps);
		
		String out = 
				"4\n" +
				"13\n";
		
		assertEquals(out, baos.toString()); 
	}
}