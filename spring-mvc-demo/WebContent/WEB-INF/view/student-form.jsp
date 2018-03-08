<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Student Registration</title>
	</head>
	<body>
		<form:form action="processForm" modelAttribute="student">
			
			Student Name: <form:input path="firstName"/>
			
			<br><br>
			
			Last Name: <form:input path="lastName"/>
			<br><br>
			
			Country:
			
		<%-- 	<form:select path="country">
				<form:option value="Brasil" label="Brazil"></form:option>
				<form:option value="France" label="France"></form:option>
				<form:option value="Germany" label="Germany"></form:option>
				<form:option value="India" label="India"></form:option>
			</form:select> --%>
			<form:select path="country">
				<form:options items="${student.countryOptions}"/>
			</form:select>
			
			<br><br>
			
			Favorite Language:
			
			Java <form:radiobutton path="favoriteLanguage" value="Java"/>
			C# <form:radiobutton path="favoriteLanguage" value="C#"/>
			PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
			Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
			
			<br><br>
			
			Operating Systems:
			
			Linux: <form:checkbox path="operatingSystems" value="Linux"/>
			Mac OS: <form:checkbox path="operatingSystems" value="Mac OS"/>
			MS Windows: <form:checkbox path="operatingSystems" value="MS Window"/>
			
			
			<input type="submit" value="submit"/>
			
		</form:form>
	</body>
</html>