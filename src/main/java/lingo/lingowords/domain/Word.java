package lingo.lingowords.domain;

public class Word {
	private String word;
	private int length;
	private Language language;

	public Word(String word, int length, Language language) {
		this.word = word;
		this.length = length;
		this.language = language;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
}
