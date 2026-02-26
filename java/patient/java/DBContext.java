package patient.java;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
	 public static Connection getConnection() throws Exception {
	        
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        
	        
	        String url = "jdbc:oracle:thin:@localhost:1521:xe";
	        String user = "system"; 
	        String password = "oracle123"; 
	        
	        return DriverManager.getConnection(url, user, password);
	    }

}
