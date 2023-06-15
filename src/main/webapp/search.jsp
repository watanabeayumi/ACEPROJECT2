<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コンシェルジュ予約</title>
<link rel="stylesheet"  href="css/common.css">
</head>
<body>
<h1>ご相談予約</h1>
<h2>ご相談日時を選択し、入力事項をご入力下さい</h2>
<form  action="reserveConfirm" method="post">
	<table class="table" border="1" height="200" width="900">
		<tr>
			<td>日付</td>
			<c:forEach items="${WeekList}" var="data" varStatus="i" end="6">
				<td><c:out value="${data}" /></td>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach items="${ReserveDateList}" var="data" varStatus="i" end="69" >
				<c:if test="${i.count % 7 == 1}">
					<td>
						<fmt:formatNumber maxFractionDigits="0" value="${(i.count + 6) / 7 + 9}"/>:00∼
						<fmt:formatNumber maxFractionDigits="0" value="${(i.count + 6) / 7 + 10}"/>:00
					</td>
				</c:if>
				<td>
					<c:choose>
						<c:when test="${data == null}">
							<input type="radio" name="reserve_date" value="${i.count}" id="maru">
							<label for="maru"></label>
						</c:when>
						<c:when test="${data != null}">
							<label id="batu">×</label>
						</c:when>
					</c:choose>
				</td>
				<c:if test="${i.count % 7 == 0}">
					</tr>
					<tr>
				</c:if>
			</c:forEach>
		</tr>   
	</table>
	<br>
	<table class="table">
		<tr>
			<th class="nyuuryoku">お名前：</th>
			<td><input name="name" type="text" class="namae" ></td>
		</tr>
		<br>
		<tr>
			<th class="nyuuryoku">電話：<h6 id="tyuui">※ハイフンなし、半角でご記入下さい。</h6></th>
			<td><input name="call" type="text" class="denwa" ></td>
		</tr>
		<br>
		<tr>
			<th class="nyuuryoku">メールアドレス：</th>
			<td><input name="mail" type="text" class="meado" ></td>
		</tr>
		<br>
	</table>
	<table class="sousin">
<tr><th><a href="<c:url value='/reserve.jsp'/>" class="anka" onclick="history.back()">メニューに戻る</a></th>
<th><input type="submit" value="送信する" class="botton"></th>
	</form>
	</tr>
</table>
</body>
</html>