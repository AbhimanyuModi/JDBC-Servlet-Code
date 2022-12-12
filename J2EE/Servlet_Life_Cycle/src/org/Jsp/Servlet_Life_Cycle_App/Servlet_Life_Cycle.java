package org.Jsp.Servlet_Life_Cycle_App;
import java.io.*;
import javax.servlet.*;
public class Servlet_Life_Cycle extends GenericServlet
{
	public Servlet_Life_Cycle()
	{
		System.out.println("Servlet object is Created");
	}
	@Override
	public void init(ServletConfig config) throws ServletException 
	{
		System.out.println("Servlet object is initialized");
	}
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		//Fetch UI/Form Data
		String name=req.getParameter("nm");
		String place=req.getParameter("pl");
		//Presentation Logic
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='Yellow'>"
				+ "<h1>Student name is "+name+" from "+place+"</h1>"
						+ "</body></html>");
		out.close();
		System.out.println("service() is executed");
	}
	@Override
	public void destroy() 
	{
		System.out.println("Close the costly Resources");
	}
	
}
