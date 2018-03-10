<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<head>
	<title>Custom Login PAge</title>
	
	<style>
		.failed{
			color: red;
			}
	</style>
</head>
<body>

<h3>My Custom Login Page</h3>
<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">

	<!-- Check for error -->
	<c:if test="${param.error != null }">
		<i class="failed">Sorry! You entered invalid username/password</i>
	</c:if>
	<p>
		Username: <input type="text" name="username" />
	</p>
	<p>
		Password: <input type="password" name="password" />
	</p>
	
	<input type="submit" value="Login">
</form:form>

</body>

</html>