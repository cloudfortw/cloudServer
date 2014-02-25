package com.cloud.simple;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatchServlet implements Servlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6413571384269355146L;
	
	public DispatchServlet(){
		super();
	}
	
	public void init(ServletConfig config) throws ServletException{
		
	}
	
	public void doService(ServletRequest request, ServletResponse response) throws ServletException,IOException{
		PrintWriter printWriter = response.getWriter();		
		String str = getString();
		printWriter.write(str);
	}
	
	public String getString(){
		return "<html><br><br><h1>Hello World!</h1></html>";
	}
	
	public void doPost(){
		
	}
	
	
	public void doGet(){
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
