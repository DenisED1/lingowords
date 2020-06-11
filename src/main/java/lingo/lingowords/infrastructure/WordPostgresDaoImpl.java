package lingo.lingowords.infrastructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import lingo.lingowords.domain.Word;

public class WordPostgresDaoImpl extends PostgresBaseDao implements WordDao {
	public boolean createWord(Word word) {
		boolean result = false;
		try (Connection con = super.getConnection()) {
			String query = "INSERT INTO Words (word, length, langid) VALUES(?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, word.getWord());
			pstmt.setInt(2, word.getLength());
			pstmt.setInt(3, word.getLanguage().getLangid());
			pstmt.execute();

			result = true;

		} catch (SQLException sqle) {
			// sqle.printStackTrace();
		}

		return result;
	}
}
