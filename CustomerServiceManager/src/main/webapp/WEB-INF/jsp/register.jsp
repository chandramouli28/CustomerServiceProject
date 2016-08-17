<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	Hi! 
	You are successfully registered
	
		<table >
		
		<tr>
			<td>User Name:</td>
			<td>${customer.getUsername()}</td>
		</tr>
		<tr>
			<td>Email:</td>
			<td>${customer.getEmail()}</td>
		</tr>
		<tr>
			<td>PhoneNumber:</td>
			<td>${customer.getPhoneNum()}</td>
		</tr>
		<tr>
			<td>Service Id:</td>
			<td>${customer.getService_id()}</td>
		</tr>
	</table>
	
</body>
</html>