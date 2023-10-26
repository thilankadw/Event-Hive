package com.eventHive.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.eventHive.daos.eventDao;
import com.eventHive.daos.userDao;
import com.eventHive.models.eventModel;
import com.eventHive.utils.eventUtils;
import com.eventHive.utils.userUtils;

public class eventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static boolean isSuccess;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("done1");
		HttpSession session = request.getSession(true);
		Integer userId = (Integer) session.getAttribute("userSessionId");
		//System.out.println("done2"+userId);
		int eventId = 0;
		String eventIdStr = request.getParameter("event_id");
		if(eventIdStr != null && ! eventIdStr.isEmpty()) {
			eventId = Integer.parseInt(eventIdStr);
		}	
		//System.out.println("done3");
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
        String vipPackagePriceStr = request.getParameter("vip_package_price");
        String premiumPackagePriceStr = request.getParameter("premium_package_price");
        String standardPackagePriceStr = request.getParameter("standard_package_price");
        String eventRefundAvailable = request.getParameter("event_refund_available");
        String eventVisibility = request.getParameter("event_visibility");
        String maxParticipants = request.getParameter("max_participants");
        String eventDescription = request.getParameter("event_description");          
		Part file = request.getPart("event_image");
		//System.out.println("done4");
		//convert string values to currency values
		BigDecimal vipPackagePrice = null;
		BigDecimal premiumPackagePrice = null;
		BigDecimal standardPackagePrice = null;
		if(vipPackagePriceStr != null && !vipPackagePriceStr.isEmpty()) {
			vipPackagePrice = new BigDecimal(vipPackagePriceStr);
		} 
		if(premiumPackagePriceStr != null && !premiumPackagePriceStr.isEmpty()) {
			premiumPackagePrice = new BigDecimal(premiumPackagePriceStr);
		} 
		if(standardPackagePriceStr != null && !standardPackagePriceStr.isEmpty()) {
			standardPackagePrice = new BigDecimal(standardPackagePriceStr);
		} 
		//System.out.println("done5");
		String imageName = "";
		if (file != null) {
			imageName = file.getSubmittedFileName();
		}
				
		//System.out.println("done6");
		if(request.getParameter("createNewEvent")!=null && eventUtils.saveImageToFolder(file, imageName)) {
			//System.out.println("done");
			try {
				int nextEventId = eventDao.getNextID();
				isSuccess = eventDao.createEvent(nextEventId, eventName, eventOrganization, eventVenue, eventDistrict, eventCategory, eventStartTime, eventEndTime, eventStartDate, eventEndDate, eventType, eventPaymentType, vipPackagePrice, premiumPackagePrice, standardPackagePrice, eventRefundAvailable, eventVisibility, maxParticipants, eventDescription, imageName, userId);
				//System.out.println("done7");
				if(isSuccess) {
					//System.out.println("done8");
					RequestDispatcher dis = request.getRequestDispatcher("eventDetails.jsp?eventId="+nextEventId);
					dis.forward(request, response);
				}else {
					//System.out.println("done9");
					RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
					dis.forward(request, response);
				}
				
				//System.out.println("done10");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			//System.out.println("done11");
		}else if(request.getParameter("addNewTitle")!=null) {
			try {
				isSuccess = eventDao.updateEventName(eventId, eventName);
				
				if(isSuccess) {
					RequestDispatcher dis = request.getRequestDispatcher("userProfile.jsp?userId="+userId);
					dis.forward(request, response);
				}else {
					RequestDispatcher dis = request.getRequestDispatcher("updateEventDetails.jsp?eventId="+eventId);
					dis.forward(request, response);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}else if(request.getParameter("addNewOrganization")!=null) {
			try {
				isSuccess = eventDao.updateEventOrganization(eventId, eventOrganization);
				
				if(isSuccess) {
					RequestDispatcher dis = request.getRequestDispatcher("userProfile.jsp?userId="+userId);
					dis.forward(request, response);
				}else {
					RequestDispatcher dis = request.getRequestDispatcher("updateEventDetails.jsp?eventId="+eventId);
					dis.forward(request, response);
				}
			}catch(Exception e){
				e.printStackTrace();
			}	
		}else if(request.getParameter("addNewLocation")!=null) {
			try {
				isSuccess = eventDao.updateEventLocation(eventId, eventVenue);
				
				if(isSuccess) {
					RequestDispatcher dis = request.getRequestDispatcher("userProfile.jsp?userId="+userId);
					dis.forward(request, response);
				}else {
					RequestDispatcher dis = request.getRequestDispatcher("updateEventDetails.jsp?eventId="+eventId);
					dis.forward(request, response);
				}
			}catch(Exception e){
				e.printStackTrace();
			}	
		}else if(request.getParameter("addNewstartingDate")!=null) {
			try {
				isSuccess = eventDao.updateEventStartDate(eventId, eventStartDate);
				
				if(isSuccess) {
					RequestDispatcher dis = request.getRequestDispatcher("userProfile.jsp?userId="+userId);
					dis.forward(request, response);
				}else {
					RequestDispatcher dis = request.getRequestDispatcher("updateEventDetails.jsp?eventId="+eventId);
					dis.forward(request, response);
				}
			}catch(Exception e){
				e.printStackTrace();
			}	
		}else if(request.getParameter("addNewEndingDate")!=null) {
			try {
				isSuccess = eventDao.updateEventEndDate(eventId, eventEndDate);
				
				if(isSuccess) {
					RequestDispatcher dis = request.getRequestDispatcher("userProfile.jsp?userId="+userId);
					dis.forward(request, response);
				}else {
					RequestDispatcher dis = request.getRequestDispatcher("updateEventDetails.jsp?eventId="+eventId);
					dis.forward(request, response);
				}
			}catch(Exception e){
				e.printStackTrace();
			}	
		}else if(request.getParameter("addNewStartingTime")!=null) {
			try {
				isSuccess = eventDao.updateEventStartTime(eventId, eventStartTime);
				
				if(isSuccess) {
					RequestDispatcher dis = request.getRequestDispatcher("userProfile.jsp?userId="+userId);
					dis.forward(request, response);
				}else {
					RequestDispatcher dis = request.getRequestDispatcher("updateEventDetails.jsp?eventId="+eventId);
					dis.forward(request, response);
				}
			}catch(Exception e){
				e.printStackTrace();
			}	
		}else if(request.getParameter("addNewEndingTime")!=null) {
			try {
				isSuccess = eventDao.updateEventEndTime(eventId, eventEndTime);
				
				if(isSuccess) {
					RequestDispatcher dis = request.getRequestDispatcher("userProfile.jsp?userId="+userId);
					dis.forward(request, response);
				}else {
					RequestDispatcher dis = request.getRequestDispatcher("updateEventDetails.jsp?eventId="+eventId);
					dis.forward(request, response);
				}
			}catch(Exception e){
				e.printStackTrace();
			}	
		}else if(request.getParameter("remove_event-btn") != null) {
			if(eventDao.deleteEvent(eventId)) {
				RequestDispatcher dis = request.getRequestDispatcher("userProfile.jsp");
				dis.forward(request, response);
			}else {
				RequestDispatcher dis = request.getRequestDispatcher("userProfile.jsp");
				dis.forward(request, response);	
			}
		}else if(request.getParameter("update-event-banner-btn")!=null && eventUtils.saveImageToFolder(file, imageName)) {
			try {
				isSuccess = eventDao.updateEventImage(eventId, imageName);
				
				if(isSuccess) {
					RequestDispatcher dis = request.getRequestDispatcher("userProfile.jsp?userId="+userId);
					dis.forward(request, response);
				}else {
					RequestDispatcher dis = request.getRequestDispatcher("updateEventDetails.jsp?eventId="+eventId);
					dis.forward(request, response);
				}
			}catch(Exception e){
				e.printStackTrace();
			}	
		}
    }
}
