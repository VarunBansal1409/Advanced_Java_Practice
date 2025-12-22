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
import java.sql.ResultSet;

/**
 * Servlet implementation class Retrieve
 */
@WebServlet("/retrieve")
public class Retrieve extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // Step 1: Set response type to HTML so browser renders content properly.
            response.setContentType("text/html");

            // Step 2: Fetch the 'sno' parameter from the request.
            // This will help retrieve the exact record the user wants.
            int sno = Integer.parseInt(request.getParameter("sno"));

            // Step 3: Get PrintWriter to display output on the browser.
            PrintWriter pw = response.getWriter();

            // Step 4: Load the MySQL JDBC driver.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 5: Create connection with the database.
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbc",
                    "root",
                    "@123qetuo"
            );

            // Step 6: Prepare SQL SELECT query to fetch details of the given sno.
            String query = "SELECT * FROM java WHERE sno=?";

            // Step 7: Create the PreparedStatement object.
            PreparedStatement ps = con.prepareStatement(query);

            // Step 8: Place the provided sno inside the '?'.
            ps.setInt(1, sno);

            // Step 9: Execute query. ResultSet will store the output (row).
            ResultSet rs = ps.executeQuery();

            // Step 10: Check if a record exists.
            if (rs.next()) {
                // Fetch values from ResultSet by column name or index.
                int fetchedSno = rs.getInt("sno");
                String fetchedName = rs.getString("sname");

                // Step 11: Display retrieved data to the user.
                pw.println("<h2>Record Found:</h2>");
                pw.println("Student Number: " + fetchedSno + "<br>");
                pw.println("Student Name: " + fetchedName + "<br>");
            } else {
                // If no record exists for the given sno
                pw.println("<h3>No record found for the provided SNO</h3>");
            }

            // Step 12: Provide a link back to home page.
            pw.println("<br><a href='home.html'>Go to Home Page</a>");

            // Step 13: Close the connection.
            con.close();

        } catch (Exception e) {
            // Step 14: Exception handling.
            e.printStackTrace();
            response.getWriter().println("An error occurred while retrieving data.");
        }

    }
}
