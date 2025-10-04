package com.jsp.devcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class developerUpdateOperation {

	public static void main(String[] args) {
		
		try 
		{
			Class.forName("org.postgresql.Driver");
			
			String url = "jdbc:postgresql://localhost:5432/devcrud";
			String user = "postgres";
			String password = "Umesh123";
			
			Connection con = DriverManager.getConnection(url, user, password);
			
			Statement st = con.createStatement();
			
			String query = "UPDATE developer SET designation='Manager' WHERE id = 103";
			
			st.execute(query);
			
			con.close();
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
