<%@page import="model.entity.Item"%>
<%@page import="model.entity.boquet.component.plant.Flower"%>
<%@page import="model.entity.boquet.Bouquet"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ResourceBundle"%>
<%@page import="servlet.util.bundle.BundleConstants"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product list</title>
</head>
<body>
	<%
    	ResourceBundle bundle = (ResourceBundle) session.getAttribute("bundle");
	%>
	<form method="POST" action="SortProductList" >
		<input input type="submit" name="sort" value="<%=bundle.getString(BundleConstants.SORT)%>">
	</form>
	<form method="POST" action="FindInProductList" >
		<p>
			<select size="3" multiple name="StemLength">
    			<option disabled><%=bundle.getString(BundleConstants.SELECT_STEM_LENGTH)%></option>
    			<option selected value="WITHOUT"><%=bundle.getString(BundleConstants.WITHOUT)%></option>
    			<option value="SHORT"><%=bundle.getString(BundleConstants.SHORT)%></option>
    			<option value="MEDIUM"><%=bundle.getString(BundleConstants.MEDIUM)%></option>
    			<option value="LONG"><%=bundle.getString(BundleConstants.LONG)%></option>
   			</select>
   		</p>
   		<p><input input type="submit" name="find" value="<%=bundle.getString(BundleConstants.FIND)%>"></p>
	</form>
	<%
	    List<Bouquet> bouquets = (List<Bouquet>) session.getAttribute("bouquets");
	%>
	<table>
		<%
		    for (Bouquet bouquet : bouquets) {
		%>
		<tr>
			<td><%=bundle.getString(BundleConstants.BOUQUET)%></td>
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
						<td><%=bundle.getString(BundleConstants.FLOWER)%></td>
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
						<td><%=bundle.getString(BundleConstants.ACCESSORY)%></td>
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