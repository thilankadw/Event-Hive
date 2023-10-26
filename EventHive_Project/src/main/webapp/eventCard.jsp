
  	
	<div class="upcoming-event">
	    <a href="eventDetails.jsp?eventId=${param.eventId}">
	        <img
			    src="${pageContext.request.contextPath}/assets/eventBanners/${param.eventImage}"
			    alt="Event_Image"
			    class="upcoming-events-event-image"
			/>

	    </a>
	    <div class="upcoming-event-name">${param.eventName}</div>
	    <div class="upcoming-event-date">Starting From - ${param.eventDate}</div>
	    <div class="upcoming-event-type">${param.eventType}</div>
	</div>

	<script>
		
		const targetDivs = document.querySelectorAll(".upcoming-event");
	
		const options = {
		  threshold: 0.5, // Adjust the threshold as needed
		  rootMargin: "0px 0px 0px 0px"
		};
	
		const observer = new IntersectionObserver(function (entries) {
		  entries.forEach(entry => {
		    console.log(entry.target);
		    const isIntersecting = entry.isIntersecting;
		    console.log(isIntersecting);
		    if (isIntersecting) {
		      entry.target.classList.add("fade-in");
		    } else {
		      entry.target.classList.remove("fade-in");
		    }
		  });
		}, options);
	
		targetDivs.forEach(targetDiv => {
		  observer.observe(targetDiv);
		});

    
	</script>