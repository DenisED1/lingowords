package lingo.lingowords.application;

import java.io.File;
import java.util.List;
import java.util.Set;

import lingo.lingowords.domain.WordSource;
import lingo.lingowords.domain.Language;
import lingo.lingowords.domain.LanguageTarget;
import lingo.lingowords.domain.Word;
import lingo.lingowords.domain.WordTarget;
import lingo.lingowords.infrastructure.DbLanguageTarget;
import lingo.lingowords.infrastructure.DbWordTarget;
import lingo.lingowords.infrastructure.TxtWordSource;

public class WordsProcessor {
	private LanguageTarget langTarget = new DbLanguageTarget();

	public boolean containsName(final List<Language> list, final String name) {
		return list.stream().filter(o -> o.getLanguage().equals(name)).findFirst().isPresent();
	}

	public Set<Word> readFile(File file, Language language) {
		WordSource wordSource = new TxtWordSource();
		Set<Word> words = wordSource.readTxtFile(file, language);

		return words;
	}

	public boolean writeToDatabase(Set<Word> words) {
		WordTarget wordTarget = new DbWordTarget();
		boolean bool = false;
		boolean result = false;
		for (Word word : words) {
			bool = wordTarget.createWord(word);
		}
		if (bool) {
			result = true;
		}
		return result;
	}

	public boolean createLanguage(Language language) {
		return langTarget.createLanguage(language);
	}

	public List<Language> getLanguages() {
		return langTarget.getLanguages();
	}

	public Language getLanguageID(String lang) {
		Language language = new Language(lang);
		return langTarget.getLanguageID(language);
	}
}
