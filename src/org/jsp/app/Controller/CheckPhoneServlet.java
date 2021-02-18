package org.jsp.app.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.jsp.app.Model.Service.CheckService;
@WebServlet("/View/CheckPhoneServlet")
public class CheckPhoneServlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String phone=req.getParameter("ph");
		
		if(CheckService.checkService(phone))
		{
			RequestDispatcher rd=req.getRequestDispatcher("Forgot.html");
			rd.include(req, res);
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("CheckPhone.html");
			rd.include(req, res);
		}
	}
	
}
