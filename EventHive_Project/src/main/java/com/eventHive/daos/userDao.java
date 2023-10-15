package com.eventHive.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.eventHive.utils.dbConnection;
 
public class userDao {
	
	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet rs = null;

	public static String getUserPassword(String userEmail) {
		
	    String userPassword = null;
	    
	    try {
	    	connection = dbConnection.getConnection();
	        
	        String query = "SELECT password FROM user WHERE email = ?";
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, userEmail);
	        rs = preparedStatement.executeQuery();
	        if (rs.next()) {
	            userPassword = rs.getString("password");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Close resources in reverse order of their creation
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (connection != null) {
	            	connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return userPassword;
	}
	
	
	public static boolean checkEmailExist(String userEmail) {
		
		boolean isExist = false;;
	
	    
	    try {
	    	connection = dbConnection.getConnection();
	        
	        String query = "SELECT * FROM user WHERE email = ?";
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, userEmail);
	        rs = preparedStatement.executeQuery();
	        
	        if (rs.next()) {
	        	isExist = true;;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Close resources in reverse order of their creation
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (connection != null) {
	            	connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		
		return isExist;
	}
	
	public static boolean createUserRecord(String userName, String userEmail, String userPassword) {

	    boolean isSuccess = false;

	    try {
	    	connection = dbConnection.getConnection();
	    	
	        String query = "INSERT INTO user (name, email, password) VALUES (?, ?, ?)";
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, userName);
	        preparedStatement.setString(2, userEmail);
	        preparedStatement.setString(3, userPassword);

	        int rowsInserted = preparedStatement.executeUpdate();

	        if (rowsInserted > 0) {
	            isSuccess = true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Close resources in reverse order of their creation
	        try {
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (connection != null) {
	            	connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return isSuccess;
	}

}
