<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>コンシェルジュ予約</title>
	<link rel="stylesheet"  href="css/common.css">
</head>
<body>
	<h1>ご相談予約完了</h1>
	<h2>予約完了</h2>
	<p id="touroku">登録できました</p>
	<table class="sousin">
		<tr>
			<th><a href="<c:url value='/reserve.jsp'/>" class="anka" onclick="history.back()">メニューに戻る</a></th>
		</tr>
	</table>
</body>
</html>
