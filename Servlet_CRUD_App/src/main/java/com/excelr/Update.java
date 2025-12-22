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
 * Servlet implementation class Update
 */
@WebServlet("/update")
public class Update extends HttpServlet {

	protected void service(HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			response.setContentType("text/html");
			
			int res1 = Integer.parseInt(request.getParameter("sno"));
			String res2 = request.getParameter("sname");
			
			PrintWriter pw = response.getWriter();
		
//			JDBC Steps
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "@123qetuo");
			
			String res = "UPDATE java SET sname=? WHERE sno=?";
			
			PreparedStatement ps = con.prepareStatement(res);
			
			ps.setString(1, res2);
			ps.setInt(2, res1);
			
			ps.executeUpdate();
			
			pw.println("Data Updated Successfully");
			
			pw.println("<br><a href='home.html'>Go to Home Page</a>");
			
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
