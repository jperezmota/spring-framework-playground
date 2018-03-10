<%@ taglib uri="http://www.springframework.org/tags/form" prefix="c" %>

<!DOCTYPE html>

<head>
	<title>Custom Login PAge</title>
</head>
<body>

<h3>My Custom Login Page</h3>
<c:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
	<p>
		Username: <input type="text" name="username" />
	</p>
	<p>
		Password: <input type="password" name="password" />
	</p>
	
	<input type="submit" value="Login">
</c:form>

</body>

</html>