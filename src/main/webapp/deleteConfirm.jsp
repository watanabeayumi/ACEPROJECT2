<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コンシェルジュ予約</title>
<link rel="stylesheet"  href=<c:url value="css/common.css" />
</head>
<body>
<h1>削除確認</h1>
<h2>以下の予約内容を削除されますか？</h2>
<form action="<c:url value='/deleteComplete' />"  method="post">
	<p>日付：
		<c:out value="${DeleteFlowBean.reserveDate}" />
	</p><br>
	<p>時間：
		<c:out value="${DeleteFlowBean.timeName}" />
	</p><br>
	<p>相談内容：
		<c:out value="${DeleteFlowBean.conciergeName}" />
	</p><br>
	<p>名前：
		<c:out value="${DeleteFlowBean.name}" />
	</p><br>
	<p>電話：
		<c:out value="${DeleteFlowBean.tel}" />
	</p><br>
	<p>メール：
		<c:out value="${DeleteFlowBean.address}" />
	</p><br>
<table class="sousin">
<tr>
<th><a href="<c:url value='/delete.jsp'/>" class="anka" onclick="history.back()">戻る</a></th>
<th><input type="submit" value="削除する" class="botton"></th>
</form>
</tr>
</table>
</body>
</html>
