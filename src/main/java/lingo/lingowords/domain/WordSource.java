package lingo.lingowords.domain;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public interface WordSource {
	Set<Word> words = new HashSet<Word>();
	
	Set<Word> readTxtFile(File file, Language language);
}
