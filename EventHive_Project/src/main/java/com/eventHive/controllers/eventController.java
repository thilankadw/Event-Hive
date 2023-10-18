package com.eventHive.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.eventHive.daos.eventDao;
import com.eventHive.daos.userDao;
import com.eventHive.utils.eventUtils;
import com.eventHive.utils.userUtils;

public class eventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static boolean isSuccess;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int eventId = Integer.parseInt(request.getParameter("event_id"));
		String eventName = request.getParameter("event_name");
        String eventOrganization = request.getParameter("event_organization");
        String eventVenue = request.getParameter("event_venue");
        String eventDistrict = request.getParameter("event_district");
        String eventCategory = request.getParameter("event_category");
        String eventStartTime = request.getParameter("event_start_time");
        String eventEndTime = request.getParameter("event_end_time");
        String eventStartDate = request.getParameter("event_start_date");
        String eventEndDate = request.getParameter("event_end_date");
        String eventType = request.getParameter("event_type");
        String eventPaymentType = request.getParameter("event_payment_type");
        String vipPackagePrice = request.getParameter("vip_package_price");
        String premiumPackagePrice = request.getParameter("premium_package_price");
        String standardPackagePrice = request.getParameter("standard_package_price");
        String eventRefundAvailable = request.getParameter("event_refund_available");
        String eventVisibility = request.getParameter("event_visibility");
        String maxParticipants = request.getParameter("max_participants");
        String eventDescription = request.getParameter("event_description");      	
		Part file = request.getPart("event_image");
		String imageName = file.getSubmittedFileName();
		System.out.println("Image Name : "+imageName);
		
		String imagePath = eventUtils.saveImageToFolder(file, imageName);
		System.out.println("Image Name : "+imagePath);
		
		if(request.getParameter("createNewEvent")!=null) {
			
			try {
				isSuccess = eventDao.createEvent(eventName, eventOrganization, eventVenue, eventDistrict, eventCategory, eventStartTime, eventEndTime, eventStartDate, eventEndDate, eventType, eventPaymentType, vipPackagePrice, premiumPackagePrice, standardPackagePrice, eventRefundAvailable, eventVisibility, maxParticipants, eventDescription, imagePath);
				
				if(isSuccess) {
					RequestDispatcher dis = request.getRequestDispatcher("eventDetails.jsp");
					dis.forward(request, response);
				}else {
					RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
					dis.forward(request, response);
				}
				
				
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			
		}else if(request.getParameter("addNewTitle")!=null) {
			
			try {
				isSuccess = eventDao.updateEventName(eventId, eventName);
				
				if(isSuccess) {
					RequestDispatcher dis = request.getRequestDispatcher("updateEventDetails.jsp?eventId="+eventId);
					dis.forward(request, response);
				}else {
					RequestDispatcher dis = request.getRequestDispatcher("userProfile.jsp");
					dis.forward(request, response);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		

    }

	

     

}
