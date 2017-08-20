<%@page import="model.entity.Item"%>
<%@page import="model.entity.boquet.component.plant.Flower"%>
<%@page import="model.entity.boquet.Bouquet"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product list</title>
</head>
<body>
	<%
	    List<Bouquet> bouquets = (List<Bouquet>) session.getAttribute("bouquets");
	%>
	<table>
		<%
		    for (Bouquet bouquet : bouquets) {
		%>
		<tr>
			<td>Bouquet: </td>
			<td><%=bouquet.getName()%></td>
			<td><%=bouquet.getPrice()%></td>
			<td><%=bouquet.getEvent()%></td>
			<td><%=bouquet.getFreshness()%></td>
			<td><%=bouquet.getSize()%></td>
			<td><%=bouquet.getStemLength()%></td>
			<td>
				<%
				    for (Item item : bouquet.getFlowers()) {
				%>
			
					<tr>
						<td>Flower: </td>
						<td><%=item.getName()%></td>
						<td><%=item.getPrice()%></td>
					</tr>
			
				<%
     				}
 				%>
			</td>
			<td>
				<%
				    for (Item item : bouquet.getAccessories()) {
				%>
				
					<tr>
						<td>Accessory: </td>
						<td><%=item.getName()%></td>
						<td><%=item.getPrice()%></td>
					</tr>
				
				<%
     				}
 				%>
			</td>
		</tr>
	<%
	    }
	%>
	</table>
</body>
</html>