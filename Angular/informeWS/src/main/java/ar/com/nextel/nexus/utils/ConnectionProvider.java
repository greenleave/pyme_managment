package ar.com.nextel.nexus.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	private static ConnectionProvider instance;

	public static ConnectionProvider getInstance() {
		if (instance == null) {
			instance = new ConnectionProvider();
		}
		return instance;
	}

	private ConnectionProvider() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:oracle:thin:@bashpapp.nextel.com.ar:1571:NEXUSD3",
				"nxsadm", "nxsadm");
	}

}
