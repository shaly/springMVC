<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>hello springmvc</h1>
	${requestScope.user.account}--request--${requestScope.user.id}
	<br/>
	${sessionScope.user.account}--session--${sessionScope.user.id}
	<br/>
	*${requestScope.car.name}
	<br/>
	*${sessionScope.car.name}
	<br/>
	${user2.account}----${user2.id}
</body>
</html>