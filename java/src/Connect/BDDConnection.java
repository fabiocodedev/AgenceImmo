package Connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class BDDConnection {
	
	
	 public static Connection getConnect() {
	        Connection connect = null;

	        String url = "jdbc:mysql://localhost/";
	        String dbName = "cdaimmo";
	        String user = "root";
	        String password = "";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connect = DriverManager.getConnection(url+dbName,user,password);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return connect;
	    }
	

}
