<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
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
	
	<hr>
	
	<!-- Display username and role -->
	
	<p>
		User: <security:authentication property="principal.username"/>
		<br><br>
		Role(s): <security:authentication property="principal.authorities"/>
	</p>
	
	<hr>
	
	<!-- Adding logout bottom -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="logout" />
	</form:form>
</body>
</html>