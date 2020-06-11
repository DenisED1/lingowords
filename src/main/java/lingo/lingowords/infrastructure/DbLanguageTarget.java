package lingo.lingowords.infrastructure;

import java.util.List;

import lingo.lingowords.domain.Language;
import lingo.lingowords.domain.LanguageTarget;

public class DbLanguageTarget implements LanguageTarget{
	private LanguageDao langDao = new PostgresLanguageDaoImpl();
	
	public boolean CreateLanguage(Language language) {
		return langDao.CreateLanguage(language);
	}

	public List<Language> GetLanguages() {
		return langDao.GetLanguages();
	}

	public Language GetLanguageID(Language language) {
		return langDao.GetLanguageID(language);
	}
}
