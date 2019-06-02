<%@page import="com.bean.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body>
	<%
		if (request.getAttribute("arr") == null) {
	%>
	<p>No Data Exits !</p>
	<a href="index.jsp">BACK</a>

	<%
		} else {
			ArrayList<Student> arr = (ArrayList<Student>) request.getAttribute("arr");
	%>
	<table border=1 align="center">
		<tr style="background-color: red; color: white">
			<th>ID</th>
			<th>Name</th>
		</tr>
		<%
			for (Student s : arr) {
		%>
		<tr>
			<td><%=s.getId()%></td>
			<td><%=s.getName()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		}
	%>
</body>
</html>