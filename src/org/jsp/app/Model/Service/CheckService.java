package org.jsp.app.Model.Service;

import org.jsp.app.Model.DAO.DAO;

public class CheckService 
{
	public static boolean checkService(String phone)
	{
		DAO da=Helper.helperMethod();
		boolean s1=da.Check(phone);
		return s1;
	}
}
