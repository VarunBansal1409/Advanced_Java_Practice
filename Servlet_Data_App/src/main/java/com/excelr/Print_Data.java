package com.excelr;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Print_Data
 */
@WebServlet("/Print_Data")
public class Print_Data extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		Print the data in console
		System.out.println("Data Printed Successfully");
		
//		Set the content type
		response.setContentType("text/html");
		
//		Create a printwriter class
		PrintWriter pw = response.getWriter();
		
//		take input from form
		String data1 = request.getParameter("uname"); //should be same as tag name in .html
		String data2 = request.getParameter("password");
		
//		print the data on browser
		pw.println("UserName is: " + data1);
		pw.println("Password is: " + data2);
		
	}

}
