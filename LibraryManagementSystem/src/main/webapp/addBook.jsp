<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Add Book Record</h2>
<form action="MainServlet" method="post">
<input type="hidden" name="operation" value="newRecord"/>
Book Title: <input type="text" name="bookTitle"/><br><br>
Author: <input type="text" name="author"/><br><br>
Category: <input type="text" name="category"/><br><br>
Published Year: <input type="text" name="year"/><br><br>
Added Date: <input type="date" name="addedDate"/><br><br>
Remarks: <input type="text" name="remarks"/><br><br>
<input type="submit" value="Add Book"/>
</form>
</body>
</html>