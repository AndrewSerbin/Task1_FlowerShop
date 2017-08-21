<%@page import="model.entity.Item"%>
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
	<form method="POST" action="SortProductList">
		<input input type="submit" name="sort"
			value="<%=bundle.getString(BundleConstants.SORT)%>">
	</form>
	<form method="POST" action="FindInProductList">
		<p>
			<select size="3" multiple name="StemLength">
				<option disabled><%=bundle.getString(BundleConstants.SELECT_STEM_LENGTH)%></option>
				<option selected value="WITHOUT"><%=bundle.getString(BundleConstants.WITHOUT)%></option>
				<option value="SHORT"><%=bundle.getString(BundleConstants.SHORT)%></option>
				<option value="MEDIUM"><%=bundle.getString(BundleConstants.MEDIUM)%></option>
				<option value="LONG"><%=bundle.getString(BundleConstants.LONG)%></option>
			</select>
		</p>
		<p>
			<input input type="submit" name="find"
				value="<%=bundle.getString(BundleConstants.FIND)%>">
		</p>
	</form>
	<%
	    List<Item> items = (List<Item>) session.getAttribute("items");
	%>
	<table>
		<%
		    for (Item item : items) {
		%>
		<tr>
			<td><%=bundle.getString(BundleConstants.ITEM)%></td>
			<td><%=item.toString()%></td>
			<%
			    }
			%>
	</table>
</body>
</html>