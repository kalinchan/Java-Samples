<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
<%
	try{
	if(request.getParameter("name") == null || request.getParameter("name").isEmpty()){
		throw new IllegalArgumentException();
	}
	out.println("Hello " + request.getParameter("name"));
	}catch(IllegalArgumentException e){
		out.println(e);
	}
%>
</body>
</html>