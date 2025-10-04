package com.jsp.studentcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertStudentCrud {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/studentcrud";
		String user = "postgres";
		String password = "Umesh123";
		
		try 
		{
			Connection con = DriverManager.getConnection(url, user, password);
			
			String query = "INSERT INTO student VALUES(?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Times want to Insert the Data");
			int count = sc.nextInt();
			
			for(int i=1;i<=count;i++)
			{
				System.out.println("Enter the Student ID");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the Student Name");
				String name = sc.nextLine();
				System.out.println("Enter the Student Age");
				int age = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the School name");
				String schoolname = sc.nextLine();
				System.out.println("Enter the Address");
				String address = sc.nextLine();
				
				st.setInt(1, id);
				st.setString(2, name);
				st.setInt(3, age);
				st.setString(4, schoolname);
				st.setString(5, address);
				
				st.execute();
				System.out.println(i + " Data Inserted");
				
			}
			
			con.close();
					
			
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
