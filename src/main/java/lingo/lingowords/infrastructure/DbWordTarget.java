package lingo.lingowords.infrastructure;

import lingo.lingowords.domain.Word;
import lingo.lingowords.domain.WordTarget;

public class DbWordTarget implements WordTarget {
	public boolean createWord(Word word) {
		WordDao wordDao = new WordPostgresDaoImpl();
		return wordDao.createWord(word);
	}
}
