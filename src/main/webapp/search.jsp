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

<h1>ご相談予約</h1>
<h2>ご相談日時を選択し、入力事項をご入力下さい</h2>
<table id="table" border="1" height="200" width="700">
<form  action="" method="post">
<tr>
      <td>日付</td>
      <c:forEach items="${WeekList}" var="data" varStatus="i" end="6">
      <td><c:out value="${data}" /></td>
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
      <td>11:00∼12:00</td>
      <c:forEach items="${ReserveDateList}" var="data" varStatus="i+7" end="6">
      <td>
      	<c:choose>
      		<c:when test="${!empty data}">
      			×
      		</c:when>
      		<c:when test="${empty data}">
      			<input type="radio" name="reserve_date" value="${i.count}-2">○
      		</c:when>
      	</c:choose>
      </td>
      </c:forEach>
</tr>
<tr>
      <td>12:00∼13:00</td>
      <c:forEach items="${ReserveDateList}" var="data" varStatus="i+14" end="6">
      <td>
      	<c:choose>
      		<c:when test="${!empty data}">
      			×
      		</c:when>
      		<c:when test="${empty data}">
      			<input type="radio" name="reserve_date" value="${i.count}-3">○
      		</c:when>
      	</c:choose>
      </td>
      </c:forEach>
</tr>
<tr>
      <td>13:00∼14:00</td>
      <c:forEach items="${ReserveDateList}" var="data" varStatus="i+21" end="6">
      <td>
      	<c:choose>
      		<c:when test="${!empty data}">
      			×
      		</c:when>
      		<c:when test="${empty data}">
      			<input type="radio" name="reserve_date" value="${i.count}-4">○
      		</c:when>
      	</c:choose>
      </td>
      </c:forEach>
</tr>
<tr>
      <td>14:00∼15:00</td>
      <c:forEach items="${ReserveDateList}" var="data" varStatus="i+28" end="6">
      <td>
      	<c:choose>
      		<c:when test="${!empty data}">
      			×
      		</c:when>
      		<c:when test="${empty data}">
      			<input type="radio" name="reserve_date" value="${i.count}-5">○
      		</c:when>
      	</c:choose>
      </td>
      </c:forEach>
</tr>
<tr>
      <td>15:00∼16:00</td>
      <c:forEach items="${ReserveDateList}" var="data" varStatus="i+35" end="6">
      <td>
      	<c:choose>
      		<c:when test="${!empty data}">
      			×
      		</c:when>
      		<c:when test="${empty data}">
      			<input type="radio" name="reserve_date" value="${i.count}-6">○
      		</c:when>
      	</c:choose>
      </td>
      </c:forEach>
</tr>
<tr>
      <td>16:00∼17:00</td>
      <c:forEach items="${ReserveDateList}" var="data" varStatus="i+42" end="6">
      <td>
      	<c:choose>
      		<c:when test="${!empty data}">
      			×
      		</c:when>
      		<c:when test="${empty data}">
      			<input type="radio" name="reserve_date" value="${i.count}-7">○
      		</c:when>
      	</c:choose>
      </td>
      </c:forEach>
</tr>
<tr>
      <td>17:00∼18:00</td>
      <c:forEach items="${ReserveDateList}" var="data" varStatus="i+49" end="6">
      <td>
      	<c:choose>
      		<c:when test="${!empty data}">
      			×
      		</c:when>
      		<c:when test="${empty data}">
      			<input type="radio" name="reserve_date" value="${i.count}-8">○
      		</c:when>
      	</c:choose>
      </td>
      </c:forEach>
</tr>
<tr>
      <td>18:00∼19:00</td>
      <c:forEach items="${ReserveDateList}" var="data" varStatus="i+56" end="6">
      <td>
      	<c:choose>
      		<c:when test="${!empty data}">
      			×
      		</c:when>
      		<c:when test="${empty data}">
      			<input type="radio" name="reserve_date" value="${i.count}-9">○
      		</c:when>
      	</c:choose>
      </td>
      </c:forEach>
</tr>
<tr>
      <td>19:00∼20:00</td>
      <c:forEach items="${ReserveDateList}" var="data" varStatus="i+63" end="6">
      <td>
      	<c:choose>
      		<c:when test="${!empty data}">
      			×
      		</c:when>
      		<c:when test="${empty data}">
      			<input type="radio" name="reserve_date" value="${i.count}-10">○
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