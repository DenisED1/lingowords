package lingo.lingowords.domain;

import java.util.List;

public interface LanguageTarget {
	boolean createLanguage(Language language);
	List<Language> getLanguages();
	Language getLanguageID(Language language);
}
