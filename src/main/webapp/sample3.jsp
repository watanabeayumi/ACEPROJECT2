<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="shortcut icon" href="./images/favicon.ico">
	<title>QuaggaJS</title>
	<!-- CSS --> 
	<link rel="stylesheet" href="css/custom.css">
</head>
<body>
	<div id="my_container">
		<div id="my_inner">
			<div>= QuaggaJS =</div>
			<div>
				<button id="my_start">Start</button>
				<button id="my_stop">Stop</button>
			</div>
			<div id="my_quagga"></div>
			<div id="my_result">***</div>
			<div id="my_barcode">
				<div>***</div>
			</div>
		</div>
	</div>
	<!-- JavaScript -->
	<script src="js/code.jquery.com_jquery-3.7.0.min.js"></script>
	<script src="js/quagga.js"></script>
	<script src="js/main.js"></script>
</body>
</html>