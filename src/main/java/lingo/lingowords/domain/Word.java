package lingo.lingowords.domain;

public class Word {
	private String word;
	private Language language;

	public Word(String word, Language language) {
		this.word = word;
		this.language = language;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
}
