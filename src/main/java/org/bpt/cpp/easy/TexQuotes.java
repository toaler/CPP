package org.bpt.cpp.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;

/**
 * Solution to 272 - TEX Quotes, see {@linktourl http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=208} 
 * for full details
 */
class TexQuotes {
	public static void main(String[] args) throws Exception {
		mainWork(System.in, System.out);
	}

	public static void mainWork(InputStream is, PrintStream os)
			throws IOException {
		Reader buffer = new BufferedReader(new InputStreamReader(is));

		TexQuotes tq = new TexQuotes();
		tq.convert(buffer, os);
	}

	public void convert(Reader reader, Appendable buf) throws IOException {
		boolean left = true;
		
		int r;
		while ((r = reader.read()) != -1) {
			char c = (char) r;
			if (c == '"') {
				if (left) {
					buf.append("``");
					left = false;
				} else {
					buf.append("''");
					left = true;
				}
			} else {
				buf.append(c);
			}
		}
	}
}