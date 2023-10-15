<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
    //if (session.getAttribute("userSessionEmail") == null) {
        //response.sendRedirect("index.jsp");
   // }
%>
<!DOCTYPE html>
<html>
  <head>
    <title>EvenetHive</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/eventDetails.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css" />
  </head>
  <body>
  	<%@ include file="header.jsp" %>
  	
  	<div class="event-details-container">
  		
  		<div class="event-details-header">
  			<img src="${pageContext.request.contextPath}/assets/eventdetails/unsplash_qfWMUXDcN18.png" class="event-details-header-image">
  			<div class="event-details-header-main">
  				<div class="event-details-header-texts">
  					<div class="event-details-header-name">Asia Cup 2023</div>
  					<div class="event-details-header-organization">by Pakistan Cricket Board</div>
  				</div>
  				<div class="event-details-header-dates">
  					<div class="event-details-header-dates-title">Date & time</div>
  					<div class="event-details-header-day">Wednesday, August 30 2023, 2.30PM</div>
  					<div class="event-details-header-payments" style="display: none;">Free</div>
  					<div class="event-details-header-payments-booking">
  						<a class="event-details-ticket-booking-link" href="${pageContext.request.contextPath}/ticketBooking.jsp">Book Now</a>
  						<div class="event-details-header-payments-refund">Refund Available</div>
  					</div>
  				</div>
  			</div>
  		</div>
  		
  		<div class="event-details-main">
  			<div class="event-details-parts">
  				<div class="event-details-title">Event Title</div>
  				<div class="event-details-text">Asia Cup 2023</div>
			</div>
			<div class="event-details-parts">
  				<div class="event-details-title">Organized By</div>
  				<div class="event-details-text">Pakistan Cricket Board</div>
			</div>
			<div class="event-details-parts">
  				<div class="event-details-title">Event Location</div>
  				<div class="event-details-text">Pallekale International Cricket Stadium</div>
			</div>
			<div class="event-details-second-part">
				<div class="event-details-second-part-parts">
					<div class="event-details-title">Starting Date</div>
  					<div class="event-details-text">Wednesday, August 30 2023</div>
  				</div>
  				<div class="event-details-second-part-parts">
					<div class="event-details-title">Ending Date</div>
  					<div class="event-details-text">Wednesday, August 30 2023</div>
  				</div>
			</div>
			<div class="event-details-second-part">
				<div class="event-details-second-part-parts">
					<div class="event-details-title">Starting Time</div>
  					<div class="event-details-text">2.30PM</div>
  				</div>
  				<div class="event-details-second-part-parts">
					<div class="event-details-title">Ending Time</div>
  					<div class="event-details-text">11.30PM</div>
  				</div>
			</div>
			<div class="event-details-parts">
  				<div class="event-details-title">Event Type</div>
  				<div class="event-details-text">Physical</div>
			</div>
			<div class="event-details-parts">
  				<div class="event-details-title">Event Payments</div>
  				<div class="event-details-text">Paid</div>
			</div>
			<div class="event-details-parts-description">
  				<div class="event-details-title">Event Description</div>
  				<div class="event-details-text">DesignHub organized a 3D Modeling Workshop using Blender on 16th February at 5 PM. The workshop taught participants the magic of creating stunning 3D models and animations using Blender. It was suitable for both beginners and experienced users. The event was followed by a blender-render competition, which added to the excitement.</div>
			</div>
  		</div>
  		<a href="${pageContext.request.contextPath}/ticketBooking.jsp" class="event-booking-link-main" style="<% if (true) { %>display: block;<% } else { %>display: none;<% } %>">Book Tickets</a>
  		
  	</div>
  	

	<%@ include file="footer.jsp" %>
    
	<script src="${pageContext.request.contextPath}/scripts/header.js"></script>
	
  </body>
</html>