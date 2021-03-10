<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Objects</title>
</head>
<body>
	<%-- Out --%>
	<%out.println("This is a message from out"); %>
	<%-- Request --%>
	<%-- Response --%>
	<%-- Config --%>
	<%=config.getServletName() %>	
	<%-- Application --%>
	<%-- Session --%>
	<%session.setAttribute("name", "kalin"); %>
	<%="Name is: " + session.getAttribute("name") %>
	<%-- PageContext --%>
	<%pageContext.setAttribute("age", "18"); %>
	<%="Age is: " + pageContext.getAttribute("age") %>
	<%-- Page --%>
	<%-- Exception --%>
</body>
</html>