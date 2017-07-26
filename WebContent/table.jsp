<%@page import="java.sql.SQLException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Table of users</title>
</head>
 <body>
 	
 	<%ResultSet res =(ResultSet) request.getAttribute("res");
 	  int count = 1;
 	  String userId;
 	%>
    <B> Список </B>
    
    <table border = 1>
	       <caption>List of users</caption>
	   <tr>
	    <th>№</th>
	    <th>ID</th>
	    <th>username</th>
	    <th>password</th>
	   </tr>
	    
	    <%
	    res.first();
	    try {
	    	userId = res.getString(1);%>
	            <tr>
	            <td><%=count++%></td>
	            <td><%=res.getString(1)%></td>
	            <td><%=res.getString(2)%></td>
	            <td><%=res.getString(3)%></td>
	            </tr >
	            
    </table>
      
    <form action="UpdateBill" method="POST">
    	<p>User id: <input readonly name="userid" value="<%=userId%>"></p>
	    <p>Input new balance: <input type="text" name="balance"></p>
	    <input type="submit" value="Отправить" />
	</form>
	<%} catch (SQLException e) {
	    	throw new ServletException(e);
	  }%>
	
	
</body>
</html>