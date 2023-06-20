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
		<c:if test="${!empty NameErr}">
		<tr>
			<th class="errormsg"><c:out value="${NameErr}"/></th>
		</tr>
		</c:if>
			
			
		<tr>
			<th class="nyuuryoku">電話：</th>
			<td><input name="call" type="tel" pattern="[0-9]{10,11}" maxlength="11"></td>
		</tr>

		<tr>
			<th class="th">※ハイフンなし、半角</th>
		</tr>
		<c:if test="${!empty CallErr}">
			<c:forEach items="${CallErr}" var="err">
				<tr>
					<th class="errormsg"><c:out value="${err}"/></th>
				</tr>
			</c:forEach>
		</c:if>
		
		<tr>
			<th class="nyuuryoku">メールアドレス：</th>
			<td><input name="mail" type="email"></td>
		</tr>
		
		<c:if test="${!empty MailErr}">
			<tr>
				<th class="errormsg"><c:out value="${MailErr}"/></th>
			</tr>
		</c:if>
	</table>
	<table class="sousin">
		<tr>
			<th>
				<a href="<c:url value='/reserve.jsp'/>" class="anka" onclick="history.back()">メニューに戻る</a>
			</th>
			<th>
				<input type="submit" value="送信する" class="botton">
			</th>
		</tr>
	</table>
</form>
</body>
</html>

