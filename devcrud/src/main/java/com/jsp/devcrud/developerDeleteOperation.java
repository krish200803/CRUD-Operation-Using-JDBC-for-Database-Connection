package com.jsp.devcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.Driver;

public class developerDeleteOperation {

	public static void main(String[] args) {
		
		Driver driver = new Driver();
		
		try 
		{
			DriverManager.registerDriver(driver);
			
			String url = "jdbc:postgresql://localhost:5432/devcrud";
			String user = "postgres";
			String password = "Umesh123";
			
			Connection con = DriverManager.getConnection(url, user, password);
			
			System.out.println(con);
			
			Statement st = con.createStatement();
			
			String query = "DELETE FROM developer WHERE id = 102";
			
			st.execute(query);
			
			con.close();
			
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
