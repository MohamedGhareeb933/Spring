<!-- 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    -->
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> student registration form </title>
</head>
<body>
	<form:form action = "processForm" modelAttribute = "Student">
		first name: <form:input path="firstName" />
		<br><br>
		last name: <form:input path="lastName"/>
		<br><br>
		Country: <form:select path="country" items="${CountryList}" />
		 <br><br>
		 what's you'r favorite programming Language:
		 <br><br>
		 <form:radiobuttons path="favLanguage" items="${Student.languageList}"/>
		 <br><br>
		 <form:checkboxes path="operatingSystem"  items="${Student.operatingSystemList}"/>
		 <br><br>
		<input type="submit" value="submit"/>
	</form:form>
</body>
</html>
