<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Book</title>
</head>
<body>

	<a href="/library-client/Main">Home</a>
	<br />
	<h2>Get Books</h2>

	<div>

		<label>Book ID: </label> <input type="text" name="bookid" id="bookid">

		<input type="hidden" name="action" value="getbook" /> <input
			type="button" value="Search" id="btnSearch" />

	</div>
	<br />
	<div id="bookDetails" >
	
	</div>

	<script type="text/javascript" src="js/jquery-1.12.0.min.js"></script>
	<script>
	$("#btnSearch").click(function() {
		var bookId = $("#bookid").val();
		console.log(bookId);
		$.get("Main",
			{
				action: "getbook",
				bookid: bookId
			},
			function(reply) {
				console.log("reply: "+reply);
				var data = JSON.parse(reply);
				if(data !== null) {
					$("#bookDetails").html(
						'<p>ID: '+ data.id +'</p>' +
						'<p>Title: '+ data.title +'</p>' +
						'<p>Author: '+ data.author +'</p>'
					);
				} else {
					$("#bookDetails").html('No records found!');
				}
				
			});
	});
</script>

</body>
</html>