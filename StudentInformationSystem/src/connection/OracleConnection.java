package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {
	
		private static final String URL ="jdbc:oracle:thin:@localhost:1521:xe";
		private static final String USER = "hr";
		private static final String PASS = "hr";
		
		public static Connection getConnection() {
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(URL,USER,PASS);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
			
		}
		
		public static void main(String args[]) {
			if(getConnection()!=null) {
				System.out.println("Connected");
			}
			else {
				System.out.println("Not Connected");
			}
			
		}
}
