package com.excelr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Dynamic_Insert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		Load the class
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded Successfully");
		
//		Create / Establish the connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","@123qetuo");
		System.out.println("Connection Established Successfully");
		
//		Create object for scanner class to take input from user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Sno in Digits: ");
		int sno = sc.nextInt();
		System.out.println("Enter Sname in String: ");
		String sname = sc.next();
		
//		Create a query statement		
		String res = "insert into java values(? , ?)";
		
		PreparedStatement s1 = con.prepareStatement(res);
		s1.setInt(1, sno);			// 1 and 2 are the column indexes
		s1.setString(2, sname);		// set the values dynamically
		
		
//		Execute the query
		s1.execute();
		System.out.println("Data Inserted Successfully");
		
//		Close all the connections
		s1.close();
		sc.close();
		con.close();
		System.out.println("Connection Closed Successfully");
		
	}
	
}
