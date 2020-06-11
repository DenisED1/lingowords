package lingo.lingowords.domain;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public interface IWordSource {
	Set<Word> fiveLetterWords = new HashSet<Word>();
	Set<Word> sixLetterWords = new HashSet<Word>();
	Set<Word> sevenLetterWords = new HashSet<Word>();
	Map<String, Set<Word>> wordsMap = new HashMap<String, Set<Word>>();
	
	Map<String, Set<Word>> readTxtFile(File file, Language language);
}
