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
	static boolean isSuccess = false;
	static boolean isExist = false;

	//return a user's password based on email(for login)
	public static String getUserPassword(String userEmail) {
		
	    String userPassword = null;
	    
	    try {
	    	connection = dbConnection.getConnection();
	        
	        String query = "SELECT password FROM user WHERE email = ?";
	        preparedStatement = connection.prepareStatement(query);
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
	
	//get the next available user id
	public static int getNextID() {
		int id = 0;
		try {
			connection = dbConnection.getConnection();
			
			String query = "SELECT movie_id FROM event ORDER BY id DESC LIMIT 1";		
			preparedStatement = connection.prepareStatement(query);
	        rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				id = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return id+1;
	}

	//check whether email already exits entered by user in registration
	public static boolean checkEmailExist(String userEmail) {
		
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
	
	//user registration function
	public static boolean createUserRecord(String userName, String userEmail, String userPassword) {
		
	    try {
	    	connection = dbConnection.getConnection();
	    	
	        String query = "INSERT INTO user (name, email, password) VALUES (?, ?, ?)";
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, userName);
	        preparedStatement.setString(2, userEmail);
	        preparedStatement.setString(3, userPassword);

	        int rowsInserted = preparedStatement.executeUpdate();

	        isSuccess = rowsInserted > 0;
	        
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
	
	//function for admin to add users
	public static boolean addUserRecord(int userId, String userName, String userEmail, String userPassword, String userRole) {
		
	    try {
	    	connection = dbConnection.getConnection();
	    	
	        String query = "INSERT INTO user (id, name, email, password, role) VALUES (?, ?, ?, ?, ?)";
	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, userId);
	        preparedStatement.setString(2, userName);
	        preparedStatement.setString(3, userEmail);
	        preparedStatement.setString(4, userPassword);
	        preparedStatement.setString(5, userRole);

	        int rowsInserted = preparedStatement.executeUpdate();

	        isSuccess = rowsInserted > 0;
	        
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
	
	//delete user function for admin
	public static void deleteUser(int userID) {
		
	    try {
	        connection = dbConnection.getConnection();
	        
	        String query = "DELETE FROM user WHERE id = ?";
	        preparedStatement = connection.prepareStatement(query);       
	        preparedStatement.setInt(1, userID);
	        
	        int updatedRows = preparedStatement.executeUpdate();  
	        isSuccess = updatedRows > 0;
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	}

}
