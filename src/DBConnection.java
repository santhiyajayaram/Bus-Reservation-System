import java.sql.*;

public class DBConnection {
	private static final String url = "jdbc:mysql://localhost:3306/busresv";
	private static final String username = "root";
	private static final String password = "san123";
	
	static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}
