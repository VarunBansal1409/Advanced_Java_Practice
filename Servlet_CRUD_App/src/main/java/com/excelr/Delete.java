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
 * Servlet implementation class Delete
 */
@WebServlet("/delete")
public class Delete extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // Setting the response content type so browser knows to render HTML
            response.setContentType("text/html");

            // Step 1: Fetch the parameter from the request (sno).
            // This is the unique column used to delete a record.
            int sno = Integer.parseInt(request.getParameter("sno"));

            PrintWriter pw = response.getWriter();

            // Step 2: Load JDBC driver (MySQL 8.x driver)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 3: Establish connection to the database
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbc",
                    "root",
                    "@123qetuo"
            );

            // Step 4: Write the SQL delete query using PreparedStatement
            // '?' placeholder avoids SQL injection
            String query = "DELETE FROM java WHERE sno=?";

            // Step 5: Create PreparedStatement object
            PreparedStatement ps = con.prepareStatement(query);

            // Step 6: Set value inside '?'
            ps.setInt(1, sno);

            // Step 7: Execute the delete query
            int rowsAffected = ps.executeUpdate();

            // Step 8: Give proper response to the user
            if (rowsAffected > 0) {
                pw.println("Data Deleted Successfully");
            } else {
                pw.println("No record found with the given SNO");
            }

            pw.println("<br><a href='home.html'>Go to Home Page</a>");

            // Step 9: Close the connection
            con.close();

        } catch (Exception e) {
            // Step 10: Handle exceptions properly
            // Print stack trace on console but show friendly message to the user
            e.printStackTrace();
            response.getWriter().println("An error occurred while deleting the data.");
        }

    }
}
