package com.jsp.devcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class developerInsertOperation {

	public static void main(String[] args) {
		
		try 
		{
			Class.forName("org.postgresql.Driver");
			
			String url = "jdbc:postgresql://localhost:5432/devcrud";
			String user = "postgres";
			String password = "Umesh123";
			
			Connection con = DriverManager.getConnection(url, user, password);
			
			Statement st = con.createStatement();
			
			String query = "INSERT INTO developer VALUES (106,'Manish',21,58983.25,'Frontend Developer')";

			st.execute(query);
			
			con.close();
			
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
