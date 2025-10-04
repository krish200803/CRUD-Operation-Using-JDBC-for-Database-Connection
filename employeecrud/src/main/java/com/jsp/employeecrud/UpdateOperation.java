package com.jsp.employeecrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateOperation {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/employeecrud";
		String user = "postgres";
		String password = "Umesh123";
		
		try(Connection con = DriverManager.getConnection(url, user, password); Scanner sc = new Scanner(System.in);) 
		{
		    boolean flag = true;

		    while (flag) {

		        System.out.println("1. Update Name");
		        System.out.println("2. Update Age");
		        System.out.println("3. Update Designation");
		        System.out.println("4. Update Company");
		        System.out.println("5. Exit");
		        System.out.println();
		        System.out.println("Enter the Choice that you want to Update");
		        int choice = sc.nextInt();
		        sc.nextLine();

		        switch (choice) {
		            case 1:
		                String query = "UPDATE employee SET name=? WHERE id=?";
		                PreparedStatement st = con.prepareStatement(query);

		                System.out.println("Enter the ID");
		                int id = sc.nextInt();
		                sc.nextLine();
		                System.out.println("Enter the Name");
		                String name = sc.nextLine();

		                st.setString(1, name);  
		                st.setInt(2, id);       
		                st.executeUpdate();

		                System.out.println("Name Updated.....");
		                break;

		            case 2:
		                String query1 = "UPDATE employee SET age=? WHERE id=?";
		                PreparedStatement st1 = con.prepareStatement(query1);

		                System.out.println("Enter the ID");
		                int id1 = sc.nextInt();
		                System.out.println("Enter the Age");
		                int age = sc.nextInt();

		                st1.setInt(1, age);   
		                st1.setInt(2, id1);   
		                st1.executeUpdate();

		                System.out.println("Age Updated.....");
		                break;

		            case 3:
		                String query2 = "UPDATE employee SET designation=? WHERE id=?";
		                PreparedStatement st2 = con.prepareStatement(query2);

		                System.out.println("Enter the ID");
		                int id2 = sc.nextInt();
		                sc.nextLine();
		                System.out.println("Enter the Designation :");
		                String designation = sc.nextLine();

		                st2.setString(1, designation); 
		                st2.setInt(2, id2);           
		                st2.executeUpdate();

		                System.out.println("School Name Updated.....");
		                break;

		            case 4:
		                String query3 = "UPDATE employee SET company=? WHERE id=?";
		                PreparedStatement st3 = con.prepareStatement(query3);

		                System.out.println("Enter the ID");
		                int id3 = sc.nextInt();
		                sc.nextLine();
		                System.out.println("Enter the Company");
		                String company = sc.nextLine();

		                st3.setString(1, company); 
		                st3.setInt(2, id3);        
		                st3.executeUpdate();

		                System.out.println("Address Updated.....");
		                break;

		            case 5:
		                flag = false;
		                System.out.println("Exiting...");
		                break;

		            default:
		                System.out.println("Invalid choice, try again.");
		        }
		        con.close();
		    }
		} 
		catch (SQLException e) 
		{
		    e.printStackTrace();
		}

	}

}
