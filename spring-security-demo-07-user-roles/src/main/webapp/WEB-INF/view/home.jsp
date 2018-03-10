<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Expressive Insight Company Home Page</title>
</head>
<body>
	<h2>Expressive Insights Company Home Page</h2>
	<hr>
	
	<p>
		Welcome to our page :).
	</p>
	
	<!-- Adding logout bottom -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="logout" />
	</form:form>
</body>
</html>