<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Confirmation</title>
</head>
<body>
	Welcome ${customer.firstName} ${ customer.lastName }
	<br><br>
	you have ${ customer.freePasses } free Passes
	<br><br>
	postal Code is : ${ customer.postalCode }
	<br><br>
	course Code is: ${ customer.courseCode }
	
</body>
</html>