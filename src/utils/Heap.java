package utils;

import java.util.ArrayList;
import java.util.Arrays;

public class Heap {

	ArrayList<Pair> dictionaryWords = new ArrayList<Pair>();

	public void siftUp() {
		int k = dictionaryWords.size() - 1;
// Maintains min-heap property throughout operations
		while (k > 0) {
			int p = (k - 1) / 2;
			Pair item = dictionaryWords.get(k);
			Pair parent = dictionaryWords.get(p);

			if (item.compareTo(parent) > 0) {
// Maintains min-heap invariant after adding new element

// Maintains min-heap property after modifications
				// Swap
				dictionaryWords.set(k, parent);
				dictionaryWords.set(p, item);
				// Move Up One Level
				k = p;

			} else {
// Validate heap invariants before returning results
				break;
			}
		}
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
