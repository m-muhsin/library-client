<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get All Books</title>
</head>
<body>

<a href="/library-client/Main">Home</a>
<br />
<h2>All Books</h2>

<table cellspacing="10">
<tr>
	<th>ID</th>
	<th>Title</th>
	<th>Author</th>
</tr>
<c:forEach items="${res}" var="book" varStatus="counter">
	<tr>
		<td>${book.id}</td>
		<td>${book.title}</td>
		<td>${book.author}</td>
	</tr>					
</c:forEach>
</table>
</body>
</html>