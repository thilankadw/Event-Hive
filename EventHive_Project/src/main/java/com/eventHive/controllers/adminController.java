package com.eventHive.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.eventHive.daos.eventDao;
import com.eventHive.daos.ticketDao;
import com.eventHive.daos.userDao;

public class adminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("user_name");
		String userEmail = request.getParameter("user_email");
		String userPassword = (String)request.getParameter("user_password");
		String userRole = request.getParameter("user_role");
		
		int ticketId = 0;
		int eventId = 0;
		if(request.getParameter("ticketId") != null) {
			ticketId = Integer.parseInt(request.getParameter("ticketId"));
		}if(request.getParameter("eventId") != null) {
			eventId = Integer.parseInt(request.getParameter("eventId"));
		}
		
		boolean isSuccess = false;
		
		if(request.getParameter("admin-add-user-btn") != null) {
			if(userDao.addUserRecord(userDao.getNextID(), userName, userEmail, userPassword, userRole)) {			
				RequestDispatcher dis = request.getRequestDispatcher("adminDashboard.jsp");
				dis.forward(request, response);			
			}
		}else if(request.getParameter("admin_delete_user") != null) {
			if(!userEmail.isEmpty()) {
				int userId = userDao.getUserIdFromEmail(userEmail);
				
				if(userDao.deleteUser(userId)) {
					RequestDispatcher dis = request.getRequestDispatcher("adminDashboard.jsp");
					dis.forward(request, response);	
				}else {
					RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
					dis.forward(request, response);	
				}
			}else if(!userName.isEmpty()) {
				int userId = userDao.getUserIdFromName(userName);
				
				if(userDao.deleteUser(userId)) {
					RequestDispatcher dis = request.getRequestDispatcher("adminDashboard.jsp");
					dis.forward(request, response);	
				}else {
					RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
					dis.forward(request, response);	
				}
			}
		}else if(request.getParameter("admin_remove_ticket-btn") != null) {
			if(ticketDao.deleteTicket(ticketId)) {
				RequestDispatcher dis = request.getRequestDispatcher("adminDashboard.jsp");
				dis.forward(request, response);
			}else {
				RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
				dis.forward(request, response);	
			}
		}else if(request.getParameter("admin_remove_event-btn") != null) {
			if(eventDao.deleteEvent(eventId)) {
				RequestDispatcher dis = request.getRequestDispatcher("adminDashboard.jsp");
				dis.forward(request, response);
			}else {
				RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
				dis.forward(request, response);	
			}
		}else if(request.getParameter("admin-update-user-role") != null) {
			if(!userEmail.isEmpty()) {
				int userId = userDao.getUserIdFromEmail(userEmail);
				
				if(userDao.updateUserRole(userId, userRole)) {
					RequestDispatcher dis = request.getRequestDispatcher("adminDashboard.jsp");
					dis.forward(request, response);
				}else {
					RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
					dis.forward(request, response);	
				}
			}else if(!userName.isEmpty()) {
				int userId = userDao.getUserIdFromName(userName);
				
				if(userDao.updateUserRole(userId, userRole)) {
					RequestDispatcher dis = request.getRequestDispatcher("adminDashboard.jsp");
					dis.forward(request, response);
				}else {
					RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
					dis.forward(request, response);	
				}
			}
		}
		
		

	}

}
