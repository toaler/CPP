package org.bpt.cpp.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;

/**
 * Solution to 1124 - Celebrity Jeopardy, see {@linktourl http://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=3565} 
 * for full details
 */
class CelebrityJeopardy {
	public static void main(String[] args) throws Exception {
		mainWork(System.in, System.out);
	}

	public static void mainWork(InputStream is, PrintStream os)
			throws IOException {
		Reader buffer = new BufferedReader(new InputStreamReader(is));

		CelebrityJeopardy tq = new CelebrityJeopardy();
		tq.process(buffer, os);
	}

	public void process(Reader reader, Appendable buf) throws IOException {
		int r;
		while ((r = reader.read()) != -1) {
			buf.append((char) r);
		}
	}
}