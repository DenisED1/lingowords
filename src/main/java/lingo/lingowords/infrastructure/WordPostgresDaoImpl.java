package lingo.lingowords.infrastructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import lingo.lingowords.domain.Word;

public class WordPostgresDaoImpl extends PostgresBaseDao implements WordDao {
	public boolean CreateWord(String table, Word word) {
		boolean result = false;
		try (Connection con = super.getConnection()) {
			String query = String.format("insert into %s (word, langid) values(?, ?)", table);
			PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, word.getWord());
			pstmt.setInt(2, word.getLanguage().getLangid());
			pstmt.execute();

			result = true;

		} catch (SQLException sqle) {
			//sqle.printStackTrace();
		}

		return result;
	}
}
