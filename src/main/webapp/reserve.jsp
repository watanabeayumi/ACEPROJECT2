<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.time.*,java.time.format.DateTimeFormatter,java.time.temporal.TemporalAdjusters" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>コンシェルジュ予約</title>


<link rel="stylesheet"  href="css/common.css">

</head>
<body>
<h1><font size="80">ご相談予約・削除受付</font></h1>
<h2><font size="70">ご相談内容をお選びください</font></h2>
<hr class="cp_hr07" />
<div id="">
  <div class="">
    <a href="<c:url value='reserveHouse' />" id="" class="button">不動産やおうちの修繕</a><br>
    <a href="<c:url value='reserveHelth' />" id="" class="button">介護や終活</a><br>
    <a href="<c:url value='reserveInheritance' />" id="" class="button">相続</a><br>
    <a href="<c:url value='reserveInsurance' />" id="" class="button">車や保険</a><br>
    <a href="<c:url value='reserveFinance' />" id="" class="button">金融</a><br>
    <a href="<c:url value='' />" id="" class="button">予約キャンセル</a>
  </div>
</div>
</body>
</html>