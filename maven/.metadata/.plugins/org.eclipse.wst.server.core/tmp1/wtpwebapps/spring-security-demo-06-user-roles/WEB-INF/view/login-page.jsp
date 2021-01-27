<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Login page </title>
<link rel="stylesheet" type="text/css" href="css/demo.css"/>
</head>
<body>
	<h3> my custom login page </h3>
	
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser "
					method="POST">
					
		<!--  check for ERORR LOGIN -->
		<c:if test="${param.error != null}"> <!--  if there's no error message  -->
			<i class="failed"> sorry ! invalid username/password </i>
		</c:if> 
					
		<!-- name must be exact username and password name for Spring security -->
		<p> User name: <input type="text" name="username" /> </p>
		<p> Password: <input type="password" name="password"/> </p>
		
		<input type="submit" value="login"/>
		
	</form:form>

</body>
</html>