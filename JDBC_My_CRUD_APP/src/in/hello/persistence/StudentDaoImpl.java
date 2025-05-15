package in.hello.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.hello.Util.JdbcUtil;
import in.hello.dto.Student;

public class StudentDaoImpl implements StudentDao {

	Connection connection=null;
	Statement statement=null;
	Student std;
	ResultSet resultSet=null;
	@Override
	public String createStudent(String name, Integer age, String addr) {

	
		try {
		connection = JdbcUtil.getConnection();
		if(connection!=null) {
		 statement = connection.createStatement();
		}
		if (statement != null) {
	       int rowCount = statement.executeUpdate("insert into student(`sname`,`sage`,`saddr`) values('"+name+"',"+age+",'"+addr+"')");
	       if(rowCount==1) {
	    	   return "success";
	       }
	       else {
	    	   return "failure";
	       }
	     
			
		}
		}
		catch(SQLException | IOException e) {
			e.printStackTrace();
		}
		
		
		return "failure";
	}

	@Override
	public Student readStudent(Integer id) {
		try {
			String sqlQuery="select sid,sname,sage,saddr from student where sid="+id;
		     connection = JdbcUtil.getConnection();
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			std=new Student();
			if(resultSet.next()) {
				
				std.setId(resultSet.getInt(1));
				std.setName(resultSet.getString(2));
				std.setAge(resultSet.getInt(3));
				std.setAddress(resultSet.getString(4));
				return std;
			}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String updateStudent(Integer id,String name,Integer age,String addr ) {
		
		try {
			connection = JdbcUtil.getConnection();
			statement = connection.createStatement();
			
			String sqlUpdate = "UPDATE student SET sname = '" + name + "', sage = " + age + ", saddr = '" + addr + "' WHERE sid = " + id;
			int rowCount= statement.executeUpdate(sqlUpdate);
			if(rowCount==1) {
				return "success";
			}
			else {
				return "failure";
			}
			
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		
		return " ";
	}

	@Override
	public String deleteStudent(Integer id) {
		
		try {
			String sqlQuery="delete from student where sid="+id;
			connection = JdbcUtil.getConnection();
			statement = connection.createStatement();
			int rowCount = statement.executeUpdate(sqlQuery);
			if(rowCount==1) {
				return "success";
			}
			else {
				return "recordNotFound";
			}
		
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		return "failure";
	}

}
