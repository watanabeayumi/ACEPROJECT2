<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>口コミ一覧</title>
</head>
<body>
<h1>商品名:<c:out value="${Product.productName}"/></h1>

<form action="/productReview" method="post">
 <input type="search" name="search" placeholder="キーワードを入力”>
 <input type="submit" name="submit" value="検索”>
</form>
<a href="productpost.jsp">投稿</a>
</body>
</html>