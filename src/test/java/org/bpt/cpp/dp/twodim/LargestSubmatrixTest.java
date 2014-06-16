package org.bpt.cpp.dp.twodim;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringReader;

import junit.framework.TestCase;

public class LargestSubmatrixTest extends TestCase {
	public void testInput() throws IOException {
		String in = 
				"19\n" +
                "\n" +
                "10111000\n" +
                "00010100\n" +
                "00111000\n" +
                "00111010\n" +
                "00111111\n" +
                "01011110\n" +
                "01011110\n" +
                "00011110\n" +
                "\n" +
                "0000\n" +
                "0000\n" +
                "1100\n" +
                "0000\n" +
                "\n" +
                "00000\n" +
                "10000\n" +
                "10000\n" +
                "10000\n" +
                "00000\n" +
                "\n" +
                "00000\n" +
                "01000\n" +
                "01000\n" +
                "00000\n" +
                "00000\n" +
                "\n" +
                "0\n" +
                "\n" +
                "1\n" +
                "\n" +
		        "01101\n" + 
		        "11010\n" + 
		        "01110\n" +
		        "11110\n" +
		        "11111\n" +
		        "\n" +
		        "1010\n" +
                "0101\n" +
				"1010\n" +
				"0101\n" +
				"\n" +
				"111\n" +
				"111\n" +
				"111\n" +
				"\n" +
				"000\n" +
				"000\n" +
				"000\n" +
				"\n" +
				"000\n" +
				"000\n" +
				"001\n" +
				"\n" +
				"000\n" +
				"000\n" +
				"010\n" +
				"\n" +
				"000\n" +
				"000\n" +
				"100\n" +
				"\n" +
				"000\n" +
				"001\n" +
				"000\n" +
				"\n" +
				"000\n" +
				"010\n" +
				"000\n" +
				"\n" +
				"000\n" +
				"100\n" +
				"000\n" +
				"\n" +
				"001\n" +
				"000\n" +
				"000\n" +
				"\n" +
				"010\n" +
				"000\n" +
				"000\n" +
				"\n" +
				"100\n" +
				"000\n" +
				"000\n";
		
		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(in.getBytes()));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		LargestSubmatrix.mainWork(new BufferedReader(isr), ps);
		
		String out =
				"16\n" +
		        "2\n" +
				"3\n" +
                "2\n" +
                "0\n" +
                "1\n" +
                "9\n" +
                "1\n" +
                "9\n" +
                "0\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n";
		
		assertEquals(out, baos.toString()); 
	}
}