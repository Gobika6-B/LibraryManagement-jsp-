<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>View All Book Records</h2>
<form action="MainServlet" method="post">
<input type="hidden" name="operation" value="viewAllRecords"/>
<input type="submit" value="Show All Books"/>
</form>
</body>
</html>