package lingo.lingowords.infrastructure;

import java.util.List;

import lingo.lingowords.domain.Language;

public interface LanguageDao {
	public boolean createLanguage(Language language);
	public List<Language> getLanguages();
	public Language getLanguageID(Language language);
}
