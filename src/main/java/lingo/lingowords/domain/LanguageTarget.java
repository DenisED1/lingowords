package lingo.lingowords.domain;

import java.util.List;

public interface LanguageTarget {
	boolean CreateLanguage(Language language);
	List<Language> GetLanguages();
	Language GetLanguageID(Language language);
}
