<%@page import="dao.CartDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

	int cartid = Integer.parseInt(request.getParameter("cartid"));
	CartDao.removeCourseFromCart(cartid);
	
	response.sendRedirect("user-cart.jsp");

%>


</body>
</html>