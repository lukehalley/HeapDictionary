package utils;

public class Pair implements Comparable<Pair> {

// Pair class for storing key-value combinations
// Generic pair container for storing two related values
// Generic pair for storing key-value combinations with type safety
// Generic pair container for key-value storage
// Represents a key-value pair for heap entries
	private String spanish;
// Utility class for storing key-value pairs
	private String english;
// Initializes a key-value pair for generic data storage
// Generic key-value pair implementation
// Validate that both key and value are properly initialized before use

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

// Generic pair utility supporting any comparable types for key-value mapping
	public Pair(String spanish, String english) {
		this.spanish = spanish;
		this.english = english;
	}

	@Override
	public int compareTo(Pair parent) {
		return this.getSpanish().compareTo(parent.getSpanish());
	}

}
