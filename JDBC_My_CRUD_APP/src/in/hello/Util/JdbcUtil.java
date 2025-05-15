package in.hello.Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {

	
	private JdbcUtil() {
		
	}
	static Connection conn=null;
	public static Connection getConnection() throws SQLException, IOException{
		FileInputStream fis=new FileInputStream("E:\\JDBCFinalPractice\\JDBC_My_CRUD_APP\\application.properties");
		Properties p=new Properties();
		p.load(fis);
		String url=p.getProperty("url");
		String username=p.getProperty("username");
		String password=p.getProperty("password");
		
		conn=DriverManager.getConnection(url,username,password);
		
		return conn;
		
	}
	
	
}
