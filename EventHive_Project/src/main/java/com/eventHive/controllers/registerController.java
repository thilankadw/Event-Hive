package com.eventHive.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.eventHive.daos.userDao;
import com.eventHive.utils.userUtils;
/**
 * Servlet implementation class registerController
 */
public class registerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("reg_name");
		String userEmail = request.getParameter("reg_email");
		String userPassword = (String)request.getParameter("reg_password");
		
		try {
			if(!(userDao.checkEmailExist(userEmail))) {
				if(userDao.createUserRecord(userName, userEmail, userPassword)) {
					HttpSession session = request.getSession(true);
					session.setAttribute("userSessionEmail", userEmail);
					
					RequestDispatcher dis = request.getRequestDispatcher("createEvent.jsp");
					dis.forward(request, response);
				}else {
					RequestDispatcher dis = request.getRequestDispatcher("allEvents.jsp");
					dis.forward(request, response);
				}
			}else {
				RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
				dis.forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
