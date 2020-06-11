package lingo.lingowords.application;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lingo.lingowords.domain.IWordSource;
import lingo.lingowords.domain.Language;
import lingo.lingowords.domain.LanguageTarget;
import lingo.lingowords.domain.Word;
import lingo.lingowords.domain.WordTarget;
import lingo.lingowords.infrastructure.DbLanguageTarget;
import lingo.lingowords.infrastructure.DbWordTarget;
import lingo.lingowords.infrastructure.TxtWordSource;

public class WordsProcessor {
	private LanguageTarget langTarget = new DbLanguageTarget();

	public boolean containsName(final List<Language> list, final String name){
	    return list.stream().filter(o -> o.getLanguage().equals(name)).findFirst().isPresent();
	}
	
	public Map<String, Set<Word>> readFile(File file, Language language) {
		IWordSource wordSource = new TxtWordSource();
		Map<String, Set<Word>> words = wordSource.readTxtFile(file, language);

		return words;
	}

	public boolean getSetsFromMap(Map<String, Set<Word>> words) {
		boolean bool = false;
		boolean result = false;
		for (Map.Entry<String, Set<Word>> entry : words.entrySet()) {
			System.out.println("Start " + entry.getKey());
			bool = writeToDatabase(entry.getKey(), entry.getValue());
			System.out.println("End " + entry.getKey());
		}
		if(bool) {
			result = true;
		}
		return result;
	}
	
	public boolean writeToDatabase(String tableName, Set<Word> words) {
		WordTarget wordTarget = new DbWordTarget();
		boolean bool = false;
		boolean result = false;
		for (Word word : words) {
			bool = wordTarget.createWord(tableName, word);
		}
		if(bool) {
			result = true;
		}
		return result;
	}
	
	public boolean createLanguage(Language language) {
		return langTarget.createLanguage(language);
	}
	
	public List<Language> getLanguages(){
		return langTarget.getLanguages();
	}

	public Language getLanguageID(String lang) {
		Language language = new Language(lang);
		return langTarget.getLanguageID(language);
	}
}
