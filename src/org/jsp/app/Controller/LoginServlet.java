package org.jsp.app.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.jsp.app.Model.Service.LoginService;

@WebServlet("/View/LoginServlet")
public class LoginServlet extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		 String phone=req.getParameter("ph");
		 String password=req.getParameter("pw");
		 PrintWriter printWriter=res.getWriter();
		 String s=LoginService.logService(phone, password);
		 printWriter.println(s);
	}	
}
