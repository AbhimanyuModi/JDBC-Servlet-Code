package org.Jspider.Load_On_ServletApp;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
@WebServlet(urlPatterns = "/fs",loadOnStartup = 2)
public class Load_On_Servlet extends GenericServlet
{
	public Load_On_Servlet() 
	{
		System.out.println("Servlet object is created");
	}
	@Override
	public void init(ServletConfig config) throws ServletException 
	{
		System.out.println("Servlet oblect is initialized");
	}
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		String name=req.getParameter("nm");
		String place=req.getParameter("pl");
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='Yellow'>"
				+ "<h1>Welcome to "+name+" from "+place+"</h1>"
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
