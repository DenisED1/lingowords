package lingo.lingowords.infrastructure;

import java.util.List;

import lingo.lingowords.domain.Language;

public interface LanguageDao {
	public boolean CreateLanguage(Language language);
	public List<Language> GetLanguages();
	public Language GetLanguageID(Language language);
}
