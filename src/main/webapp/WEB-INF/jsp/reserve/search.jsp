<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<form  action="reserveConfirm" method="post">
	<table class="table" border="1" height="150" width="300">

		<tr>
			<td>日付</td>
			<c:forEach items="${WeekList}" var="data" varStatus="i" end="6">
				<td class="td"><c:out value="${data}" /></td>
			</c:forEach>
		</tr>
		
		<tr>
			<c:forEach items="${ReserveDateList}" var="data" varStatus="i" end="69" >
				<c:if test="${i.count % 7 == 1}">
					<td>
						<fmt:formatNumber maxFractionDigits="0" value="${(i.count + 6) / 7 + 9}"/>:00∼
						<fmt:formatNumber maxFractionDigits="0" value="${(i.count + 6) / 7 + 10}"/>:00
					</td>
				</c:if>
				<td>
					<c:choose>
						<c:when test="${data == null}">
							<input type="radio" name="reserveDate" value="${i.count}" id="maru">
							<label for="maru"></label>
						</c:when>
						<c:when test="${data != null}">
							<label id="batu">×</label>
						</c:when>
					</c:choose>
				</td>
				<c:if test="${i.count % 7 == 0}">
					</tr>
					
				</c:if>
			</c:forEach>
		</tr>
		
	</table>
	<br>
	<table>
	<c:if test="${!empty ReserveErr}">
		<c:forEach items="${ReserveErr}" var="err">
			<tr>
				<th class="errormsg"><c:out value="${err}"/></th>
			</tr>
		</c:forEach>
	</c:if>
	</table>
	
	<br>
	
	
	<table> 
	
	    <tr>
	   		 <th class="nyuuryoku">相談内容：</th>
	    	<td class="nyuuryoku"><c:out value="${conciergeName}"/></td>
	    </tr>
		<tr>
			<th class="nyuuryoku">お名前：</th>
			<td><input name="name" type="text"></td>
		</tr>
		<c:if test="${!empty NameErr}">
		<tr>
			<th class="errormsg"><c:out value="${NameErr}"/></th>
		</tr>
		</c:if>
			
		<tr>
			<th class="nyuuryoku">電話：</th>
			<td><input name="call" type="tel" pattern="[0-9]{10,11}" maxlength="11"></td>
		</tr>

		<tr>
			<th class="th">※ハイフンなし、半角</th>
		</tr>
		<c:if test="${!empty CallErr}">
			<c:forEach items="${CallErr}" var="err">
				<tr>
					<th class="errormsg"><c:out value="${err}"/></th>
				</tr>
			</c:forEach>
		</c:if>
		
		<tr>
			<th class="nyuuryoku">メールアドレス：</th>
			<td><input name="mail" type="email"></td>
		</tr>
		
		<c:if test="${!empty MailErr}">
			<tr>
				<th class="errormsg"><c:out value="${MailErr}"/></th>
			</tr>
		</c:if>
	</table>
	<table class="sousin">
<tr><th><a href="<c:url value='/reserve.jsp'/>" class="anka" onclick="history.back()">メニューに戻る</a></th>
<th><input type="submit" value="送信する" class="botton"></th>
	</form>
	</tr>
</table>
</body>
</html>
		