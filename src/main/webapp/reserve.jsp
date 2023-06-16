<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コンシェルジュ予約</title>
<link rel="stylesheet"  href="css/common.css">
<style type="text/css">
#errormsg{
	margin: auto;
	padding: auto;
    color: #C0392B;
	display: inline-block;
    background-color: #f2dede;
	background-image: none;
	border: 1px solid #C0392B;
	border-radius: 4px;
	-moz-border-radius: 4px;
	-moz-user-select: none;
	-ms-touch-action: manipulation;
	-ms-user-select: none;
	-webkit-border-radius: 4px;
	-webkit-user-select: none;
}
#errormsg ul{
	margin:5px 0;	
}
</style>
</head>
<body>
<h1 id="topic">ご相談予約・削除受付</h1>
<h2 id="sub">ご相談内容をお選びください</h2>
<c:if test="${!empty errMsgList}">
	<div id="errormsg">
		<ul>
			<c:forEach items="${errMsgList}" var="err">
				<li>
					<c:out value="${err}" />
				</li>
			</c:forEach>
		</ul>
	</div>
</c:if>
  <div class="cp_hr07">
    <a class="menu" href="<c:url value='/reserveHouse' />">不動産やおうちの修繕</a><br>
    <a class="menu" href="<c:url value='/reserveHelth' />">介護や終活</a><br>
    <a class="menu" href="<c:url value='/reserveInheritance' />">相続</a><br>
    <a class="menu" href="<c:url value='/reserveInsurance' />">車や保険</a><br>
    <a class="menu" href="<c:url value='/reserveFinance' />">金融</a><br>
    <a class="menu" href="<c:url value='/delete' />">予約キャンセル</a>
  </div>
</body>
</html>