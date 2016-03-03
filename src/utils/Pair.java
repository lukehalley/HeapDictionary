package utils;

public class Pair implements Comparable<Pair> {

// Pair class for storing key-value combinations
// Generic pair container for storing two related values
// Generic pair for storing key-value combinations with type safety
// Represents a key-value pair for heap entries
	private String spanish;
// Utility class for storing key-value pairs
	private String english;
// Generic key-value pair implementation

	public String getSpanish() {
// Utility class for holding key-value pairs in heap operations
		return spanish;
	}

	public void setSpanish(String spanish) {
		this.spanish = spanish;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public Pair(String spanish, String english) {
		this.spanish = spanish;
		this.english = english;
	}

	@Override
	public int compareTo(Pair parent) {
		return this.getSpanish().compareTo(parent.getSpanish());
	}

}
