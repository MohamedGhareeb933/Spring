<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> list customers </title>

<!--  reference to Css File -->

<link type="text/css" 
	  rel="stylesheet"
	  href="${pageContext.request.contextPath}/resources/css/style.css"  >
	  
</head>
<body>
	<div id="Wrapper">
		<div id="header">
		<h2> CRM - Customer Relationship Manager </h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
		<!--  add new Button add Customer -->
		<input type="button" value="add Customer"
			onclick="window.location.href='showFormForAdd'; return false";
			class="add-button" />
			
			<!--  add search Box  -->
			<form:form action="search" method="GET">
				Search Customer 
				<input type="text" name="searchCustomer" />
				<input type="submit" value="search" class="add-button"/>	
			</form:form>
			
		<!--  add  HTML Table -->
		<table>
			<tr>
				<th> First name </th>
				<th> Last name </th>
				<th> Email </th>
				<th> Action </th>
				
			</tr>
			
					<!-- iterate and add Customer list  -->
			<c:forEach var="tempCustomer" items="${customerList}">
			
			<!--  construct an update link to customer id  -->
			<c:url var="updateLink" value="/customer/showFormForUpdate">
				<c:param name="customerId" value="${tempCustomer.id}" />
			</c:url>
			
			<!--  construct an delete link to customer id  -->
			<c:url var="deleteLink" value="/customer/delete">
				<c:param name="customerId" value="${tempCustomer.id}" />
			</c:url>
			
					<!--  Table Row -->
			<tr> 
					<!--  Table Data/cell -->
				<td> ${tempCustomer.firstName} </td> 
				<td> ${tempCustomer.lastName} </td>
				<td> ${tempCustomer.email} </td>
				
				<!--  Display an update Link -->
			 	<td>
			 		<a href="${updateLink}" > Update </a>
			 		|
			 		<a href="${deleteLink}" onclick="return confirm('are you sure you want to delete this customer');"> Delete </a>
			 		
			 	</td>
			 	
			 </tr>
			 
			</c:forEach>
		</table>
		
		</div>
	</div>
</body>
</html>