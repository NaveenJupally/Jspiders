package org.jsp.app.Model.Service;

import org.jsp.app.Model.DAO.DAO;
import org.jsp.app.Model.DAO.JDBCDao;

public class Helper 
{
	public static DAO helperMethod() 
	{
		DAO d=new JDBCDao();
		return d;
	}
}
