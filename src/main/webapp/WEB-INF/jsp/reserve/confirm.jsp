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
<h1>予約確認</h1>
<p>相談内容：<c:out value="${conciergeName}"/></p>
<p>日付：<c:out value="${ReserveSearchFlowBean.reserveDate}" /></p>
<p>時間：<c:out value="${ReserveSearchFlowBean.timeName}" /></p>
<p>名前：<c:out value="${ReserveSearchFlowBean.name}" /></p>
<p>電話：<c:out value="${ReserveSearchFlowBean.call}" /></p>
<p>メール：<c:out value="${ReserveSearchFlowBean.mail}" /></p>
<table class="sousin">
<tr>
<th><a href="<c:url value='/reserve.jsp'/>" class="anka" onclick="history.back()">メニューに戻る</a></th>
<th><a  class="anka" href="<c:url value='/reserveComplete' />">予約する</a></th>
	</form>
</tr>
</table>
</body>
</html>
