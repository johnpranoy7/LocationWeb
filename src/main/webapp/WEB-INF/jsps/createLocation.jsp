<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<pre>
<form action="saveLocation" method="post">
Id: <input type="text" name="locationId">
Area :<input type="text" name="area">
City: <input type="text" name="city">
AreaType:
Urban:	<input type="radio" name="areatype" value="Urban">
Rural : <input type="radio" name="areatype" value="Rural">
<input type="submit">
</form>
${message}
<a href="allLocations" >Display all Locations </a>
</pre>
</body>
</html>