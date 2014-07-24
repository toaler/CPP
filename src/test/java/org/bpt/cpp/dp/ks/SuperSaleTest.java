package org.bpt.cpp.dp.ks;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import junit.framework.TestCase;

public class SuperSaleTest extends TestCase {

	public void testInput() throws IOException {
		String in =
                "2\n" +
                "3\n" +
                "72 17\n" +
                "44 23\n" +
                "31 24\n" +
                "1\n" +
                "26\n" +
                "6\n" +
                "64 26\n" +
                "85 22\n" +
                "52 4\n" +
                "99 18\n" +
                "39 13\n" +
                "54 9\n" +
                "4\n" +
                "23\n" +
                "20\n" +
                "20\n" +
                "26";

		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(
				in.getBytes()));

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		SuperSale.mainWork(new BufferedReader(isr), ps);

		String out = "72\n" +
				     "514\n";

		assertEquals(out, baos.toString());
	}

}