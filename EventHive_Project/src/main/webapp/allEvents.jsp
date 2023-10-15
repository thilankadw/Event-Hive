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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/allEvents.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css" />
  </head>
  <body>
  
  	<%@ include file="header.jsp" %>
  	
  	<div class="allevents-container">
  	
  		<div class="allevents-header">
  			<div class="allevents-details">
  				<div class="allevents-header-tagline">Thriving Above Event Expectations.</div>
  				<div class="allevents-headertext"><div>Event<div>Hive</div>-ing</div><div>the Best.Day.<br>Ever.</div></div>
  				<div class="allevents-header-numbers">2k+<br>Total Events<br>Hosted</div>
  			</div>
  			<div class="allevents-img">
  				<img src="${pageContext.request.contextPath}/assets/allevents/unsplash_ugaOk9LkmQY.png">
  			</div>
  		</div>	
  		
  		<div class="upcoming-events-header">
          <div class="upcoming-events-title">
            <div class="upcoming-events-title-first">All</div>
            <div class="upcoming-events-title-second">Events</div>
          </div>
          <div class="upcoming-events-filter">
            <div class="upcoming-events-filter-dropdown">
              <select name="" id="">
                <option value="Wedding">Wedding</option>
                <option value="Exhibition">Exhibition</option>
                <option value="Meet up">Meet up</option>
                <option value="Award Ceremony">Award Ceremony</option>
              </select>
            </div>
            <div class="upcoming-events-filter-dropdown">
              <select>
                <% String[] ddistricts ={"Ampara", "Anuradhapura", "Badulla", "Batticaloa", "Colombo",
										"Galle", "Gampaha", "Hambantota", "Jaffna", "Kalutara",
										"Kandy", "Kegalle", "Kilinochchi", "Kurunegala", "Mannar",
						 				"Matale", "Matara", "Monaragala", "Mullaitivu", "Nuwara Eliya",
										"Polonnaruwa", "Puttalam", "Ratnapura", "Trincomalee", "Vavuniya"};
											
					for(String district : ddistricts) { %>
					<option value="<%= district %>"><%= district %></option><% } %>
              </select>
            </div>
            <div class="upcoming-events-filter-dropdown">
              <input
                type="date"
                id="event-starting-date"
                placeholder="select starting date"
                class="upcoming-events-filter-date"
              />
            </div>
          </div>
        </div>
  		
  	</div>
  	

	<%@ include file="footer.jsp" %>
    
	<script src="${pageContext.request.contextPath}/scripts/header.js"></script>
	
  </body>
</html>