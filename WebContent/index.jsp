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

<h2><span>Interval:  <input id="timer" placeholder="60"></input></span></h2>

<form method="get" action="index">
	<button type="submit"> Show history </button>
</form>

${ stock.getStockName() }

</body>
</html>