package com.excelr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded Successfully");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "@123qetuo");
		System.out.println("Connection Established Successfully");
		
		Statement s1 = con.createStatement();
		String res = "select * from java";
		
		ResultSet s2 = s1.executeQuery(res); 
		
		while(s2.next()) {	// used to check the records
			for(int i=1; i<=2; i++)		// used to print the columns (2 columns here)
			{
				System.out.print(s2.getString(i) + " ");
			}
			System.out.println();
		}
		
		con.close();
		System.out.println("Connection Closed Successfully");
	}
	
}
