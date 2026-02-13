<%@ page import="java.util.*,com.wipro.library.bean.LibraryBean" %>
<html>
<head>
<title>All Book Records</title>
</head>
<body>
<%
List<LibraryBean> list = (List<LibraryBean>) request.getAttribute("list");
String msg = (String) request.getAttribute("msg");
if(list != null && !list.isEmpty()){
%>
<h2>All Book Records</h2>
<table border="1">
<tr>
<th>Record ID</th>
<th>Title</th>
<th>Author</th>
<th>Category</th>
<th>Year</th>
<th>Date</th>
<th>Remarks</th>
</tr>
<%
for(LibraryBean b : list){
%>
<tr>
<td><%=b.getRecordId()%></td>
<td><%=b.getBookTitle()%></td>
<td><%=b.getAuthor()%></td>
<td><%=b.getCategory()%></td>
<td><%=b.getPublishedYear()%></td>
<td><%=b.getAddedDate()%></td>
<td><%=b.getRemarks()%></td>
</tr>
<%
}
%>
</table>
<%
}else{
%>
<h3><%=msg%></h3>
<%
}
%>
<br>
<a href="menu.html">Back to Menu</a>
</body>
</html>
