<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="LoginController">
<input type="text"  name="action" hidden="true" value="LOG_IN"/>
username: <input type="text" name="username"> <br>
password: <input type="password" name="password"> <br>
<input type="submit" value="login">

</form>

</body>
</html>