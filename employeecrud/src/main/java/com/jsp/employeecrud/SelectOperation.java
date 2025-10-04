package com.jsp.employeecrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectOperation {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/employeecrud";
		String user = "postgres";
		String password = "Umesh123";
		
		try(Connection con = DriverManager.getConnection(url, user, password); Scanner sc = new Scanner(System.in);) 
		{
			String query = "SELECT * FROM employee";
			PreparedStatement st = con.prepareStatement(query);
			
			boolean ex = st.execute();
			System.out.println(ex);
			
			ResultSet rs = st.getResultSet();
			
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				String designation = rs.getString(4);
				String company = rs.getString(5);
				
				System.out.println("Id :"+ id + " name :"+ name +" Age :"+ age+ " designation :"+ designation + " Comapny :"+ company);
				
			}

			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
