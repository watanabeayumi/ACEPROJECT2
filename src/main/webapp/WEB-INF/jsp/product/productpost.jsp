<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>口コミ投稿サイト</title>
</head>
<body>
	<h1>
		商品名:
		<c:out value="${Product.productName}" />
	</h1>
	<form action="ProductPostServlet" method="post">

  <div class="hyoka">
    <input id="star1" type="radio" name="star" value="5" />
    <label for="star1"><span class="text">最高</span>★</label>
    <input id="star2" type="radio" name="star" value="4" />
    <label for="star2"><span class="text">良い</span>★</label>
    <input id="star3" type="radio" name="star" value="3" />
    <label for="star3"><span class="text">普通</span>★</label>
    <input id="star4" type="radio" name="star" value="2" />
    <label for="star4"><span class="text">悪い</span>★</label>
    <input id="star5" type="radio" name="star" value="1" />
    <label for="star5"><span class="text">最悪</span>★</label>
	
		ニックネーム<input name="name" type="textbox"><br> 投稿フォーム<br>
		<textarea name="touko" rows="5" cols="40"></textarea>
		<th><input type="submit" value="投稿する" class="botton"></th>
		</div>
	</form>
</body>
</html>