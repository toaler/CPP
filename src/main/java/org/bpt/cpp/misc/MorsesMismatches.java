package org.bpt.cpp.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MorsesMismatches {
	private final static String MULTIPLE_CONTEXT_INDICATOR = "!";
	private final static String BEST_FIT_INDICATOR = "?";
	private final static String SECTION_END = "*";
	
	public static void main(String[] args) throws Exception {
		mainWork(new BufferedReader(new InputStreamReader(System.in)), System.out);
	}

	public static void mainWork(BufferedReader is, PrintStream os) throws IOException {
		Scanner scanner = new Scanner(is);
		try {
			Map<String, String> morseToChar = new HashMap<>();
			for (String character = scanner.next(); !character.equals(SECTION_END); character = scanner.next()) {
				morseToChar.put(character, scanner.next());
			}

			Map<String, String> decoderBuilder = new HashMap<>();
			for (String word = scanner.next(); !word.equals(SECTION_END); word = scanner.next()) {
				StringBuilder builder = new StringBuilder();

				for (int i = 0; i < word.length(); i++) {
					builder.append(morseToChar.get(Character.toString(word.charAt(i))));
				}
				
				final String translated = builder.toString();
				final String existing = decoderBuilder.get(translated);
				if (existing != null) {
					String value = existing.length() < word.length() ? existing : word;
					decoderBuilder.put(translated, value + MULTIPLE_CONTEXT_INDICATOR);
				} else {
					decoderBuilder.put(translated, word);
				}
			}

			Decoder decoder = new Decoder(decoderBuilder);
			StringBuilder results = new StringBuilder();
			for (String word = scanner.next(); !word.equals(SECTION_END); word = scanner.next()) {
				results.append(decoder.decode(word)).append("\n");
			}
			
			os.append(results);
		} finally {
			scanner.close();
		}
	}

	private static class Decoder {
		private final Map<String, String> decoder;
		
		public Decoder(Map<String, String> decoder) {
			this.decoder = decoder;
		}
	
		public String decode(String morse) {
			Matcher bestMatch = new Matcher();
			
			for (int distance = 0; distance < morse.length(); distance++) {
				morse = morse.substring(0, morse.length() - distance);
				
				bestMatch.tryUpdate(decoder.get(morse), distance);
				if (!bestMatch.foundOptimal()) {
					return bestMatch.cleanse();
				}
				
				bestMatch.incBestPossibleDistance();
				
				// Match possible morses that match prefix morse O(n)
				for (Entry<String, String> pair : decoder.entrySet()) {
					if (bestMatch.isPrefix(morse, pair.getKey())) {
						bestMatch.tryUpdate(decoder.get(pair.getKey()), distance + (pair.getKey().length() - morse.length()));
					}
				}
				
				if (!bestMatch.foundOptimal()) {
					return bestMatch.cleanse();
				}
			}
			
			return bestMatch.cleanse();
		}
		
		private static class Matcher {
			private String word;
			private int distance;
			private int bestPossibleLength;
			
			protected Matcher() {
				this.distance = Integer.MAX_VALUE;
				this.bestPossibleLength = 0;
			}
			
			public boolean isPrefix(String morse, String potential) {
				return potential.startsWith(morse);
			}

			protected void incBestPossibleDistance() {
				bestPossibleLength++;
			}

			protected boolean foundOptimal() {
				if (!((distance == bestPossibleLength) && (word != null))) {
					return true;
				} 
				
				return false;
			}
			
			protected String cleanse() {
				if (distance == 0) {
					return word;
				}
				return word.charAt(word.length() - 1) == '!' ? word.substring(0, word.length()) + BEST_FIT_INDICATOR: word + BEST_FIT_INDICATOR;
			}
			
			private void tryUpdate(String match, int distance) {
				if (match != null) {
					if (word == null) {
						word = match;
						this.distance = distance;
					} else {
						if (distance < this.distance) { // better match
							word = match;
							this.distance = distance;
						}
					}
				}
			}
			
			
		}
	
	}
}