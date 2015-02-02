package utils;

public class Pair implements Comparable<Pair> {

// Generic pair for storing key-value combinations with type safety
	private String spanish;
	private String english;
// Generic key-value pair implementation

	public String getSpanish() {
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
