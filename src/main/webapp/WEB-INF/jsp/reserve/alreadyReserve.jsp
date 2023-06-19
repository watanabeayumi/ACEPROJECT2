<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>既に予約があります。</title>
</head>
<body>
<p>相談内容：<c:out value="${AlreadyReserve.conciergeName}"/></p>
<p>日付：<c:out value="${AlreadyReserve.reserveDate}" /></p>
<p>時間：<c:out value="${AlreadyReserve.timeName}" /></p>
<p>名前：<c:out value="${AlreadyReserve.name}" /></p>
<p>電話：<c:out value="${AlreadyReserve.call}" /></p>
<p>メール：<c:out value="${AlreadyReserve.mail}" /></p>
の内容で既に予約が入っています。<br>
申し訳ございませんが、予約は1人1件までとさせていただいております。<br>
<table class="sousin">
	<tr>
		<th><a href="<c:url value='/reserve.jsp'/>" class="anka" onclick="history.back()">メニューに戻る</a></th>
	</tr>
</table>
</body>
</html>