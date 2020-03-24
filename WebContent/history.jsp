<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>History records</title>
</head>
<body>

<h1> History of APPLE </h1>

<!-- https://stackoverflow.com/questions/23627393/display-a-set-of-objects-in-jsp-page-with-spring-mvc -->
<ul>
<c:forEach var="row" items="${allStocks}">
    <li>${row}</li>
</c:forEach>
</ul>

</body>
</html>