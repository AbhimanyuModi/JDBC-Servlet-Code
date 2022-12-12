package org.Jspider.Load_On_StartUpApp;
import java.io.*;
import javax.servlet.*;
public class Load_On_StartUp extends GenericServlet
{
	public Load_On_StartUp() 
	{
		System.out.println("Servlet object is created");
	}
	@Override
	public void init() throws ServletException
	{
		System.out.println("Servlet object is initialized");
	}
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		String name=req.getParameter("nm");
		String place=req.getParameter("pl");
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
		System.out.println("Closed the costly Resources");
	}

}
