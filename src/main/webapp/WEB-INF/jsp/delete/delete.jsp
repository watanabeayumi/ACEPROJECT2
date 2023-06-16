<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コンシェルジュ予約</title>
<link rel="stylesheet"  href="<c:url value='/css/common.css'/>"css/common.css">
</head>
<body>
<h1>ご相談予約削除</h1>
<h2>ご入力下さい</h2>
<form  action="<c:url value='/delete'/>" method="post">
	<table class="table">
		<tr>
			<th class="nyuuryoku">お名前：</th>
			<td><input name="name" type="text"></td>
		</tr>
		<c:forEach var="i" begin="0" end="7" step="1">
		<tr>
			<th></th>
			<td></td>
		</tr>
			</c:forEach>
		<tr>
			<th class="nyuuryoku">電話：</th>
			<td><input name="call" type="text"></td>
		</tr>
		<br>
		<tr>
			<th class="th">※ハイフンなし、半角でご記入下さい。</th>
			
		</tr>
		<tr>
			<th class="nyuuryoku">メールアドレス：</th>
			<td><input name="mail" type="text"></td>
		</tr>
	</table>

<table class="sousin">
<tr>
<th><a href="<c:url value='/reserve.jsp'/>" class="anka" onclick="history.back()">メニューに戻る</a></th>
<th><input type="submit" value="送信する" class="botton"></th>
</form>
</tr>
</table>
</body>
</html>

