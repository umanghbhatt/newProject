package POM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class BaseDAO {
	


		protected static Connection conn; //once
		
		static  {
			try {
				DriverManager.registerDriver( new OracleDriver());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public BaseDAO() {
			if(conn==null) {
				try {
					conn= DriverManager.getConnection("https://www.easemytrip.com/");
					
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			}
		}
		final public static void closeConnection() {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

