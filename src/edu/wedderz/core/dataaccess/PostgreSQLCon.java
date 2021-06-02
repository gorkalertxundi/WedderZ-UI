package edu.wedderz.core.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQLCon {

	static Connection connection;
	static Statement statement;
	
	public static final String TEST_QUERY = "SELECT * FROM wedderz.users WHERE 1 = 0";

	public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(System.getenv("DBURL"), System.getenv("DB_USERNAME"), System.getenv("DB_PASSWORD"));
        }
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery(TEST_QUERY);
        } catch (Exception e) {
            connection = DriverManager.getConnection(System.getenv("DBURL"), System.getenv("DB_USERNAME"), System.getenv("DB_PASSWORD"));
        }
        return connection;
    }

	public static void closeConnection() {
		try {
			statement.close();
			connection.close();
		} catch (Exception e) {
		}
	}

	/*public static StatusCode exceptionHandler(Exception e) {
		e.printStackTrace();
		if (e instanceof JSONException) {
			spark.Spark.halt(400, "400 BAD REQUEST");
			return StatusCode.BAD_REQUEST;
		} else if (e instanceof PSQLException) {
			spark.Spark.halt(409, "409 CONFLICT");
			return StatusCode.USER_DUPLICATED;
		} else {
			spark.Spark.halt(500, "500 INTERNAL SERVER ERROR");
			return StatusCode.SERVER_ERROR;
		}
	}

	public static JSONObject statusMessage(StatusCode s) {
		return new JSONObject().put("status", s);
	}
	
	*/
}
