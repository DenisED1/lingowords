package lingo.lingowords.infrastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lingo.lingowords.domain.WordSource;
import lingo.lingowords.domain.Language;
import lingo.lingowords.domain.Word;
import java.util.*;

public class TxtWordSource implements WordSource{
	private static String regex = "^[a-z]+$";
	
	public Set<Word> readTxtFile(File file, Language language) {
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
						Word fiveLetter = new Word(word, 5, language);
						words.add(fiveLetter);
						break;
					case 6:
						Word sixLetter = new Word(word, 6, language);
						words.add(sixLetter);
						break;
					case 7:
						Word sevenLetter = new Word(word, 7, language);
						words.add(sevenLetter);
						break;
					}
				}
			}

			myReader.close();
		} catch (

		FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		}
		return words;
	}
}
