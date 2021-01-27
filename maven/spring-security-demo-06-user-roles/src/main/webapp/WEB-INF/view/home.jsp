<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1> welcome to Home page </h1>
	
	<hr>
	
	<p>
	
	<!-- display username and role -->
	User : <sec:authentication property="principal.username" />
	<br><br>
	Role(s) : <sec:authentication property="principal.authorities" />
	
	</p>
	
	<hr>
	
	
	<sec:authorize access="hasRole('MANAGER')">	
		<!--  show a link /leaders for manager roles -->
	
		<p>
		<a href="${pageContext.request.contextPath}/leaders"> Managers Meeting </a>
		</p>
	
	</sec:authorize>
	
	<sec:authorize access="hasRole('ADMIN')">
			<!--  add a link /admins for admins roles -->
	
		<p>	
		<a href="${pageContext.request.contextPath}/admins"> Admins Meeting </a>
		</p>
	</sec:authorize>
	
	<hr>
	
	<form:form action="${pageContext.request.contextPath}/logout"
					method="POST">
					
		<input type="submit" value="logout" />
		
	 </form:form>
</body>
</html>