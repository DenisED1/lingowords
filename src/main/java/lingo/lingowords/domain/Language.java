package lingo.lingowords.domain;

public class Language {
	private int langid;
	private String language;
	
	public Language(String language) {
		this.language = language;
	}
	
	public Language(int langid, String language) {
		this.langid = langid;
		this.language = language;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public int getLangid() {
		return langid;
	}
	
	public void setLangid(int langid) {
		this.langid = langid;
	}
}
