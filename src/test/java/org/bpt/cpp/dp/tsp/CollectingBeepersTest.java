package org.bpt.cpp.dp.tsp;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import junit.framework.TestCase;

public class CollectingBeepersTest extends TestCase {

	public void testInput() throws IOException {
		String in =
			    "2\n" +      // scenarios
				"10 10\n" +  // size of world (X x Y)
				"1 1\n" +    // starting position
				"4\n" +      // number of beepers
				"2 3\n" +    // beeper locations 
				"5 5\n" +
				"9 4\n" +
				"6 5\n" +
				"10 10\n" +  // size of world (X x Y)
				"1 1\n" +    // starting position
				"4\n" +      // number of beepers
				"2 3\n" +    // beeper locations 
				"5 5\n" +
				"9 4\n" +
				"6 5\n";

		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(
				in.getBytes()));

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		CollectingBeepers.mainWork(new BufferedReader(isr), ps);

		String out = "The shortest path has length 24\n" +
				 "The shortest path has length 24\n";

		assertEquals(out, baos.toString());
	}

}