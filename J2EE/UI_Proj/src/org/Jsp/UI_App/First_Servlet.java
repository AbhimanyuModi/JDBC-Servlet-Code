package org.Jsp.UI_App;
import java.io.*;
/*import java.io.IOException;
import java.io.PrintWriter;*/
import javax.servlet.*;
/*import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;*/
public class First_Servlet extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		//Fetch UI/Form Data
		String name=req.getParameter("nm");
		String place=req.getParameter("pl");
		//Presentation Logic
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='Yellow'>"+"<h1>Student name is "+name+" from "+place+"</h1>"+"</body></html>");
		out.close();
	}
}
