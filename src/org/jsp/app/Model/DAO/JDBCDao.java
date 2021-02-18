package org.jsp.app.Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCDao implements DAO
{

	@Override
	public String register(String name,String email,String phone,String password,String type,String gender,String confirmpassword) 
	{
        String url="jdbc:mysql://localhost:3306?user=root&password=970483";
		
		String query="insert into test.stu values(?,?,?,?,?,?)";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			
			PreparedStatement preparedStatement =connection.prepareStatement(query);
			
			preparedStatement.setString(1,name);
			preparedStatement.setString(2,email);
			preparedStatement.setString(3,phone);
			
			if(password.equals(confirmpassword))
			{
				preparedStatement.setString(4,password);
				preparedStatement.setString(5,type);
				preparedStatement.setString(6,gender);
				preparedStatement.executeUpdate();
		        return "Registration sucessful";
			}
			else
			{
				connection.close();
				return "password missmatch";
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return "Error in JDBC";
		}
	}
	
	@Override
	public String login(String phone,String password) 
	{
        String url="jdbc:mysql://localhost:3306?user=root&password=970483";
		
		String query="select Name from test.stu where Phone=? and PassWord=?";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			
			PreparedStatement preparedStatement =connection.prepareStatement(query);
			
			preparedStatement.setString(1,phone);
			
			preparedStatement.setString(2,password);
			
			ResultSet resultSet= preparedStatement.executeQuery();
			if(resultSet.next())
			{
				String name=resultSet.getString("Name");
				connection.close();
			    return "Welcome "+name;
			}
			else
			{
				 connection.close();	
				 return "invalid data";
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return "Error in JDBC";
		}
	}

	@Override
	public boolean Check(String phone) 
	{
		    String url="jdbc:mysql://localhost:3306?user=root&password=970483";
	    	String query="select phone from test.stu where Phone=?";
	    	try
	    	{
	    		Class.forName("com.mysql.jdbc.Driver");
	    		Connection connection=DriverManager.getConnection(url);
	    		
	    		PreparedStatement preparedStatement=connection.prepareStatement(query);
	    		
	    		preparedStatement.setString(1,phone);
	    		ResultSet rs=preparedStatement.executeQuery();
	    		if(rs.next())
	    		{
	    			//String ph=rs.getString(phone);
	    			connection.close();
	    			return true;
	    		}
	    		else 
	    			connection.close();
	    			return false;
	    	} 
	    	catch (Exception e)
	    	{
	    		e.printStackTrace();
	    		return false;
	    	}
	}

	@Override
	public String forgot(String password, String confirmpassword) 
	{
		 String url="jdbc:mysql://localhost:3306?user=root&password=970483";
			String query="update test.stu set Password=?";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			
			if(password.equals(confirmpassword))
			{
				preparedStatement.setString(1,password);
				preparedStatement.executeUpdate();
				connection.close();
				return "Successfully Added";
				
			}
			else
			{
				connection.close();
				return "password mismatch";
			}	
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return "JDBC error";
		}
	}	
}