package lingo.lingowords.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgresBaseDao {
	protected final Connection getConnection() {
		Connection result = null;

		try {
			result = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Lingo?user=Lingo&password=Lingo1996");
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

		return result;
	}
}
