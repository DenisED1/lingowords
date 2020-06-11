package lingo.lingowords.infrastructure;

import lingo.lingowords.domain.Word;

public interface WordDao {
	boolean createWord(Word word);
}
