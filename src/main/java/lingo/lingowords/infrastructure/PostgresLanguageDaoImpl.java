package lingo.lingowords.infrastructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lingo.lingowords.domain.Language;

public class PostgresLanguageDaoImpl extends PostgresBaseDao implements LanguageDao {
	public boolean CreateLanguage(Language language) {
		boolean result = false;
		try (Connection con = super.getConnection()) {
			String query = "insert into Languages (language) values(?)";
			PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, language.getLanguage());
			pstmt.execute();

			result = true;

		} catch (SQLException sqle) {
			// sqle.printStackTrace();
			System.out.println("Failed to add language, please try again later.");
		}

		return result;
	}

	public List<Language> GetLanguages() {
		List<Language> results = new ArrayList<Language>();

		try (Connection con = super.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Languages");
			ResultSet dbResultSet = pstmt.executeQuery();

			while (dbResultSet.next()) {
				int langid = dbResultSet.getInt("langid");
				String language = dbResultSet.getString("language");

				results.add(new Language(langid, language));
			}
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			System.out.println("Failed to get all languages, please try again later.");
		}

		return results;
	}

	public Language GetLanguageID(Language language) {
		try (Connection con = super.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement("SELECT langid FROM Languages WHERE language = ?");
			pstmt.setString(1, language.getLanguage());
			ResultSet dbResultSet = pstmt.executeQuery();

			dbResultSet.next();
			int langid = dbResultSet.getInt("langid");

			language.setLangid(langid);

		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			System.out.println("Failed to get language " + language.getLanguage() + ", please try again later.");
		}
		return language;
	}

}
