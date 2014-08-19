package org.bpt.cpp.misc;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import junit.framework.TestCase;

public class MorseMismatchesTest extends TestCase {
	public void testInput() throws IOException {
		String in = 
                "A       .-\n" +
                "B       -...\n" +
                "C       -.-.\n" +
                "D       -..\n" +
                "E       .\n" +
                "F       ..-.\n" +
                "G       --.\n" +
                "H       ....\n" +
                "I       ..\n" +
                "J       .---\n" +
                "K       -.-\n" +
                "L       .-..\n" +
                "M       --\n" +
                "N       -.\n" +
                "O       ---\n" +
                "P       .--.\n" +
                "Q       --.-\n" +
                "  R       .-.\n" +
                "S       ...\n" +
                "T       -   \n" +
                "U       ..-\n" +
                "V       ...-\n" +
                "W       .--\n" +
                "X       -..-\n" +
                "Y       -.--\n" +
                "Z       --..\n" +
                "0       ------\n" +
                "1       .-----\n" +
                "2       ..---\n" +
                "3       ...--\n" +
                "4       ....-\n" +
                "5       .....\n" +
                "6       -....\n" +
                "7       --...\n" +
                "8       ---..\n" +
                "9       ----.\n" +
                "*\n" +
                "AN\n" +
                "EARTHQUAKE\n" +
                "EAT\n" +
                "GOD\n" +
                "HATH\n" +
                "IM\n" +
                "READY\n" +
                "TO\n" +
                "WHAT\n" +
                "WROTH\n" +
                "*\n" +
                ".--.....--   .....--....\n" +
                "--.----..   .--.-.----..\n" +
                ".--.....--   .--.\n" +
                "..-.-.-....--.-..-.--.-.\n" +
                "..--   .-...--..-.--\n" +
                "----        ..--\n" +
                "*\n";
		
		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(in.getBytes()));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		MorsesMismatches.mainWork(new BufferedReader(isr), ps);
		
		String out =
                "WHAT\n" +
                "HATH\n" +
                "GOD\n" +
                "WROTH?\n" +
                "WHAT\n" +
                "AN\n" +
                "EARTHQUAKE\n" +
                "IM!\n" +
                "READY\n" +
                "TO\n" +
                "IM!\n";
		
		assertEquals(out, baos.toString()); 
	}
}