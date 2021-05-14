<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Edit Location Page
<pre>

</pre>

<form action="updateLocation" method="get">
ID :<input type="text" value="${location.locationId}" name=locationId readonly> <br>
Area :<input type="text" name="area" value="${location.area}"> <br>
City: <input type="text" name="city" value="${location.city}"> <br>
AreaType: <br>
Urban:	<input type="radio" name="areatype" value="Urban" ${location.areatype=='Urban'?'checked':""}> <br>
Rural : <input type="radio" name="areatype" value="Rural" ${location.areatype=='Rural'?'checked':""}> <br>
<input type="submit"><br>
</form>

</body>
</html>