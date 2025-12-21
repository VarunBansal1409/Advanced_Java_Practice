package com.excelr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Dynamic_Delete {

	public static void main(String[] args){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Successfully");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","@123qetuo");
			System.out.println("Connection Established Successfully");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Sno to be Deleted: ");
			int sno = sc.nextInt();
			
			String res = "delete from java where sno = ?";
			PreparedStatement s1 = con.prepareStatement(res);
			s1.setInt(1, sno);	
			
			s1.execute();
			System.out.println("Data Updated Successfully");
			
			s1.close();
			sc.close();
			con.close();
			System.out.println("Connection Closed Successfully");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
