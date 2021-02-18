package org.jsp.app.Model.DAO;

public interface DAO 
{
	public String register(String name,String email,String phone,String password,String type,String gender,String confirmpassword);
	public String login(String phone,String password);
	boolean Check(String phone);
	public String forgot(String password,String confirmpassword);
}
