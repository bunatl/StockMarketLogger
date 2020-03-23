<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stock Market Logger Working</title>
</head>

 <script type="text/javascript">
 function refreshRate(){
	 var timerSec = document.getElementById("timer").value;
	 //if ( timerSec == null )
		// timerSec = 60;
	// console.log( timerSec*1000 );
	 
	 //setTimeout( document.getElementById("myForm").submit(), console.log("heya"),
			// timerSec*1000 );
 }
 </script>

<body>
<h1> Logger Index </h1>



<form id="myForm" method="POST" action="index">
	<h2><span>Interval:  <input name="timer" id="timer" value="${timer}"></input></span></h2>
	<button type="submit"> Update </button>
	<button type="button" onclick="refreshRate()"> Update Timer </button>
</form>

<form id="myForm2" method="POST" action="history">
	<button type="submit"> Show history </button>
</form>

${ stock.getStockName() }


</body>
</html>