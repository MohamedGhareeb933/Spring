
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> student Confirmation Page</title>
</head>
<body>
	Student Name is: ${Student.firstName} ${Student.lastName} 
	<br>
	Country ${Student.country}
	<br>
	Fav Programming Language is: ${Student.favLanguage}
	<br>
	operating systems:
	<ul>
		<c:forEach var="list" items="${Student.operatingSystem}"> 
			<li> ${list} </li>
		</c:forEach>
	</ul>
</body>
</html>