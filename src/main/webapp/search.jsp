<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      <td>6/15</td>
      <td>6/16</td>
      <td>6/17</td>
      <td>6/18</td>
      <td>6/19</td>
      <td>6/20</td>
      <td>6/21</td>
</tr> 
<tr>
      <td></td>
      <c:forEach items="${ReserveDateList}" var="data" varStatus="i" end="6">
      <td>
      	<c:choose>
      		<c:when test="${empty data}">×</c:when>
      		<c:when test="${!empty data}">
      			<input type="radio" name="reserve_date" value="${i.count}-1">○
      		</c:when>
      	</c:choose>
      </td>
<<<<<<< HEAD
      </c:forEach>
</tr>
=======
      <td>
      	<c:if test="${empty Day2-1}">×</c:if>
      	<c:if test="${!empty Day2-1}"><input type="radio" name="reserve_date" value="2-1">○</c:if>
      </td>
      <td>
      	<c:if test="${empty Day3-1}">×</c:if>
      	<c:if test="${!empty Day3-1}"><input type="radio" name="reserve_date" value="3-1">○</c:if>
      </td>
      <td>
      	<c:if test="${empty Day4-1}">×</c:if>
      	<c:if test="${!empty Day4-1}"><input type="radio" name="reserve_date" value="4-1">○</c:if>
      </td>
      <td>
      	<c:if test="${empty Day5-1}">×</c:if>
      	<c:if test="${!empty Day5-1}"><input type="radio" name="reserve_date" value="5-1">○</c:if>
      </td>
      <td>
      	<c:if test="${empty Day6-1}">×</c:if>
      	<c:if test="${!empty Day6-1}"><input type="radio" name="reserve_date" value="6-1">○</c:if>
      </td>
      <td>
      	<c:if test="${empty Day7-1}">×</c:if>
      	<c:if test="${!empty Day7-1}"><input type="radio" name="reserve_date" value="7-1">○</c:if>
      </td>

</table><br>

<form method="POST" action="">
    <table>お名前：<input type="text" name="name" class="namae"></table>
    <table>電話：<input type="text" name="call" class="denwa"></table>
    <table>メールアドレス：<input type="text" name="mail" class="meado"></table>
    <p><input type="submit" value="送信する" class="botton"></p>

>>>>>>> branch 'master' of https://github.com/watanabeayumi/ACEPROJECT2.git
</table>
    <p>お名前：<input type="text" name="name"></p><br>
    <p>電話：<input type="text" name="call"></p><br>
    <p>メールアドレス：<input type="text" name="mail"></p><br>
    <p><input type="submit" value="送信する"></p>


  </form>

</body>
</html>