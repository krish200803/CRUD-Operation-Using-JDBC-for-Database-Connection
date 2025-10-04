package com.jsp.studentcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteStudentCrud {

	public static void main(String[] args) {


		String url = "jdbc:postgresql://localhost:5432/studentcrud";
		String user = "postgres";
		String password = "Umesh123";
		
		try 
		{			
			Connection con = DriverManager.getConnection(url, user, password);
			
			String query = "DELETE FROM student WHERE id=? ";
			PreparedStatement st = con.prepareStatement(query);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the ID that You want to DELETE");
			int id = sc.nextInt();
			
			st.setInt(1, id);
			
			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) 
			{
			    System.out.println("Record deleted successfully.");
			} 
			else 
			{
			    System.out.println("No record found with ID: " + id);
			}
			
			con.close();
		    
		} 
		catch (SQLException e) 
		{
		    e.printStackTrace();
		}

	}

}
