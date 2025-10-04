package com.jsp.devcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.Driver;

public class developerSelectOperation {

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
			
			String query = "SELECT * FROM developer";
			
			boolean execute = st.execute(query);
			System.out.println("execute :"+execute);
			
			ResultSet rs = st.getResultSet();
			
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				double salary = rs.getDouble(4);
				String design = rs.getString(5);
				
				System.out.println("Id : "+ id +" Name :"+ name + " Age : "+ age + " Salary :"+ salary + " Designation : "+ design);
				
			}

			
			con.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
