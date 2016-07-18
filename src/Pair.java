
public class Pair {

	private String spanish;
	private String english;

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

	public int compareTo(Pair parent) {
		return this.getSpanish().compareTo(parent.getSpanish());
	}

}
