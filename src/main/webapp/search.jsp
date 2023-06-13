<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date, java.text.DateFormat" %>
<%!
  //メソッドの宣言
  private String GetDate() {
    DateFormat df = DateFormat.getTimeInstance(DateFormat.LONG);
    Date date = new Date();
    return df.format(date);
  }
%>
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
<table id="table" border="1" height="200" width="700">
<form  action="" method="post">
<tr>
      <td>日付</td>
      <c:forEach items="${ReserveDateList}" var="data" varStatus="i" end="6">
      <td><%= GetDate()%></td>
      </c:forEach>
</tr> 
<tr>
      <td>10:00∼11:00</td>
      <c:forEach items="${ReserveDateList}" var="data" varStatus="i" end="6">
      <td>
      	<c:choose>
      		<c:when test="${!empty data}">
      			×
      		</c:when>
      		<c:when test="${empty data}">
      			<input type="radio" name="reserve_date" value="${i.count}-1">○
      		</c:when>
      	</c:choose>
      </td>
      </c:forEach>
</tr>
<tr>
      <td></td>
      <c:forEach items="${ReserveDateList}" var="data" varStatus="i+7" end="6">
      <td>
      	<c:choose>
      		<c:when test="${!empty data}">
      			×
      		</c:when>
      		<c:when test="${empty data}">
      			<input type="radio" name="reserve_date" value="${i.count}-1">○
      		</c:when>
      	</c:choose>
      </td>
      </c:forEach>
</tr>
<tr>
      <td></td>
      <c:forEach items="${ReserveDateList}" var="data" varStatus="i+14" end="6">
      <td>
      	<c:choose>
      		<c:when test="${!empty data}">
      			×
      		</c:when>
      		<c:when test="${empty data}">
      			<input type="radio" name="reserve_date" value="${i.count}-1">○
      		</c:when>
      	</c:choose>
      </td>
      </c:forEach>
</tr>
<tr>
      <td></td>
      <c:forEach items="${ReserveDateList}" var="data" varStatus="i+21" end="6">
      <td>
      	<c:choose>
      		<c:when test="${!empty data}">
      			×
      		</c:when>
      		<c:when test="${empty data}">
      			<input type="radio" name="reserve_date" value="${i.count}-1">○
      		</c:when>
      	</c:choose>
      </td>
      </c:forEach>
</tr>
<tr>
      <td></td>
      <c:forEach items="${ReserveDateList}" var="data" varStatus="i+28" end="6">
      <td>
      	<c:choose>
      		<c:when test="${!empty data}">
      			×
      		</c:when>
      		<c:when test="${empty data}">
      			<input type="radio" name="reserve_date" value="${i.count}-1">○
      		</c:when>
      	</c:choose>
      </td>
      </c:forEach>
</tr>
<tr>
      <td></td>
      <c:forEach items="${ReserveDateList}" var="data" varStatus="i+35" end="6">
      <td>
      	<c:choose>
      		<c:when test="${!empty data}">
      			×
      		</c:when>
      		<c:when test="${empty data}">
      			<input type="radio" name="reserve_date" value="${i.count}-1">○
      		</c:when>
      	</c:choose>
      </td>
      </c:forEach>
</tr>
<tr>
      <td></td>
      <c:forEach items="${ReserveDateList}" var="data" varStatus="i+42" end="6">
      <td>
      	<c:choose>
      		<c:when test="${!empty data}">
      			×
      		</c:when>
      		<c:when test="${empty data}">
      			<input type="radio" name="reserve_date" value="${i.count}-1">○
      		</c:when>
      	</c:choose>
      </td>
      </c:forEach>
</tr>
<tr>
      <td></td>
      <c:forEach items="${ReserveDateList}" var="data" varStatus="i+49" end="6">
      <td>
      	<c:choose>
      		<c:when test="${!empty data}">
      			×
      		</c:when>
      		<c:when test="${empty data}">
      			<input type="radio" name="reserve_date" value="${i.count}-1">○
      		</c:when>
      	</c:choose>
      </td>
      </c:forEach>
</tr>
<tr>
      <td></td>
      <c:forEach items="${ReserveDateList}" var="data" varStatus="i+56" end="6">
      <td>
      	<c:choose>
      		<c:when test="${!empty data}">
      			×
      		</c:when>
      		<c:when test="${empty data}">
      			<input type="radio" name="reserve_date" value="${i.count}-1">○
      		</c:when>
      	</c:choose>
      </td>
      </c:forEach>
</tr>
<tr>
      <td></td>
      <c:forEach items="${ReserveDateList}" var="data" varStatus="i+63" end="6">
      <td>
      	<c:choose>
      		<c:when test="${!empty data}">
      			×
      		</c:when>
      		<c:when test="${empty data}">
      			<input type="radio" name="reserve_date" value="${i.count}-1">○
      		</c:when>
      	</c:choose>
      </td>
      </c:forEach>
</tr>
<tr>
      <td></td>
      <c:forEach items="${ReserveDateList}" var="data" varStatus="i+70" end="6">
      <td>
      	<c:choose>
      		<c:when test="${!empty data}">
      			×
      		</c:when>
      		<c:when test="${empty data}">
      			<input type="radio" name="reserve_date" value="${i.count}-1">○
      		</c:when>
      	</c:choose>
      </td>
      </c:forEach>
</tr>
</table><br>
  <table>
      <tr>
        <th class="nyuuryoku">お名前：</th>
        <td><input name="name" type="text" class="namae" maxlength="8" </td>
      </tr>
      <tr>
        <th class="nyuuryoku">電話：<br class="tyuui">※ハイフンなし、半角でご記入下さい。</th>
        <td><input name="call" type="text" class="denwa" maxlength="8"></td>
      </tr>
      <tr>
        <th class="nyuuryoku">メールアドレス：</th>
        <td><input name="mail" type="text" class="meado" maxlength="8"></td>
      </tr>
    </table>
    <p><input type="submit" value="送信する" class="botton"></p>


  </form>

</body>
</html>