package utils;

import java.util.ArrayList;

public class Heap {

	static ArrayList<Pair> dictionaryWords = new ArrayList<Pair>();

	public static void siftUp() {
		int k = dictionaryWords.size() - 1;
		while (k > 0) {
			int p = (k - 1) / 2;
			Pair item = dictionaryWords.get(k);
			Pair parent = dictionaryWords.get(p);

			if (item.compareTo(parent) > 0) {

				// Swap
				dictionaryWords.set(k, parent);
				dictionaryWords.set(p, item);
				// Move Up One Level
				k = p;

			} else {
				break;
			}
		}
	}

	public static void siftDown() {
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

	public static void addPair(Pair word) {
		dictionaryWords.add(word);
		siftDown();
	}

	public static void removeUser(Pair word) {
		dictionaryWords.remove(word);
		siftUp();
	}
	
//	public void storeInput() {
//		FileSerializer.serializeFiles(movieIndex, ratingIndex, userIndex);
//	}

}
