<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
    //if (session.getAttribute("userSessionEmail") == null) {
        //response.sendRedirect("../index.jsp");
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
  					<form class="event-banner-update-form">
  						<div class="event-details-header-dates-title">Add New Banner</div>
  						<div>
  							<input type="file" class="update-banner">
  							<input type="submit" value="update" class="update-event-details-submitbtn">
  						</div>
  					</form>
  					<div class="event-details-header-day" style="display: none;">Wednesday, August 30 2023, 2.30PM</div>
  					<div class="event-details-header-payments" style="display: none;">Free</div>
  					<div class="event-details-header-payments-booking">
  						<a class="event-details-ticket-booking-link" style="display: none;" href="${pageContext.request.contextPath}/ticketBooking.jsp">Book Now</a>
  						<div class="event-details-header-payments-refund" style="display: none;">Refund Available</div>
  					</div>
  					
  				</div>
  			</div>
  		</div>
  		
  		<div class="event-details-main">
  			<div class="event-details-parts">
  				<div class="event-details-title">Event Title</div>
  				<div class="event-details-text">Asia Cup 2023</div>
  				<button id="event-title-edit-btn">Edit</button>
			</div>
			<!-- Event Update Pop up Forms -->
			<div class="event-title-update">
		  		<div>Enter New Title</div>
		  		<form class="event-details-update-from">
		  			<input type="text" class="event-update-input">
		  			<input type="submit" value="Add New Title" class="update-event-details-submitbtn" name="addNewTitle">
		  		</form>
		  	</div>
			<div class="event-details-parts">
  				<div class="event-details-title">Organized By</div>
  				<div class="event-details-text">Pakistan Cricket Board</div>
  				<button id="event-organizer-edit-btn">Edit</button>
			</div>
			<!-- Event Update Pop up Forms -->
			<div class="event-organizer-update">
		  		<div>Enter New Organizer</div>
		  		<form class="event-details-update-from">
		  			<input type="text" class="event-update-input">
		  			<input type="submit" value="Add New Organizer" class="update-event-details-submitbtn" name="addNewOrganization">
		  		</form>
		  	</div>
			<div class="event-details-parts">
  				<div class="event-details-title">Event Location</div>
  				<div class="event-details-text">Pallekale International Cricket Stadium</div>
  				<button id="event-location-edit-btn">Edit</button>
			</div>
			<!-- Event Update Pop up Forms -->
			<div class="event-location-update">
		  		<div>Enter New Location</div>
		  		<form class="event-details-update-from">
		  			<input type="text" class="event-update-input">
		  			<input type="submit" value="Add New Location" class="update-event-details-submitbtn" name="addNewLocation">
		  		</form>
		  	</div>
			<div class="event-details-second-part">
				<div class="event-details-second-part-parts">
					<div class="event-details-title">Starting Date</div>
  					<div class="event-details-text">Wednesday, August 30 2023</div>
  					<button id="event-startdate-edit-btn">Edit</button>
  				</div>
  				<div class="event-details-second-part-parts">
					<div class="event-details-title">Ending Date</div>
  					<div class="event-details-text">Wednesday, August 30 2023</div>
  					<button id="event-enddate-edit-btn">Edit</button>
  				</div>
			</div>
			<!-- Event Update Pop up Forms -->
			<div class="event-startdate-update">
		  		<div>Enter New Starting Date</div>
		  		<form class="event-details-update-from">
		  			<input type="text" class="event-update-input">
		  			<input type="submit" value="Add New Starting Date" class="update-event-details-submitbtn" name="addNewstartingDate">
		  		</form>
		  	</div>
		  	<!-- Event Update Pop up Forms -->
			<div class="event-enddate-update">
		  		<div>Enter New Ending Date</div>
		  		<form class="event-details-update-from">
		  			<input type="text" class="event-update-input">
		  			<input type="submit" value="Add New Ending Date" class="update-event-details-submitbtn" name="addNewEndingDate">
		  		</form>
		  	</div>
			<div class="event-details-second-part">
				<div class="event-details-second-part-parts">
					<div class="event-details-title">Starting Time</div>
  					<div class="event-details-text">2.30PM</div>
  					<button id="event-starttime-edit-btn">Edit</button>
  				</div>
  				<div class="event-details-second-part-parts">
					<div class="event-details-title">Ending Time</div>
  					<div class="event-details-text">11.30PM</div>
  					<button id="event-endtime-edit-btn">Edit</button>
  				</div>
			</div>
			<!-- Event Update Pop up Forms -->
			<div class="event-starttime-update">
		  		<div>Enter New Starting Time</div>
		  		<form class="event-details-update-from">
		  			<input type="text" class="event-update-input">
		  			<input type="submit" value="Add New Starting Time" class="update-event-details-submitbtn" name="addNewStartingTime">
		  		</form>
		  	</div>
		  	<!-- Event Update Pop up Forms -->
			<div class="event-endtime-update">
		  		<div>Enter New Ending Time</div>
		  		<form class="event-details-update-from">
		  			<input type="text" class="event-update-input">
		  			<input type="submit" value="Add New Ending Time" class="update-event-details-submitbtn" name="addNewEndingTime">
		  		</form>
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
  		<a href="${pageContext.request.contextPath}/ticketBooking.jsp" style="display: none;" class="event-booking-link-main" style="<% if (true) { %>display: block;<% } else { %>display: none;<% } %>">Book Tickets</a>
  		
  	</div>

	<%@ include file="footer.jsp" %>
	
    <script src="${pageContext.request.contextPath}/scripts/updateEventDetails.js"></script>
	<script src="${pageContext.request.contextPath}/scripts/header.js"></script>
	
  </body>
</html>