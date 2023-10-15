<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

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
        <form class="index-event-register-form" action="#" method="post">
          <div class="index-form-inputs">
            <div class="index-form-label">Looking for</div>
            <select>
              <option value="Wedding">Wedding</option>
              <option value="Exhibition">Exhibition</option>
              <option value="Meet up">Meet up</option>
              <option value="Award Ceremony">Award Ceremony</option>
            </select>
          </div>
          <div class="index-form-inputs">
            <div class="index-form-label">Location</div>
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
        
				<jsp:include page="eventCard.jsp">
					<jsp:param name="eventName" value="Asia Cup 2023" />
	    			<jsp:param name="eventDate" value="Wednesday, August 30, 2.30PM" />
				</jsp:include>
	        
	        	<jsp:include page="eventCard.jsp">
					<jsp:param name="eventName" value="Asia Cup 2023" />
	    			<jsp:param name="eventDate" value="Wednesday, August 30, 2.30PM" />
				</jsp:include>
				
				<jsp:include page="eventCard.jsp">
					<jsp:param name="eventName" value="Asia Cup 2023" />
	    			<jsp:param name="eventDate" value="Wednesday, August 30, 2.30PM" />
				</jsp:include>
				
				<jsp:include page="eventCard.jsp">
					<jsp:param name="eventName" value="Asia Cup 2023" />
	    			<jsp:param name="eventDate" value="Wednesday, August 30, 2.30PM" />
				</jsp:include>
				
				<jsp:include page="eventCard.jsp">
					<jsp:param name="eventName" value="Asia Cup 2023" />
	    			<jsp:param name="eventDate" value="Wednesday, August 30, 2.30PM" />
				</jsp:include>
				
				<jsp:include page="eventCard.jsp">
					<jsp:param name="eventName" value="Asia Cup 2023" />
	    			<jsp:param name="eventDate" value="Wednesday, August 30, 2.30PM" />
				</jsp:include>
          
          	</div>
          
        </div>
      </div>

      <div class="index-create-event">
        <img src="${pageContext.request.contextPath}/assets/index/create-event.png" alt="" />
        <div class="index-create-event-text">
          <div>Make your own Event</div>
          <div>
            Lorem ipsum dolor sit amet, consectetur<br />adipiscing elit.
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
        
				<jsp:include page="eventCard.jsp">
					<jsp:param name="eventName" value="Asia Cup 2023" />
	    			<jsp:param name="eventDate" value="Wednesday, August 30, 2.30PM" />
				</jsp:include>
	        
	        	<jsp:include page="eventCard.jsp">
					<jsp:param name="eventName" value="Asia Cup 2023" />
	    			<jsp:param name="eventDate" value="Wednesday, August 30, 2.30PM" />
				</jsp:include>
				
				<jsp:include page="eventCard.jsp">
					<jsp:param name="eventName" value="Asia Cup 2023" />
	    			<jsp:param name="eventDate" value="Wednesday, August 30, 2.30PM" />
				</jsp:include>
				
				<jsp:include page="eventCard.jsp">
					<jsp:param name="eventName" value="Asia Cup 2023" />
	    			<jsp:param name="eventDate" value="Wednesday, August 30, 2.30PM" />
				</jsp:include>
				
				<jsp:include page="eventCard.jsp">
					<jsp:param name="eventName" value="Asia Cup 2023" />
	    			<jsp:param name="eventDate" value="Wednesday, August 30, 2.30PM" />
				</jsp:include>
				
				<jsp:include page="eventCard.jsp">
					<jsp:param name="eventName" value="Asia Cup 2023" />
	    			<jsp:param name="eventDate" value="Wednesday, August 30, 2.30PM" />
				</jsp:include>
          
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
