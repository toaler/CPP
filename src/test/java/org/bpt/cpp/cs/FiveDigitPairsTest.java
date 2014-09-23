package org.bpt.cpp.cs;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import junit.framework.TestCase;

public class FiveDigitPairsTest extends TestCase {
	public void testInput() throws IOException {
		String in = 
				"61\n" +
			    "62\n" +
			    "2\n" +
			    "0\n";
                		
		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(in.getBytes()));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		FiveDigitPairs.mainWork(new BufferedReader(isr), new PrintStream(baos));
		
		final String expected = 
				"There are no solutions for 61.\n" +
		        "\n" +
                "79546 / 01283 = 62\n" +
                "94736 / 01528 = 62\n" +
                "\n" +
                "13458 / 06729 = 2\n" +
                "13584 / 06792 = 2\n" +
                "13854 / 06927 = 2\n" +
                "14538 / 07269 = 2\n" +
                "14586 / 07293 = 2\n" +
                "14658 / 07329 = 2\n" +
                "15384 / 07692 = 2\n" +
                "15846 / 07923 = 2\n" +
                "15864 / 07932 = 2\n" +
                "18534 / 09267 = 2\n" +
                "18546 / 09273 = 2\n" +
                "18654 / 09327 = 2\n" +
                "26970 / 13485 = 2\n" +
                "27096 / 13548 = 2\n" +
                "27690 / 13845 = 2\n" +
                "29076 / 14538 = 2\n" +
                "29370 / 14685 = 2\n" +
                "29670 / 14835 = 2\n" +
                "29706 / 14853 = 2\n" +
                "29730 / 14865 = 2\n" +
                "30972 / 15486 = 2\n" +
                "32970 / 16485 = 2\n" +
                "37092 / 18546 = 2\n" +
                "37290 / 18645 = 2\n" +
                "41358 / 20679 = 2\n" +
                "41538 / 20769 = 2\n" +
                "41586 / 20793 = 2\n" +
                "46158 / 23079 = 2\n" +
                "53418 / 26709 = 2\n" +
                "53814 / 26907 = 2\n" +
                "54138 / 27069 = 2\n" +
                "54186 / 27093 = 2\n" +
                "54618 / 27309 = 2\n" +
                "58134 / 29067 = 2\n" +
                "58146 / 29073 = 2\n" +
                "58614 / 29307 = 2\n" +
                "61458 / 30729 = 2\n" +
                "61584 / 30792 = 2\n" +
                "61854 / 30927 = 2\n" +
                "62970 / 31485 = 2\n" +
                "64158 / 32079 = 2\n" +
                "65418 / 32709 = 2\n" +
                "65814 / 32907 = 2\n" +
                "69702 / 34851 = 2\n" +
                "70296 / 35148 = 2\n" +
                "70962 / 35481 = 2\n" +
                "76290 / 38145 = 2\n" +
                "76902 / 38451 = 2\n" +
                "90276 / 45138 = 2\n" +
                "90372 / 45186 = 2\n" +
                "90762 / 45381 = 2\n" +
                "92370 / 46185 = 2\n" +
                "93702 / 46851 = 2\n" +
                "96270 / 48135 = 2\n" +
                "96702 / 48351 = 2\n" +
                "97026 / 48513 = 2\n" +
                "97032 / 48516 = 2\n" +
                "97062 / 48531 = 2\n" +
                "97230 / 48615 = 2\n" +
                "97302 / 48651 = 2\n";
		
		
		assertEquals(expected, baos.toString()); 
	}
}