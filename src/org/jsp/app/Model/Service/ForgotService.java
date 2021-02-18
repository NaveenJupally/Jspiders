package org.jsp.app.Model.Service;

import org.jsp.app.Model.DAO.DAO;

public class ForgotService 
{
	public static String forgotService(String password,String confirmpassword)
	{
		DAO da=Helper.helperMethod();
		String s1=da.forgot(password, confirmpassword);
		return s1;
	}
}
