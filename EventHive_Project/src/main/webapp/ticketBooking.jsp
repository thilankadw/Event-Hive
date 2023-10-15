<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
    //if (session.getAttribute("userSessionEmail") == null) {
        //response.sendRedirect("../index.jsp");
    //}
%>
<!DOCTYPE html>
<html>
  <head>
    <title>EvenetHive - Create Event</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ticketbooking.css" />
    <!--  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css" />-->
    <!-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css" />-->
  </head>
  <body>
  
  <div class="ticket-booking-page">
  
  	<div class="ticket-booking-header"><a href="${pageContext.request.contextPath}/eventDetails.jsp">Back To Event</a></div>
  	
  	<form action="ticketController" method="post">
  
  	<div class="ticket-booking-title">Book Your Tickets</div>
  	
  	<div class="event-name">Asia Cup 2023</div>
  	<div class="event-organization">by Pakistan Cricket Board</div>
  	<div class="event-date">Wednesday, August 30 2023, 2.30PM</div>
  	
  	<div class="event-type-selection">
  		<button class="event-type-block" id="vip" onclick="updateAmount(event, 'vip')">
  			<div class="ticket-type">VIP</div>
  			<input class="ticket-price" value="2500" name="vip" readonly/>
  		</button>
  		<button class="event-type-block" id="premium" onclick="updateAmount(event, 'premium')">
  			<div class="ticket-type">Premium</div>
  			<input class="ticket-price" value="1500" name="premium" readonly/>
  		</button>
  		<button class="event-type-block" id="standard" onclick="updateAmount(event, 'standard')">
  			<div class="ticket-type">Standard</div>
  			<input class="ticket-price" value="1000" name="standard" readonly/>
  		</button>
  	</div>
  	
  	<div class="number-of-tickets-section">
  		<div class="number-of-tickets-label">Number of Tickets</div>
  		<div class="">
  			<button class="ticket-number-decrease" id="ticket-number-decrease" onclick="decrease(event)">-</button>
  			<input type="number" class="no-of-tickets" value="1" max="5" min="1" name="no-of-tickets" id="no-of-tickets" readonly>
  			<button class="ticket-number-increase" id="ticket-number-increase" onclick="increase(event)">+</button>
  		</div>
  	</div>
  	
  	<div class="final-amount-section">
  		<div class="final-amount-label">Final Amount</div>	
  		<div class="final-amount">Rs. <input type="text" id="amount" value="0" name="amount"></div>	
  		
  	</div>
  	
  	<div class="payment-type-selection">
  		<input type="button" class="payment-type-btn" id="pay-with-card-btn" value="Pay with Card">
  		<input type="button" class="payment-type-btn" id="pay-at-event-btn" value="Pay at Event">
  	</div>
  	
  	<div class="credit-card-details" id="credit-card-details" style="display: none;">
  		<div class="contact-details">
  			<input type="text" placeholder="Name">
  			<input type="text" placeholder="Email Address">
  		</div>
  		<div class="card-details">
  			<div>
  				<input type="text" placeholder="Card Number">
  				<input type="text" placeholder="Name on Card">
  			</div>
  			<div>
  				<input type="text" placeholder="Expire date">
  				<input type="text" placeholder="CVV">
  			</div>
  		</div>
  	</div>
  	
  	<input type="submit" value="Confirm Booking" class="confirm-booking-active">
  	
  	</form>
  	
  </div>
  
  
	<script src="${pageContext.request.contextPath}/scripts/ticketBooking.js"></script>

</body>
</html>