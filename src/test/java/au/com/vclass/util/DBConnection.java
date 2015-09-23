package au.com.vclass.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.lang.*;

public class DBConnection {
	public static void main(String[] argv){
		System.out.println("-----------MySQL JDBC Connection Testing---------");
		int a = 3;
		String s = "Number ";
		System.out.println("Number "+a);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Finished");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			return;
		}
		Connection conn = null;
		
		try{
			conn = DriverManager.getConnection("jdbc:mysql://192.168.1.23/vclass","root","hels2nk2");
		}catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		if (conn != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from meetings where name = 'AutoTestMeeting'");
			while(rs.next()){
				int meet = rs.getInt("mid");
				System.out.println(meet);
			}
			conn.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
