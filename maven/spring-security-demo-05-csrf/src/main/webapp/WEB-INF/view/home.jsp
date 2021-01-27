<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1> welcome to Home page </h1>
	
	<form:form action="${pageContext.request.contextPath}/logout" 
					method="POST">
					
		<input type="submit" value="logout" />
		
	 </form:form>
</body>
</html>