<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Private cabinet</title>
</head>
<body>
	<p><a href="Transaction">Transaction</a> | <a href="Test2">Test2</a>

	<table border="1">
	 <caption>Your bill:</caption>
	   <tr>
	    <th>№</th>
	    <th>ID</th>
	    <th>cash</th>
	   </tr>
	            <tr>
	            <td><%=1%></td>
	            <td><%=request.getAttribute("billId")%></td>
	            <td><%=request.getAttribute("cash")%></td>
	   </tr >
	</table>
</body>
</html>