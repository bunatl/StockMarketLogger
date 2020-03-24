<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stock Market Logger Working</title>
</head>

<body>
<h1> Logger Index </h1>

<form id="myForm" method="POST" action="index">
	<button type="submit"> Update </button>
</form>

<form id="myForm2" method="POST" action="history">
	<button type="submit"> Show history </button>
</form>

  ${ stock.getStockName() }
  <br>
  ${ stock.getStockPrice() }



</body>
</html>