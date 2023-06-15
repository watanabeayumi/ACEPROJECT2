<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コンシェルジュ予約</title>
<link rel="stylesheet"  href="<c:url value='/css/common.css'/>"css/common.css">
</head>
<body>
<h1>ご相談予約削除</h1>
<h2>ご入力下さい</h2>

<<<<<<< HEAD
<table class="table">
<form  action="/delete" method="post">
=======
<table>
<form action="<c:url value='/deleteConfirm'/>" method="post">
>>>>>>> branch 'master' of https://github.com/watanabeayumi/ACEPROJECT2.git
      <tr>
        <th class="nyuuryoku">お名前：</th>
        <td><input name="name" type="text" class="namae" maxlength="8" <c:out value="${DeleteFlowBean.name}" /></td>
      </tr>
      <tr>
        <th class="nyuuryoku">電話：<br class="tyuui">※ハイフンなし、半角でご記入下さい。</th>
        <td><input name="call" type="text" class="denwa" maxlength="8" <c:out value="${DeleteFlowBean.tel}" />></td>
      </tr>
      <tr>
        <th class="nyuuryoku">メールアドレス：</th>
        <td><input name="mail" type="text" class="meado" maxlength="8" <c:out value="${DeleteFlowBean.Address}" />></td>
      </tr>
    </table>
<<<<<<< HEAD
    
    <table class="sousin">
<tr><th><input type="submit" value="送信する" class="botton"></th>
	</form>
	
	<th><a href="<c:url value='/reserve.jsp'/>" class="botton" onclick="history.back()">戻る</a></th>
	</tr>
</table>
=======
    <p><input type="submit" value="送信する" class="botton"></p>
<<<<<<< HEAD

    
    <a href="<c:url value='/reserve.jsp'/>" class="button" onclick="history.back()">戻る</a>
    
=======
</form>
    <a href="<c:url value='/reserve.jsp'/>" class="botton" onclick="history.back()">戻る</a>
>>>>>>> refs/remotes/origin/master
>>>>>>> branch 'master' of https://github.com/watanabeayumi/ACEPROJECT2.git

</body>
</html>

