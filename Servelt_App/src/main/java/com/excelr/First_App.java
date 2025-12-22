package com.excelr;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class First_App
 */
@WebServlet("/First_App")
public class First_App extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		Print in console
		System.out.println("My First Servlet App");
		
//		Set the Content Type
		response.setContentType("text/html"); // Default Content Type is text/html
		
//		Print in web browser
		PrintWriter pw = response.getWriter();
		pw.println("My First Servlet App and Data Print on Browser");
		
	}

}
