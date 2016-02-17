<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Book</title>
</head>
<body>

<a href="/library-client/Main">Home</a>
<br />
<h2>Add Book</h2>

<form method="post" action="/library-client/Main">
<input type="hidden" name="action" value="addbook" />
<table cellspacing="1">

	<tr>
		<td>Book Title: </td>
		<td><input type="text" name="title" id="title"></td>
	</tr>					

	<tr>
		<td>Book Author: </td>
		<td><input type="text" name="author" id="author"></td>
	</tr>
	
	<tr>
		<td><input type="submit" name="btnsubmit" value="Save" /></td>
		<td><input type="reset" name="btnclear" id="btnclear"></td>
	</tr>		
</table>
</form>

</body>
</html>