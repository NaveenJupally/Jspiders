package org.jsp.app.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.jsp.app.Model.Service.RegisterService;
@WebServlet("/View/RegisterServlet")
public class RegisterServlet extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String name=req.getParameter("na");
		 String email=req.getParameter("em");
		 String phone=req.getParameter("ph");
		 String password=req.getParameter("pw");
		 String confirmpassword=req.getParameter("cpw");
		 String type=req.getParameter("gt");
		 String gender=req.getParameter("gn");
		 
		 String s1=RegisterService.regservice(name, email, phone, password, type, gender, confirmpassword);
		 PrintWriter printWriter=res.getWriter();
		 printWriter.println(s1);
	}
}
