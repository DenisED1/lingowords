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
	
	public Map<String, Set<Word>> ReadFile(File file, Language language) {
		IWordSource wordSource = new TxtWordSource();
		Map<String, Set<Word>> words = wordSource.ReadTxtFile(file, language);

		return words;
	}

	public boolean GetSetsFromMap(Map<String, Set<Word>> words) {
		boolean bool = false;
		boolean result = false;
		for (Map.Entry<String, Set<Word>> entry : words.entrySet()) {
			bool = WriteToDatabase(entry.getKey(), entry.getValue());
		}
		if(bool) {
			result = true;
		}
		return result;
	}
	
	public boolean WriteToDatabase(String tableName, Set<Word> words) {
		WordTarget wordTarget = new DbWordTarget();
		boolean bool = false;
		boolean result = false;
		for (Word word : words) {
			bool = wordTarget.CreateWord(tableName, word);
		}
		if(bool) {
			result = true;
		}
		return result;
	}
	
	public boolean CreateLanguage(Language language) {
		return langTarget.CreateLanguage(language);
	}
	
	public List<Language> GetLanguages(){
		return langTarget.GetLanguages();
	}

	public Language GetLanguageID(String lang) {
		Language language = new Language(lang);
		return langTarget.GetLanguageID(language);
	}
}
