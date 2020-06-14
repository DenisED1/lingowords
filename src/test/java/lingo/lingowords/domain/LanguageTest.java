package lingo.lingowords.domain;

import org.junit.jupiter.api.*;

@DisplayName("Language")
public class LanguageTest {
	private final int langid = 1;
	private final String langstr = "Netherlands";
	private Language language;
	
	@BeforeEach
	public void setUp() {
		language = new Language(langid, langstr);
	}
	
	@Test
	@DisplayName("gives the langid")
	public void getLangid() {
		Assertions.assertEquals(langid, language.getLangid());
	}
	
	@Test
	@DisplayName("gives the languagestring")
	public void getLanguage() {
		Assertions.assertEquals(langstr, language.getLanguage());
	}
}
