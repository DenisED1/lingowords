package lingo.lingowords.infrastructure;

import lingo.lingowords.domain.Word;

public interface WordDao {
	boolean CreateWord(String table, Word word);
}
