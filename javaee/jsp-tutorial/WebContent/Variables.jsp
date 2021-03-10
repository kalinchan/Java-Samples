<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Variables</title>
</head>
<body>
<%--Declare Variables Here Syntax: <%! {type} {name}%>--%>
<%!int count =0; %>
<%--Scriptlet Under here Syntax: <% java code here %>--%>
<% out.println("The count is: " + count + " from a scriptlet <br>"); %>

<%--JSP expression under here  <%= expression%>--%>
<%="The count is: " + count %>
</body>
</html>