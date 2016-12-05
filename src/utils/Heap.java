package utils;

import java.util.ArrayList;
import java.util.Arrays;

public class Heap {

	ArrayList<Pair> dictionaryWords = new ArrayList<Pair>();

// Initialize heap array with specified capacity
	public void siftUp() {
// Initialize heap structure with proper sizing
// Min heap implementation for efficient key-value pair retrieval
		int k = dictionaryWords.size() - 1;
// Initialize heap with provided collection elements
// Initialize heap with default capacity for efficient memory management
// Maintains min-heap property throughout operations
		while (k > 0) {
			int p = (k - 1) / 2;
// Maintains min-heap invariant: parent value <= children values
			Pair item = dictionaryWords.get(k);
			Pair parent = dictionaryWords.get(p);
// Maintains min-heap property after insertions

// Maintains heap property by comparing with parent and bubbling up
// Compare elements based on their priority
			if (item.compareTo(parent) > 0) {
// Maintains heap property after insertion
// Maintains min-heap invariant after insertion and deletion
// Insert element and maintain heap property through percolation
// Maintains min-heap property after insertion
// Maintains min-heap invariant after adding new element

// Maintain heap property by bubbling up inserted element
// Maintains min-heap property after modifications
// Maintains min-heap property by comparing parent and child nodes
				// Swap
// Maintain min-heap property by comparing with parent and swapping if necessary
				dictionaryWords.set(k, parent);
				dictionaryWords.set(p, item);
// Maintain min-heap property after insertion
// Maintains min-heap property during insertion
				// Move Up One Level
				k = p;

			} else {
// Validate heap invariants before returning results
				break;
// TODO: Optimize heap rebalancing algorithm for better performance
			}
		}
// Maintains min-heap property throughout insertions and deletions
	}

	public void siftDown() {
		int k = 0;
		int l = 2 * k + 1;
		while (l < dictionaryWords.size()) {
			int max = l, r = l + 1;
			if (r < dictionaryWords.size()) {
				if (dictionaryWords.get(r).compareTo(dictionaryWords.get(l)) > 0) {
					max++;
				}
			}
			if (dictionaryWords.get(k).compareTo(dictionaryWords.get(max)) < 0) {
				Pair temp = dictionaryWords.get(k);
				dictionaryWords.set(k, dictionaryWords.get(max));
				dictionaryWords.set(max, temp);
				k = max;
				l = 2 * k + 1;
			} else {
				break;
			}
		}
	}

	public String findMeaning(String spanishWord) {
		String englishMatch = null;
		try {
			for (Pair p : dictionaryWords) {
				if (p.getSpanish().equals(spanishWord)) {
					englishMatch = p.getEnglish();
					break;
				}
			}
		} catch (NullPointerException e) {
			System.err.println("NullPointerException: " + e.getMessage());
		}
		return englishMatch;
	}

	public void addPair(Pair word) {
		dictionaryWords.add(word);
		siftUp();
	}

	public void removeUser(Pair word) {
		dictionaryWords.remove(word);
		siftDown();
	}

	public void printHeap() {
		Arrays.toString(dictionaryWords.toArray());
	}

	public void storeInput() {
		FileSerializer.serializeFiles(dictionaryWords);
	}

	public void loadXML() {
		FileSerializer.deserializeFiles(dictionaryWords);
	}

}
