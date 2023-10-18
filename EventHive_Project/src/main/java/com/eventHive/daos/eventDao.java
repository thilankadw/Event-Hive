package com.eventHive.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.eventHive.models.eventModel;
import com.eventHive.utils.dbConnection;

public class eventDao {
	
	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet rs = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static String sql = null;
	private static int resultSetInt;
	static boolean isSuccess = false;
	
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
	
	public static boolean createEvent(String eventName, String eventOrganization, String eventVenue, String eventDistrict, String eventCategory, String eventStartTime, String eventEndTime, String eventStartDate, String eventEndDate, String eventType, String eventPaymentType, String vipPackagePrice, String premiumPackagePrice, String standardPackagePrice, String eventRefundAvailable, String eventVisibility, String eventDescription, String maxParticipants, String imagePath) {

	    try {
	    	connection = dbConnection.getConnection();
	    	
	    	String query = "INSERT INTO events (name, organization, venue, district, category, startdate, enddate, starttime, endtime, enddate, type, payments, visibility, maxparticipants, imglink, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    	preparedStatement = connection.prepareStatement(query);
	    	
            preparedStatement.setString(1, eventName);
            preparedStatement.setString(2, eventOrganization);
            preparedStatement.setString(3, eventVenue);
            preparedStatement.setString(4, eventDistrict);
            preparedStatement.setString(5, eventCategory);
            preparedStatement.setString(6, eventStartTime);
            preparedStatement.setString(7, eventEndTime);
            preparedStatement.setString(8, eventStartDate);
            preparedStatement.setString(9, eventEndDate);
            preparedStatement.setString(10, eventType);
            preparedStatement.setString(11, eventPaymentType);         
            preparedStatement.setString(16, eventVisibility);
            preparedStatement.setString(17, maxParticipants);
            preparedStatement.setString(19, imagePath);    
            preparedStatement.setString(18, eventDescription);
            

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
	
	public static eventModel getEventDetails(String eventID) {
		
		eventModel newEvent = null;
	    
	    try {
	        connection = dbConnection.getConnection();
	        statement = connection.createStatement();
	        String sql = "select * from event where id=" + eventID; // Assuming 'id' is the column name.
	        resultSet = statement.executeQuery(sql);

	        while (resultSet.next()) {
	            int eventId = resultSet.getInt(1);
	            String eventName = resultSet.getString(2);
	            String eventOrganization = resultSet.getString(3);
	            String eventVenue = resultSet.getString(4);
	            String eventDistrict = resultSet.getString(5);
	            String eventCategory = resultSet.getString(6);
	            String eventStartTime = resultSet.getString(7);
	            String eventEndTime = resultSet.getString(8);
	            String eventStartDate = resultSet.getString(9);
	            String eventEndDate = resultSet.getString(10);
	            String eventType = resultSet.getString(11);
	            String eventPaymentType = resultSet.getString(12);
	            String vipPackagePrice = resultSet.getString(13);
	            String premiumPackagePrice = resultSet.getString(14);
	            String standardPackagePrice = resultSet.getString(15);
	            String eventRefundAvailable = resultSet.getString(8);
	            String eventVisibility = resultSet.getString(9);
	            String maxParticipants = resultSet.getString(10);
	            String eventDescription = resultSet.getString(11);
	            String eventImage = resultSet.getString(12);

	            newEvent = new eventModel(eventId, eventName, eventOrganization, eventVenue, eventDistrict, eventCategory, eventStartTime, eventEndTime, eventStartDate, eventEndDate, eventType, eventPaymentType, vipPackagePrice, premiumPackagePrice, standardPackagePrice, eventRefundAvailable, eventVisibility, maxParticipants, eventDescription, eventImage);

	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
		return newEvent;   
	}
	
	/*public static List<eventModel> getAllEvents() {
		
		ArrayList<eventModel> events = new ArrayList<>();
	    
	    try {
	        connection = dbConnection.getConnection();
	        statement = connection.createStatement();
	        String sql = "select * from event"; // Assuming 'id' is the column name.
	        resultSet = statement.executeQuery(sql);

	        while (resultSet.next()) {
	            int eventId = resultSet.getInt(1);
	            String eventName = resultSet.getString(2);
	            String eventOrganization = resultSet.getString(3);
	            String eventVenue = resultSet.getString(4);
	            String eventDistrict = resultSet.getString(5);
	            String eventCategory = resultSet.getString(6);
	            String eventStartTime = resultSet.getString(7);
	            String eventEndTime = resultSet.getString(8);
	            String eventStartDate = resultSet.getString(9);
	            String eventEndDate = resultSet.getString(10);
	            String eventType = resultSet.getString(11);
	            String eventPaymentType = resultSet.getString(12);
	            String vipPackagePrice = resultSet.getString(13);
	            String premiumPackagePrice = resultSet.getString(14);
	            String standardPackagePrice = resultSet.getString(15);
	            String eventRefundAvailable = resultSet.getString(8);
	            String eventVisibility = resultSet.getString(9);
	            String maxParticipants = resultSet.getString(10);
	            String eventDescription = resultSet.getString(11);
	            String eventImage = resultSet.getString(12);

	            eventModel newEvent = new eventModel(eventId, eventName, eventOrganization, eventVenue, eventDistrict, eventCategory, eventStartTime, eventEndTime, eventStartDate, eventEndDate, eventType, eventPaymentType, vipPackagePrice, premiumPackagePrice, standardPackagePrice, eventRefundAvailable, eventVisibility, maxParticipants, eventDescription, eventImage);

	            events.add(newEvent);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
		return Event;   
	}*/

	public static boolean updateEventName(int eventID, String eventName) {
	    
	    try {
	        connection = dbConnection.getConnection();
	        
	        String query = "UPDATE event SET name = ? WHERE id = ?";
	        preparedStatement = connection.prepareStatement(query);
	        
	        preparedStatement.setString(1, eventName);
	        preparedStatement.setInt(2, eventID);
	        
	        int updatedRows = preparedStatement.executeUpdate();
	        isSuccess = updatedRows > 0;
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return isSuccess;
	    
	}
	
	public static boolean updateEventOrganization(int eventID, String eventOrganization) {
	    
	    try {
	        connection = dbConnection.getConnection();
	        
	        String query = "UPDATE event SET organization = ? WHERE id = ?";
	        preparedStatement = connection.prepareStatement(query);
	        
	        preparedStatement.setString(1, eventOrganization);
	        preparedStatement.setInt(2, eventID);
	        
	        int updatedRows = preparedStatement.executeUpdate();
	        isSuccess = updatedRows > 0;
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return isSuccess;
	    
	}
	
	public static boolean updateEventVenue(int eventID, String eventVenue) {
	    
	    try {
	        connection = dbConnection.getConnection();
	        
	        String query = "UPDATE event SET organization = ? WHERE id = ?";
	        preparedStatement = connection.prepareStatement(query);
	        
	        preparedStatement.setString(1, eventVenue);
	        preparedStatement.setInt(2, eventID);
	        
	        int updatedRows = preparedStatement.executeUpdate();
	        isSuccess = updatedRows > 0;
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return isSuccess;
	    
	}
	
	public static boolean updateEventDistrict(int eventID, String eventDistrict) {
	    
	    try {
	        connection = dbConnection.getConnection();
	        
	        String query = "UPDATE event SET organization = ? WHERE id = ?";
	        preparedStatement = connection.prepareStatement(query);
	        
	        preparedStatement.setString(1, eventDistrict);
	        preparedStatement.setInt(2, eventID);
	        
	        int updatedRows = preparedStatement.executeUpdate();
	        isSuccess = updatedRows > 0;
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return isSuccess;
	    
	}
	
	public static boolean updateEventCategory(int eventID, String eventCategory) {
	    
	    try {
	        connection = dbConnection.getConnection();
	        
	        String query = "UPDATE event SET organization = ? WHERE id = ?";
	        preparedStatement = connection.prepareStatement(query);
	        
	        preparedStatement.setString(1, eventCategory);
	        preparedStatement.setInt(2, eventID);
	        
	        int updatedRows = preparedStatement.executeUpdate();
	        isSuccess = updatedRows > 0;
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return isSuccess;
	    
	}
	
	public static boolean updateEventStartTime(int eventID, String eventStartTime) {
	    
	    try {
	        connection = dbConnection.getConnection();
	        
	        String query = "UPDATE event SET organization = ? WHERE id = ?";
	        preparedStatement = connection.prepareStatement(query);
	        
	        preparedStatement.setString(1, eventStartTime);
	        preparedStatement.setInt(2, eventID);
	        
	        int updatedRows = preparedStatement.executeUpdate();
	        isSuccess = updatedRows > 0;
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return isSuccess;
	    
	}
	
	public static boolean updateEventEndTime(int eventID, String eventEndTime) {
	    
	    try {
	        connection = dbConnection.getConnection();
	        
	        String query = "UPDATE event SET organization = ? WHERE id = ?";
	        preparedStatement = connection.prepareStatement(query);
	        
	        preparedStatement.setString(1, eventEndTime);
	        preparedStatement.setInt(2, eventID);
	        
	        int updatedRows = preparedStatement.executeUpdate();
	        isSuccess = updatedRows > 0;
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return isSuccess;
	    
	}
	
	public static boolean updateEventStartDate(int eventID, String eventStartDate) {
	    
	    try {
	        connection = dbConnection.getConnection();
	        
	        String query = "UPDATE event SET organization = ? WHERE id = ?";
	        preparedStatement = connection.prepareStatement(query);
	        
	        preparedStatement.setString(1, eventStartDate);
	        preparedStatement.setInt(2, eventID);
	        
	        int updatedRows = preparedStatement.executeUpdate();
	        isSuccess = updatedRows > 0;
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return isSuccess;
	    
	}
	
	public static boolean updateEventEndDate(int eventID, String eventEndDate) {
	    
	    try {
	        connection = dbConnection.getConnection();
	        
	        String query = "UPDATE event SET organization = ? WHERE id = ?";
	        preparedStatement = connection.prepareStatement(query);
	        
	        preparedStatement.setString(1, eventEndDate);
	        preparedStatement.setInt(2, eventID);
	        
	        int updatedRows = preparedStatement.executeUpdate();
	        isSuccess = updatedRows > 0;
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return isSuccess;
	    
	}

	public static void deleteEvent(int eventID) {
		
	    try {
	        connection = dbConnection.getConnection();
	        
	        String query = "DELETE FROM event WHERE id = ?";
	        preparedStatement = connection.prepareStatement(query);
	        
	        preparedStatement.setInt(1, eventID);
	        
	        int updatedRows = preparedStatement.executeUpdate();  
	        isSuccess = updatedRows > 0;
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	}

	

}

