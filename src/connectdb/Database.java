package connectdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Database {
	public Connection con=null;
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/storage?"
    		+ "useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    static final String USER="root";
    static final String PASS="123456";
	public Connection getcon() {
		try {
    	Class.forName(JDBC_DRIVER);
    	con=DriverManager.getConnection(DB_URL, USER, PASS);
    	}catch(ClassNotFoundException e){
    		e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
