package com.excelr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Dynamic_Fetch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded Successfully");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "@123qetuo");
		System.out.println("Connection Established Successfully");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Sno to be Fetched: ");
		int sno = sc.nextInt();
		
		String res = "select * from java where sno = ?";
		PreparedStatement s1 = con.prepareStatement(res);
		s1.setInt(1, sno);
		
		ResultSet s2 = s1.executeQuery(); 
		while(s2.next()) {				// used to check the records
			for(int i=1; i<=2; i++)		// used to print the columns (2 columns here)
			{
				System.out.print(s2.getString(i) + " ");
			}
			System.out.println();
		}
		
		s1.close();
		sc.close();
		con.close();
	}
}