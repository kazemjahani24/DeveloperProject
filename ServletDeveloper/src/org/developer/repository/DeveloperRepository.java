package org.developer.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.developer.model.Developer;
import org.developer.util.DBUtil;

public class DeveloperRepository {

	public static void delete(int id) {

		String sqlUpdate = " delete from developer where id = ? "; 
		
		try {

			Connection con = DBUtil.getConnection();
			PreparedStatement preparedStmt = con.prepareStatement(sqlUpdate);
			
			preparedStmt.setInt(1, id);
			
		    int row = preparedStmt.executeUpdate();
		    System.out.println("number of rows deleted: "+row);
		    
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static Developer update(Developer developer) {

		String sqlUpdate = " update developer SET "
			                + " name = ?, position = ?, task = ?, dob = ?, father_name = ?, email = ? "
			                + " where id = ? "; 
		
		try {

			Connection con = DBUtil.getConnection();
			PreparedStatement preparedStmt = con.prepareStatement(sqlUpdate);
			
			preparedStmt.setInt(7, developer.getId());
			
			java.util.Date juDate = developer.getDob();						//getting java.util.Date
			java.sql.Date sqlDate = null;
			
			if(juDate!=null) {
				sqlDate = new java.sql.Date(juDate.getTime());	//convert java.util.Date to java.sql.Date
			}
			
			preparedStmt.setString (1, developer.getName());
		    preparedStmt.setString (2, developer.getPosition());
		    preparedStmt.setString(3, developer.getTask());
		    preparedStmt.setDate(4, sqlDate);
		    preparedStmt.setString(5, developer.getFatherName());
		    preparedStmt.setString(6, developer.getEmail());
		    
		    int row = preparedStmt.executeUpdate();
		    System.out.println("number of rows updated: "+row);
		    
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public static Developer findById(int id) {
		
		Developer developer = new Developer();

		try {

			Connection con = DBUtil.getConnection();
			
			PreparedStatement statement = con.prepareStatement(" select * from developer where id = ? ");
			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();

			if (rs != null) {
				if (rs.next()) {
					
					developer.setId(rs.getInt(1));
					developer.setName(rs.getString(2));
					developer.setPosition(rs.getString(3));
					developer.setTask(rs.getString(4));
					
					java.sql.Date sqlDate = rs.getDate(5);							//get java.util.Date from result set object
					if(sqlDate!=null) {
						java.util.Date juDate = new java.util.Date(sqlDate.getTime());	//conversion from java.util.Date to java.sql.Date
						developer.setDob(juDate);
					}
					developer.setFatherName(rs.getString(6));
					developer.setEmail(rs.getString(7));
					
				}
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return developer;
		
	}
	
	public static Developer addDeveloper(Developer developer) {
		
		try {

			Connection con = DBUtil.getConnection();
			
			String query = " insert into developer ( name, position, task, dob, father_name, email ) values (?, ?, ?, ?, ?, ?) ";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
		
			java.util.Date juDate = developer.getDob();						//getting java.util.Date
			java.sql.Date sqlDate = null;
			
			if(juDate!=null) {
				sqlDate = new java.sql.Date(juDate.getTime());	//convert java.util.Date to java.sql.Date
			}
			
			preparedStmt.setString (1, developer.getName());
		    preparedStmt.setString (2, developer.getPosition());
		    preparedStmt.setString(3, developer.getTask());
		    preparedStmt.setDate(4, sqlDate);
		    preparedStmt.setString(5, developer.getFatherName());
		    preparedStmt.setString(6, developer.getEmail());
		    preparedStmt.execute();
		
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return developer;
	}

	
	public static List<Developer> findAll(){
		
		List<Developer> developerList = new ArrayList<>();

		try {

			Connection con = DBUtil.getConnection();

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(" select * from developer ");

			if (rs != null) {
				while (rs.next()) {
					Developer developer = new Developer();
					developer.setId(rs.getInt(1));
					developer.setName(rs.getString(2));
					developerList.add(developer);
				}
			}
			
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return developerList;
	}
}
