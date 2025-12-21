package com.excelr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Dynamic_Update {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded Successfully");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","@123qetuo");
		System.out.println("Connection Established Successfully");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Sno to be Updated: ");
		int sno = sc.nextInt();
		System.out.println("Enter New Sname: ");
		String sname = sc.next();
		
		String res = "update java set sname = ? where sno = ?";
		
		PreparedStatement s1 = con.prepareStatement(res);
		
		s1.setInt(2, sno);			// 1 and 2 are the column indexes
		s1.setString(1, sname);		// set the values dynamically
		
		s1.execute();
		System.out.println("Data Updated Successfully");
		
		s1.close();
		sc.close();
		con.close();
		System.out.println("Connection Closed Successfully");
		
	}
	
}
