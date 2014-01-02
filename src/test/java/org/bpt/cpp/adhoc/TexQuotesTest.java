package org.bpt.cpp.adhoc;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import junit.framework.TestCase;


public class TexQuotesTest extends TestCase {
	public void testMultiLines() throws IOException {
		String src = 
				"\"To be or not to be,\" quoth the Bard, \"that\n" +
				"is the question\".\n" +
				"The programming contestant replied: \"I must disagree.\n" +
				"To `C' or not to `C', that is The Question!\"\n";
		
		String expected =
				"``To be or not to be,'' quoth the Bard, ``that\n" +
				"is the question''.\n" +
				"The programming contestant replied: ``I must disagree.\n" +
				"To `C' or not to `C', that is The Question!''\n";
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		TexQuotes.mainWork(toInputStream(src), ps);
		
		assertEquals(expected, baos.toString()); 
	}

	public static InputStream toInputStream(String input) {
		byte[] bytes = input.getBytes();
		return new ByteArrayInputStream(bytes);
	}
}
