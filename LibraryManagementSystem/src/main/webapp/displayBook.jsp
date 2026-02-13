<%@ page import="com.wipro.library.bean.LibraryBean" %>
<html>
<head>
<title>Book Details</title>
</head>
<body>
<%
LibraryBean bean = (LibraryBean) request.getAttribute("bean");
String msg = (String) request.getAttribute("msg");
if(bean != null){
%>
<h2>Book Details</h2>
Record ID: <%=bean.getRecordId()%><br><br>
Book Title: <%=bean.getBookTitle()%><br><br>
Author: <%=bean.getAuthor()%><br><br>
Category: <%=bean.getCategory()%><br><br>
Published Year: <%=bean.getPublishedYear()%><br><br>
Added Date: <%=bean.getAddedDate()%><br><br>
Remarks: <%=bean.getRemarks()%><br><br>
<%
} else {
%>
<h3><%=msg%></h3>
<%
}
%>
<br>
<a href="menu.html">Back to Menu</a>
</body>
</html>
