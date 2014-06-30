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
				"0.30\n" +
				"12.35\n" +
				"2.25\n" +
				"3.55\n" +
				"9.90\n" +
				"199.90\n" +
				"288.45\n" +
				"278.42\n" +
				"285.65\n" +
				"300.00\n" +
				"122.40\n" +
				"148.90\n" +
				"43.68\n" +
				"123.90\n" +
			    "0.00\n";
		
		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(in.getBytes()));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		Dollars.mainWork(new BufferedReader(isr), ps);
		
		String out =
				"  0.20                4\n" +
                "  2.00              293\n" +
                "  0.30                6\n" +
                " 12.35           267166\n" +
                "  2.25              388\n" +
                "  3.55             1714\n" +
                "  9.90            99998\n" +
                "199.90    7374160359543\n" +
                "288.45  131885563682391\n" +
                "278.42                0\n" +
                "285.65  121901430488365\n" +
                "300.00  181490736388615\n" +
                "122.40     196443681978\n" +
                "148.90     810222739797\n" +
                " 43.68                0\n" +
                "123.90     214269035082\n";
		
		assertEquals(out, baos.toString()); 
	}
}