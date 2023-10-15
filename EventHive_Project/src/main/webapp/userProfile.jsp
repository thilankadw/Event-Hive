<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
    //if (session.getAttribute("userSessionEmail") == null) {
        //response.sendRedirect("index.jsp");
    //}
%>
<!DOCTYPE html>
<html>
  <head>
    <title>EvenetHive</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/userProfile.css" />           
  </head>
  
<body>

	<%@ include file="header.jsp" %>
	
	<div class="user-profile-container">
		<div class="user-profile-navigation">
			<button id="dashboardBtn">Dashboard</button>
			<button id="eventBtn">Events</button>
			<button id="bookingsBtn">Bookings</button>
			<button id="profileBtn">Profile</button>
		</div>
		<div class="user-profile-content">
		
			<div id="userprofile-dashboard">
				<div class="userprofile-header">
					<div>Discover and<br>experience<br>extraordinary Events.</div>
				</div>
				
				<div class="dashboard-showcase">
					<div class="dashboard-showcase-element">
						<div>10</div>
						<div>Ticketes Sold</div>
					</div>
					<div class="dashboard-showcase-element">
						<div>100</div>
						<div>Revenue (USD)</div></div>
					<div class="dashboard-showcase-element-2"></div>
				</div>
				
			</div>
			
			
			<div id="userprofile-events">
				<div class="userprofile-header">
					<div>Discover and<br>experience<br>extraordinary Events.</div>
				</div>
				
				<div class="userprofile-events-container">
					<div class="userprofile-events-title">Scheduled Events</div>
					<div>
						<div class="userprofile-event">
							<a href="${pageContext.request.contextPath}/updateEventDetails.jsp">
								<img
	                				src="${pageContext.request.contextPath}/assets/index/eventimage.png"
					                alt=""
					                class="upcoming-events-event-image"
	              				/>
	              				<div class="overlay">
		              				<div class="event-details">
		              					<div>Asia Cup 2023</div>			
		              				</div>
	              				</div>
	              			</a>	
						</div>
						
						<div class="userprofile-event">
							<a href="${pageContext.request.contextPath}/updateEventDetails.jsp">
								<img
	                				src="${pageContext.request.contextPath}/assets/index/eventimage.png"
					                alt=""
					                class="upcoming-events-event-image"
	              				/>
	              				<div class="overlay">
		              				<div class="event-details">
		              					<div>Asia Cup 2023</div>
		              				</div>
	              				</div>
	              				
	              			</a>
						</div>
						
						<div class="userprofile-event">
							<a href="${pageContext.request.contextPath}/updateEventDetails.jsp">
								<img
	                				src="${pageContext.request.contextPath}/assets/index/eventimage.png"
					                alt=""
					                class="upcoming-events-event-image"
	              				/>
	              				<div class="overlay">
		              				<div class="event-details">
		              					<div>Asia Cup 2023</div>
		              				</div>
	              				</div>
	              				
	              			</a>
						</div>
					</div>
				</div>
				
				<div class="userprofile-events-container">
					<div class="userprofile-events-title">Completed Events</div>
					<div>
						<div class="userprofile-event">
							<a href="${pageContext.request.contextPath}/updateEventDetails.jsp">
								<img
	                				src="${pageContext.request.contextPath}/assets/index/eventimage.png"
					                alt=""
					                class="upcoming-events-event-image"
	              				/>
	              				<div class="overlay">
		              				<div class="event-details">
		              					<div>Asia Cup 2023</div>
		              				</div>
	              				</div>
	              				
	              			</a>
						</div>
						
						<div class="userprofile-event">
							<a href="${pageContext.request.contextPath}/updateEventDetails.jsp">
								<img
	                				src="${pageContext.request.contextPath}/assets/index/eventimage.png"
					                alt=""
					                class="upcoming-events-event-image"
	              				/>
	              				<div class="overlay">
		              				<div class="event-details">
		              					<div>Asia Cup 2023</div>
		              				</div>
	              				</div>
	              				
	              			</a>
						</div>
						
						<div class="userprofile-event">
							<a href="${pageContext.request.contextPath}/updateEventDetails.jsp">
								<img
	                				src="${pageContext.request.contextPath}/assets/index/eventimage.png"
					                alt=""
					                class="upcoming-events-event-image"
	              				/>
	              				<div class="overlay">
		              				<div class="event-details">
		              					<div>Asia Cup 2023</div>
		              				</div>
	              				</div>
	              				
	              			</a>
						</div>
					
						<div class="userprofile-event">
							<a href="${pageContext.request.contextPath}/updateEventDetails.jsp">
								<img
	                				src="${pageContext.request.contextPath}/assets/index/eventimage.png"
					                alt=""
					                class="upcoming-events-event-image"
	              				/>
	              				<div class="overlay">
		              				<div class="event-details">
		              					<div>Asia Cup 2023</div>
		              				</div>
	              				</div>
	              				
	              			</a>
						</div>
						
						<div class="userprofile-event">
							<a href="${pageContext.request.contextPath}/updateEventDetails.jsp">
								<img
	                				src="${pageContext.request.contextPath}/assets/index/eventimage.png"
					                alt=""
					                class="upcoming-events-event-image"
	              				/>
	              				<div class="overlay">
		              				<div class="event-details">
		              					<div>Asia Cup 2023</div>
		              				</div>
	              				</div>
	              				
	              			</a>
						</div>
						
						<div class="userprofile-event">
							<a href="${pageContext.request.contextPath}/updateEventDetails.jsp">
								<img
	                				src="${pageContext.request.contextPath}/assets/index/eventimage.png"
					                alt=""
					                class="upcoming-events-event-image"
	              				/>
	              				<div class="overlay">
		              				<div class="event-details">
		              					<div>Asia Cup 2023</div>
		              				</div>
	              				</div>
	              				
	              			</a>
						</div>
					</div>
				</div>
				
			</div>
			
			
			<div id="userprofile-bookings">
				<div class="userprofile-header">
					<div>Discover and<br>experience<br>extraordinary Events.</div>
				</div>
				
				<div class="userprofile-booking-container">
				
					<div class="userprofile-events-title">Your Reservations</div>
					<div>
						<div class="userprofile-event">
							<a>
								<img
	                				src="${pageContext.request.contextPath}/assets/index/eventimage.png"
					                alt=""
					                class="upcoming-events-event-image"
	              				/>
	              				<div class="overlay">
		              				<div class="event-boking-details">
		              					<div>Asia Cup 2023</div>
		              					<div>Event Date</div>
		              					<div>Location</div>
		              					<div>Code</div>
		              				</div>
	              				</div>
	              				
	              			</a>
						</div>
						
						<div class="userprofile-event">
							<a>
								<img
	                				src="${pageContext.request.contextPath}/assets/index/eventimage.png"
					                alt=""
					                class="upcoming-events-event-image"
	              				/>
	              				<div class="overlay">
		              				<div class="event-boking-details">
		              					<div>Asia Cup 2023</div>
		              					<div>Event Date</div>
		              					<div>Location</div>
		              					<div>Code</div>
		              				</div>
	              				</div>
	              				
	              			</a>
						</div>
						
						<div class="userprofile-event">
							<a>
								<img
	                				src="${pageContext.request.contextPath}/assets/index/eventimage.png"
					                alt=""
					                class="upcoming-events-event-image"
	              				/>
	              				<div class="overlay">
		              				<div class="event-boking-details">
		              					<div>Asia Cup 2023</div>
		              					<div>Event Date</div>
		              					<div>Location</div>
		              					<div>Code</div>
		              				</div>
	              				</div>
	              				
	              			</a>
						</div>					
					</div>
				</div>
				
				<div class="">
					<div>You may also like</div>
					
					<div class="">
        
						<!--<jsp:include page="eventcard.jsp">
							<jsp:param name="eventName" value="Asia Cup 2023" />
			    			<jsp:param name="eventDate" value="Wednesday, August 30, 2.30PM" />
						</jsp:include>-->
			        
		          	</div>
				</div>
			
			</div>
			
			
			<div id="userprofile-profile">
				<div class="userprofile-header">
					<div>Discover and<br>experience<br>extraordinary Events.</div>
				</div>
				
				<div class="userprofile-logout">
					<form action="/logoutController"  method="post">
						<input type="submit" value="Log Out">
					</form>
				</div>
				
				<div class="userprofile-events-container">
					<div class="userprofile-portfolio-title">Portfolio</div>
					<div class="dashboard-showcase">
						<div class="dashboard-showcase-element">
							<div>10</div>
							<div>Events</div>
						</div>
						<div class="dashboard-showcase-element">
							<div>100</div>
							<div>Total Participants</div>
						</div>
						<div class="dashboard-showcase-element">
							<div>100</div>
							<div>Revenue (USD)</div>
						</div>
						<a href="#" class="profileto-createevent">Create Events</a>
					</div>
				</div>
				
				
			</div>
			
		</div>
	</div>
	  	
  	<%@ include file="footer.jsp" %>
  	
  	<!--<script src="${pageContext.request.contextPath}/scripts/header.js"></script>
  	<script src="${pageContext.request.contextPath}/scripts/userProfile.js"></script>  -->
  	
  	<script>
	  	//navigation buttons
	  	const dashboardBtn = document.getElementById('dashboardBtn');
	  	const eventBtn = document.getElementById('eventBtn');
	  	const bookingsBtn = document.getElementById('bookingsBtn');
	  	const profileBtn = document.getElementById('profileBtn');
	
	  	//sections
	  	const userProfileDashboard = document.getElementById("userprofile-dashboard");
	  	const userProfileEvents = document.getElementById("userprofile-events");
	  	const userProfileBookings = document.getElementById("userprofile-bookings");
	  	const userProfileProfile = document.getElementById("userprofile-profile");
	
	  	//intialize navigation button background colors
	  	dashboardBtn.style.backgroundColor = "#10107B";
	  	dashboardBtn.style.color = "#ffffff";
	  	 
	  	//reset navigation button colors 
	  	function resetButtons() {
	  	  dashboardBtn.style.backgroundColor = "";
	  	  dashboardBtn.style.color = "";
	  	  eventBtn.style.backgroundColor = "";
	  	  eventBtn.style.color = "";
	  	  bookingsBtn.style.backgroundColor = "";
	  	  bookingsBtn.style.color = "";
	  	  profileBtn.style.backgroundColor = "";
	  	  profileBtn.style.color = "";
	  	}
	
	  	//functions for navigation buttons
	  	eventBtn.addEventListener("click", () => {
	  		resetButtons();
	  		userProfileDashboard.style.display = "none";
	  		userProfileBookings.style.display = "none";
	  		userProfileProfile.style.display = "none";
	  		userProfileEvents.style.display = "block";
	  		eventBtn.style.backgroundColor = "#10107B";
	  	  	eventBtn.style.color = "#ffffff";
	  	});
	
	  	dashboardBtn.addEventListener("click", () => {
	  		resetButtons();
	  		userProfileBookings.style.display = "none";
	  		userProfileProfile.style.display = "none";
	  		userProfileEvents.style.display = "none";
	  		userProfileDashboard.style.display = "block";
	  		dashboardBtn.style.backgroundColor = "#10107B";
	  	  	dashboardBtn.style.color = "#ffffff";
	  	});
	
	  	bookingsBtn.addEventListener("click", () => {
	  		resetButtons();
	  		userProfileDashboard.style.display = "none";
	  		userProfileProfile.style.display = "none";
	  		userProfileEvents.style.display = "none";
	  		userProfileBookings.style.display = "block";
	  		bookingsBtn.style.backgroundColor = "#10107B";
	  	  	bookingsBtn.style.color = "#ffffff";
	  	});
	
	  	profileBtn.addEventListener("click", () => {
	  		resetButtons();
	  		userProfileDashboard.style.display = "none";
	  		userProfileBookings.style.display = "none";
	  		userProfileEvents.style.display = "none";
	  		userProfileProfile.style.display = "block";
	  		profileBtn.style.backgroundColor = "#10107B";
	  	  	profileBtn.style.color = "#ffffff";
	  	});
	  	
  	</script>
  	
</body>
</html>