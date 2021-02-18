package org.jsp.app.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.jsp.app.Model.Service.ForgotService;

@WebServlet("/View/ForgotServlet")
public class ForgotServlet extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		 String password=req.getParameter("pw");
		 String confirmpassword=req.getParameter("cpw");
		 PrintWriter printWriter=res.getWriter();
		 String s=ForgotService.forgotService(password, confirmpassword);
		 printWriter.println(s);
	}
}
