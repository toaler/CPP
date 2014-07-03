package org.bpt.cpp.dp.tsp;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import junit.framework.TestCase;

public class GettingInLineTest extends TestCase {

	public void testInput() throws IOException {
		String in =
			    "6\n" +
			    "5 19\n" +
			    "55 28\n" +
			    "38 101\n" +
			    "28 62\n" +
			    "111 84\n" +
			    "43 116\n" +
			    "5\n" +
			    "11 27\n" +
			    "84 99\n" +
			    "142 81\n" +
			    "88 30\n" +
			    "95 38\n" +
			    "3\n" +
			    "132 73\n" +
			    "49 86\n" +
			    "72 111\n" +
			    "0\n";

		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(
				in.getBytes()));

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		GettingInLine.mainWork(new BufferedReader(isr), ps);

		String out = "**********************************************************\n" +
					 "Network #1\n" +
					 "Cable requirement to connect (5,19) to (55,28) is 66.80 feet.\n" +
					 "Cable requirement to connect (55,28) to (28,62) is 59.42 feet.\n" +
					 "Cable requirement to connect (28,62) to (38,101) is 56.26 feet.\n" +
					 "Cable requirement to connect (38,101) to (43,116) is 31.81 feet.\n" +
					 "Cable requirement to connect (43,116) to (111,84) is 91.15 feet.\n" +
					 "Number of feet of cable required is 305.45.\n" +
					 "**********************************************************\n" +
					 "Network #2\n" +
					 "Cable requirement to connect (11,27) to (88,30) is 93.06 feet.\n" +
					 "Cable requirement to connect (88,30) to (95,38) is 26.63 feet.\n" +
					 "Cable requirement to connect (95,38) to (84,99) is 77.98 feet.\n" +
					 "Cable requirement to connect (84,99) to (142,81) is 76.73 feet.\n" +
					 "Number of feet of cable required is 274.40.\n" +
					 "**********************************************************\n" +
					 "Network #3\n" +
					 "Cable requirement to connect (132,73) to (72,111) is 87.02 feet.\n" +
					 "Cable requirement to connect (72,111) to (49,86) is 49.97 feet.\n" +
					 "Number of feet of cable required is 136.99.\n";

		assertEquals(out, baos.toString());
	}

}