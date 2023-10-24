<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>

<%@ page import="jakarta.servlet.http.HttpServlet"%>

<%@ page import="com.eventHive.utils.dbConnection"%>

<%@ page import="javax.servlet.http.HttpSession" %>

<%
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null; 
	PreparedStatement preparedStatement = null;
	
	Integer userId = (Integer) session.getAttribute("userSessionId");

%>

<!DOCTYPE html>
<html>
  <head>
    <title>EvenetHive</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/eventCard.css" />      
  </head>
  <body>
  	<%@ include file="header.jsp" %>

    <div class="index-container">
      <div class="hero-container">
        <img
          src="${pageContext.request.contextPath}/assets/index/heroimage.png"
          alt="hero"
          class="hero-image"
        />
        <div class="hero-text">Made for those<br />who do</div>
      </div>

      <div class="index-event-register">
        <form class="index-event-register-form" action="eventController" method="get">
          <div class="index-form-inputs">
            <div class="index-form-label">Looking for</div>
            <select name="event_category">
              	<option>Sport Event</option>
				<option>Exhibition</option>
				<option>Award Ceremony</option>
				<option>Musical Event</option>
				<option>Comedy Shows</option>
            </select>
          </div>
          <div class="index-form-inputs">
            <div class="index-form-label">District</div>
            <select>
              <% String[] districts ={"Ampara", "Anuradhapura", "Badulla", "Batticaloa", "Colombo",
										"Galle", "Gampaha", "Hambantota", "Jaffna", "Kalutara",
										"Kandy", "Kegalle", "Kilinochchi", "Kurunegala", "Mannar",
										"Matale", "Matara", "Monaragala", "Mullaitivu", "Nuwara Eliya",
										"Polonnaruwa", "Puttalam", "Ratnapura", "Trincomalee", "Vavuniya"};
								
								for(String district : districts) { %>
									<option value="<%= district %>"><%= district %></option><% } %>
            </select>
          </div>
          <div class="index-form-inputs">
            <div class="index-form-label">Type</div>
            <select>
              <option value="online">Online</option>
              <option value="physical">Physical</option>
              <option value="hybrid">Hybrid</option>
            </select>
          </div>   
          <input
            type="submit"
            class="index-event-register-form-submit"
            value="R"
          />
        </form>
      </div>

      <div class="upcoming-events-section">
        <div class="upcoming-events-header">
          <div class="upcoming-events-title">
            <div class="upcoming-events-title-first">Upcoming</div>
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

        <div class="upcoming-events">
        
        	<div class="upcoming-events-center aaa">
        		<%
					try {
					    connection = dbConnection.getConnection();
					    statement = connection.createStatement();
					    String sql = "select * from events where userId != ?";
					    preparedStatement = connection.prepareStatement(sql);
					    preparedStatement.setInt(1, userId);
					    resultSet = preparedStatement.executeQuery();
					    while (resultSet.next()) {							
					    	String eventTypeValue = "Happens PHYSICALLY!!!";
							
							if (resultSet.getString(11).equals("physical")) {
								eventTypeValue = "Happens PHYSICALLY!!!";
						    } else if (resultSet.getString(11).equals("online")) {
						    	eventTypeValue = "ONLINE EVENT - Attend Anywhere!!!";
						    } 		
							    
				%>
					<jsp:include page="eventCard.jsp">
						<jsp:param name="eventId" value="<%= resultSet.getString(1) %>" />
						<jsp:param name="eventImage" value="<%= resultSet.getString(20) %>" />
					    <jsp:param name="eventName" value="<%= resultSet.getString(2) %>" />
					    <jsp:param name="eventDate" value="<%= resultSet.getString(9) %>" />
						
					    <jsp:param name="eventType" value="<%= eventTypeValue %>" />
					</jsp:include>

	        	<%
						}
						connection.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				%>
          
          	</div>        
        </div>
      </div>

      <div class="index-create-event">
        <img src="${pageContext.request.contextPath}/assets/index/create-event.png" alt="" />
        <div class="index-create-event-text">
          <div>Make your own Event</div>
          <div>
            Create and mange your all events<br />at one place
          </div>
          <a href="createEvent.jsp">Create Events</a>
        </div>
      </div>

		
      <div class="upcoming-events-section">
        <div class="upcoming-events-header">
          <div class="upcoming-events-title">
            <div class="upcoming-events-title-first">Upcoming</div>
            <div class="upcoming-events-title-second">Events</div>
          </div>
        </div>

        <div class="upcoming-events">
        
        	<div class="upcoming-events-center aaa">
        		<%
					try {
					    connection = dbConnection.getConnection();
					    statement = connection.createStatement();
					    String sql = "select * from events";
					    preparedStatement = connection.prepareStatement(sql);
					    resultSet = preparedStatement.executeQuery();
					    while (resultSet.next()) {							
					    	String eventTypeValue = "Happens PHYSICALLY!!!";
							
							if (resultSet.getString(11).equals("physical")) {
								eventTypeValue = "Happens PHYSICALLY!!!";
						    } else if (resultSet.getString(11).equals("online")) {
						    	eventTypeValue = "ONLINE EVENT - Attend Anywhere!!!";
						    } 		
							    
				%>
					<jsp:include page="eventCard.jsp">
						<jsp:param name="eventId" value="<%= resultSet.getString(1) %>" />
						<jsp:param name="eventImage" value="<%= resultSet.getString(20) %>" />
					    <jsp:param name="eventName" value="<%= resultSet.getString(2) %>" />
					    <jsp:param name="eventDate" value="<%= resultSet.getString(9) %>" />
						
					    <jsp:param name="eventType" value="<%= eventTypeValue %>" />
					</jsp:include>

	        	<%
						}
						connection.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				%>
          
          	</div>        
        </div>
      </div>
         
         

      </div>
    </div>
    
    <%@ include file="footer.jsp" %>
    
	<script src="${pageContext.request.contextPath}/scripts/header.js"></script>
	<script src="${pageContext.request.contextPath}/scripts/index.js"></script>
	
  </body>
</html>
