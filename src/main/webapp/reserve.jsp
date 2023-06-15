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
<h1 id="topic">ご相談予約・削除受付</h1>
<h2 id="sub">ご相談内容をお選びください</h2>
 
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