package com.jsp.studentcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadStudentData {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/studentcrud";
		String user = "postgres";
		String password = "Umesh123";
		
		try 
		{			
			Connection con = DriverManager.getConnection(url, user, password);
			
			String query = "SELECT * FROM student";
			PreparedStatement st = con.prepareStatement(query);
			
			st.execute();
			
			ResultSet rs = st.getResultSet();
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				String schoolname = rs.getString(4);
				String address = rs.getString(5);
				
				System.out.println("ID :"+ id +" Name :" + name + " Age :"+ age +" schoolname : "+ schoolname +" address : "+ address);
				
	
			}
			
			con.close();
		    
		} 
		catch (SQLException e) 
		{
		    e.printStackTrace();
		}

	}

}
