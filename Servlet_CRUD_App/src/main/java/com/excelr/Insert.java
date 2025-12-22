package com.excelr;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		SetContentType
		response.setContentType("text/html;charset=UTF-8");

		try(PrintWriter pw = response.getWriter()) //PrintWriter
		{
//			Take input form the form
			int res = Integer.parseInt(request.getParameter("sno"));
			String res1 = request.getParameter("sname");
			
//			Write 5 JDBC Steps	
			
			// Load the class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Establish the Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc" , "root", "@123qetuo");
			
			// Create a query
			PreparedStatement ps = con.prepareStatement("INSERT INTO java (sno, sname) VALUES(?, ?)");
			
			// Set the input data
			ps.setInt(1, res);
			ps.setString(2, res1);
			
			// execute the query
			int count = ps.executeUpdate();
			
			if(count > 0) {
				pw.println("Data Inserted Sucessfully");
			}else {
				pw.println("Data not Inserted");
			}
			
			pw.println("<br><a href='home.html'>Go to Home Page</a>");
			
		} catch (Exception e) {
			 e.printStackTrace(); // Don't hide errors
		}
	}

}
