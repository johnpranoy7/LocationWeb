<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
AllLocations page
<table>
<tr>
<th>LocationId</th>
<th>Area</th>
<th>City</th>
<th>AreaType</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<c:forEach items="${locations}" var="loc">
<tr>
<td>${loc.locationId}</td>
<td>${loc.area}</td>
<td>${loc.city}</td>
<td>${loc.areatype}</td>
<td><a href="editLocation?id=${loc.locationId}">Edit</a></td>
<td><a href="deleteLocation?id=${loc.locationId}">Delete</a></td>
</tr>
</c:forEach>
</table>
<a href="createLocation">Create Location</a>
<p>The current Area Distribution is </p>
<img alt="404 bro" src="piechart.png">
${message}
</body>
</html>