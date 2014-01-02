package org.bpt.cpp.easy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import junit.framework.TestCase;


public class CelebrityJeopardyTest extends TestCase {
	public void test() throws IOException {
		String in = 
				"Y = 3\n" +
				"X=9\n";
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		CelebrityJeopardy.mainWork(toInputStream(in), ps);
		
		assertEquals(in, baos.toString()); 
	}

	public static InputStream toInputStream(String input) {
		byte[] bytes = input.getBytes();
		return new ByteArrayInputStream(bytes);
	}
}
