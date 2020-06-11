package lingo.lingowords.presentation;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import lingo.lingowords.application.WordsProcessor;
import lingo.lingowords.domain.Language;
import lingo.lingowords.domain.Word;

public class CommandLine {
	private static WordsProcessor processor = new WordsProcessor();
	private static List<Language> languages = new ArrayList<Language>();
	private static File wordsTxt = new File("src/main/resources/testWords.txt");

	public static void main(String[] args) {
		mainCommandLine();
	}

	public static void mainCommandLine() {
		Scanner scanner = new Scanner(System.in);
		boolean validData = true;
		String input = "";

		System.out.println("Welcome to Lingowords!");
		System.out.println("Enter quit to quit te application or help for help commands!");

		while (validData) {
			try {
				input = scanner.next();
			} catch (InputMismatchException ex) {
				System.out.println(ex.getMessage());
			}

			if (input.compareToIgnoreCase(" ") == 0 || input.compareToIgnoreCase("quit") == 0) {
				validData = false;
			}
			if (input.compareToIgnoreCase("help") == 0) {
				help();
			}
			if (input.compareToIgnoreCase("getLang") == 0) {
				getAllLanguages();
			}
			if (input.compareToIgnoreCase("addLang") == 0) {
				validData = false;
				addLangCommandLine();
			}
			if (input.compareToIgnoreCase("run") == 0) {
				validData = false;
				runCommandLine();
			}
		}
		scanner.close();
	}

	public static void help() {
		System.out.println("run : Use this command to read a file and write all words to the database.");
		System.out.println("getLang : Use this command to show all languages.");
		System.out.println("addLang : Use this command to add additional languages.");
	}

	public static void runCommandLine() {
		System.out.println("Please enter a registered language to start reading the file and write all words "
				+ "that reach the Lingo requirements to the database.");
		System.out.println("Enter quit to go back to main menu");
		getAllLanguages();
		Scanner scanner = new Scanner(System.in);
		String languagestr = scanner.nextLine();
		if (languagestr.compareToIgnoreCase("quit") == 0) {
			mainCommandLine();
		} else {
				if(processor.containsName(languages, languagestr)) {
					Language language = processor.getLanguageID(languagestr);
					Map<String, Set<Word>> words = processor.readFile(wordsTxt, language);
					System.out.println("File readed, all selected words are now going to be written in the database"
							+ ", this can take a moment please be patient.");
					boolean result = processor.getSetsFromMap(words);
					if(result) {
						System.out.println("Finished writing words to database!");
					}else {
						System.out.println("Failed to write words to database, please try again later.");
					}
					mainCommandLine();
				}else {
					System.out.println("Language " + languagestr + " is not registered, please register the language first or enter a language again");
					languagestr = scanner.nextLine();
			}
		}
		scanner.close();
	}

	public static void addLangCommandLine() {
		System.out.println("Please enter the name of the language you would like to add in English or "
				+ "enter quit to go back to main menu.");
		Scanner scanner = new Scanner(System.in);
		String language = scanner.nextLine();
		if (language.compareToIgnoreCase("quit") == 0) {
			mainCommandLine();
		} else {
			Language lang = new Language(language);
			boolean result = addLanguage(lang);
			if (result) {
				System.out.println("Language " + language + " is succesfully added!");
				mainCommandLine();
			} else {
				addLangCommandLine();
			}
		}
		scanner.close();
	}

	public static void getAllLanguages() {
		languages = processor.getLanguages();
		String langString = "The following languages are registered: ";
		for (Language lang : languages) {
			langString += lang.getLanguage() + ", ";
		}
		System.out.println(langString);
	}

	public static boolean addLanguage(Language language) {
		boolean result = processor.createLanguage(language);
		return result;
	}
}