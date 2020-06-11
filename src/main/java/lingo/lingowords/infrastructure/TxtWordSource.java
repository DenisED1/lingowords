package lingo.lingowords.infrastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lingo.lingowords.domain.IWordSource;
import lingo.lingowords.domain.Language;
import lingo.lingowords.domain.Word;
import java.util.*;

public class TxtWordSource implements IWordSource{
	private static String regex = "^[a-z]+$";
	
	public Map<String, Set<Word>> ReadTxtFile(File file, Language language) {
		try {
			Scanner myReader = new Scanner(file);

			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher("");
			while (myReader.hasNextLine()) {
				String word = myReader.nextLine();
				matcher.reset(word);
				if (matcher.matches()) {
					switch (word.length()) {
					case 5:
						Word fiveLetter = new Word(word, language);
						fiveLetterWords.add(fiveLetter);
						break;
					case 6:
						Word sixLetter = new Word(word, language);
						sixLetterWords.add(sixLetter);
						break;
					case 7:
						Word sevenLetter = new Word(word, language);
						sevenLetterWords.add(sevenLetter);
						break;
					}
				}
			}
			wordsMap.put("five_letter_words", fiveLetterWords);
			wordsMap.put("six_letter_words", sixLetterWords);
			wordsMap.put("seven_letter_words", sevenLetterWords);

			myReader.close();
		} catch (

		FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		}
		return wordsMap;
	}
}
