<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/inquiry.css" />
</head>
<body>

	<%@ include file="header.jsp" %>

	<div class="inquiry-container">
		<div>
			<form method="post" action="inquiryController">
				<input type="text" placeholder="Title" class="inquiry-title">
				<textarea class="inquiry"></textarea>
				<input type="submit" value="Submit" class="inquiry-submit-btn">
			</form>
		</div>
	</div>
	
	
	<%@ include file="footer.jsp" %>

	<script src="${pageContext.request.contextPath}/scripts/header.js"></script>
	<script src="${pageContext.request.contextPath}/scripts/index.js"></script>

</body>
</html>