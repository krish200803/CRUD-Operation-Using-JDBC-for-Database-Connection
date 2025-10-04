package com.jsp.employeecrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class deleteOperation {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/employeecrud";
		String user = "postgres";
		String password = "Umesh123";
		
		try(Connection con = DriverManager.getConnection(url, user, password); Scanner sc = new Scanner(System.in);) 
		{
			String query = "DELETE FROM employee WHERE id = ?";
			PreparedStatement st = con.prepareStatement(query);
			
			System.out.println("Enter the ID that you want to Delete :");
			int id = sc.nextInt();
			
			st.setInt(1, id);
			
			int executeUpdate = st.executeUpdate();
			System.out.println(executeUpdate +" Rows Affected");
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
