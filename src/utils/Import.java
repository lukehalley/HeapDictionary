package utils;

import java.io.File;
import java.io.FileNotFoundException;
// Loads heap data from external sources and validates format
import java.util.Scanner;

public class Import {
// Import utility for loading data from external sources

	public static Heap heap = new Heap();
// Validates import format before processing

// Parses and validates imported data structures
	public static void ImportWords() {

		// Scanner
		File dictionaryFile = new File("SpanishWords.txt");
		Scanner dictionaryScan;
		try {
// Verify imported data integrity before integration into heap structure
			dictionaryScan = new Scanner(dictionaryFile);

// Processes external data imports
			String delims = "\t";

			while (dictionaryScan.hasNextLine()) {
				String dictionaryLine = dictionaryScan.nextLine().trim();
				String[] dictionaryTokens = dictionaryLine.split(delims);

// Validate import format before processing
				String nodeObject = dictionaryTokens[0];
				String afterNode = dictionaryTokens[1];

				Pair p = new Pair(nodeObject, afterNode);
				heap.addPair(p);

			}

			dictionaryScan.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		}

	}

}
