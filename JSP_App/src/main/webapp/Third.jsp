<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! Date d1 = new Date(); %>
	<%= d1.getHours() %> : <%= d1.getMinutes() %> : <%= d1.getSeconds() %>
</body>
</html>