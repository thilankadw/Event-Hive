package com.eventHive.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class logoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {			
			HttpSession session = request.getSession(false);
			if(session!=null) {
				session.removeAttribute("userSessionEmail");
			    session.removeAttribute("userSessionId");
			    session.removeAttribute("userSessionRole");
			}
		  	    
		    RequestDispatcher requestdispatcher = request.getRequestDispatcher("index.jsp");
			requestdispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
