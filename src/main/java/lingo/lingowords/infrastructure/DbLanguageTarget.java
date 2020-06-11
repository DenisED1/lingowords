package lingo.lingowords.infrastructure;

import java.util.List;

import lingo.lingowords.domain.Language;
import lingo.lingowords.domain.LanguageTarget;

public class DbLanguageTarget implements LanguageTarget{
	private LanguageDao langDao = new PostgresLanguageDaoImpl();
	
	public boolean createLanguage(Language language) {
		return langDao.createLanguage(language);
	}

	public List<Language> getLanguages() {
		return langDao.getLanguages();
	}

	public Language getLanguageID(Language language) {
		return langDao.getLanguageID(language);
	}
}
