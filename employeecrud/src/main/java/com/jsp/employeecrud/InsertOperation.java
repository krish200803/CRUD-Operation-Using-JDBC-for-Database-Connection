package com.jsp.employeecrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertOperation {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/employeecrud";
		String user = "postgres";
		String password = "Umesh123";
		
		try(Connection con = DriverManager.getConnection(url, user, password); Scanner sc = new Scanner(System.in);) 
		{
			String query = "INSERT INTO employee VALUES (?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			
			System.out.println("Enter the times that you want to Enter Data");
			int count = sc.nextInt();
			
			for(int i=1;i<=count;i++)
			{
				System.out.println("Enter the ID :");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the Name :");
				String name = sc.nextLine();
				System.out.println("Enter the Age :");
				int age = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the Designation :");
				String designation = sc.nextLine();
				System.out.println("Enter the Company Name :");
				String company = sc.nextLine();
				
				st.setInt(1, id);
				st.setString(2, name);
				st.setInt(3, age);
				st.setString(4, designation);
				st.setString(5, company);
				
				st.execute();
				System.out.println(i+ " Data Inserted.....");
			}
			
			
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
