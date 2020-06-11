package lingo.lingowords.infrastructure;

import lingo.lingowords.domain.Word;
import lingo.lingowords.domain.WordTarget;

public class DbWordTarget implements WordTarget {
	public boolean CreateWord(String tableName, Word word) {
		WordDao wordDao = new WordPostgresDaoImpl();
		return wordDao.CreateWord(tableName, word);
	}
}
