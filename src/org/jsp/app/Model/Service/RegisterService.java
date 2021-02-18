package org.jsp.app.Model.Service;

import org.jsp.app.Model.DAO.DAO;

public class RegisterService 
{
	public static String regservice(String name,String email,String phone,String password,String type,String gender,String confirmpassword)
	{
		DAO da=Helper.helperMethod();
		String s=da.register(name, email, phone, password, type, gender, confirmpassword);
		return s;
	}
}
