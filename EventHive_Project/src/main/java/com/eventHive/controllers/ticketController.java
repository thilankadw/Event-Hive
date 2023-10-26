package com.eventHive.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;

import com.eventHive.daos.ticketDao;

/**
 * Servlet implementation class ticketController
 */
public class ticketController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static boolean isSuccess;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userSessionId");
		
		String eventIdStr = request.getParameter("eventid");
		int eventId = 0;
		if(!eventIdStr.isEmpty()) {
			eventId	= Integer.parseInt(eventIdStr);
		}
		
		String noOfTicketsStr = request.getParameter("no-of-tickets");
		int noOfTickets = 0;
		if(!noOfTicketsStr.isEmpty()) {
			noOfTickets = Integer.parseInt(noOfTicketsStr);
		}
		String finalAmountStr = request.getParameter("amount");
		String paymentType = request.getParameter("payment-type");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String cardNumber = request.getParameter("card_number");
		String cardName = request.getParameter("card_name");
		String cardExpDate = request.getParameter("card_exp_date");
		String cardCvv = request.getParameter("card_cvv");

		BigDecimal finalAmount = new BigDecimal(finalAmountStr);
		
		if(cardNumber.isEmpty()) {
			paymentType = "atevent";
		}else {
			paymentType = "card";
		}
		
		int ticketId = 0;
		if(request.getParameter("ticketId") != null) {
			ticketId = Integer.parseInt(request.getParameter("ticketId"));
		}
		
		if(request.getParameter("book_ticket_btn") != null) {
			try {	
				if(ticketDao.createTickets(ticketDao.getNextID(), userId, eventId, noOfTickets, finalAmount, paymentType)) {
					RequestDispatcher dis = request.getRequestDispatcher("userProfile.jsp?userId="+userId);
					dis.forward(request, response);
				}else {
					RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
					dis.forward(request, response);	
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(request.getParameter("remove_ticket-btn") != null) {
			try {
				if(ticketDao.deleteTicket(ticketId)) {
					RequestDispatcher dis = request.getRequestDispatcher("userProfile.jsp?userId="+userId);
					dis.forward(request, response);
				}else {
					RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
					dis.forward(request, response);	
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if (request.getParameter("update_book_ticket_btn") != null) {
		    try {
		        if (ticketDao.updateTicketCount(ticketId, noOfTickets)) {
		            // Ticket count updated successfully, you can redirect the user to their profile or any other appropriate page.
		            RequestDispatcher dis = request.getRequestDispatcher("userProfile.jsp?userId=" + userId);
		            dis.forward(request, response);
		        } else {
		            // Handle the case where the ticket count update fails, e.g., show an error message.
		            RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
		            dis.forward(request, response);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
		
	}

}
