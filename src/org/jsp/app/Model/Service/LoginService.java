package org.jsp.app.Model.Service;

import org.jsp.app.Model.DAO.DAO;

public class LoginService 
{
	public static String logService(String phone,String password)
	{
		DAO da=Helper.helperMethod();
		String s1=da.login(phone, password);
		return s1;
	}
}
