<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コンシェルジュ予約</title>
<link rel="stylesheet"  href="css/common.css">

<style>
input[type=radio] {
display: none; /* ラジオボタンを非表示にする */
}
.label {
margin: 5px; /* ラベル外側の余白を指定する */
border: 1px solid #006DD9;/* ラベルの境界線を実線で指定する */
}
</style>

</head>
<body>

<h1>ご相談予約</h1>
<h2>ご相談日時を選択し、入力事項をご入力下さい</h2>
<table id="table" border="1" height="300" width="1100">
<form  action="" method="post">
<tr>
      <td>日付</td>
      <c:forEach items="${WeekList}" var="data" varStatus="i" end="6">
      <td><c:out value="${data}" /></td>
      </c:forEach>
</tr> 

<tr>
	<c:forEach items="${ReserveDateList}" var="data" varStatus="i" end="69">
      <c:if test="${i.count % 7 == 1}">
      	<td>
      		<c:out value="${(i.count + 6) / 7 + 9}" />:00∼<c:out value="${(i.count + 6) / 7 + 10}" />:00
      	</td>
      </c:if>
      <td>
      	<c:choose>
      		<c:when test="${!empty data}">
      			<p id="batu">×</p>
      		</c:when>
      		
      		<c:when test="${empty data}">
      			<input type="radio" name="reserve_date" value="${i.count}" id="maru">
      			<label for="maru" class="label">○</label>
      		</c:when>
      	</c:choose>
      </td>
      <c:if test="${i.count % 7 == 0}">
      	</tr>
      	<tr>
      </c:if>
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