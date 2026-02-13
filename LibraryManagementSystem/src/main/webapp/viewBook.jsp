<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>View Book Record</h2>
<form action="MainServlet" method="post">
<input type="hidden" name="operation" value="viewRecord"/>
Book Title:
<input type="text" name="bookTitle"/><br><br>
Added Date:
<input type="date" name="addedDate"/><br><br>
<input type="submit" value="Search"/>
</form>
</body>
</html>