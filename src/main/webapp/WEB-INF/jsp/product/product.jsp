<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
		<title>商品詳細ページ</title>
	</head>
	<body>
		<h1>商品情報</h1>
		<div>
			<div class="col-4 area">商品名</div>
			<div class="col-8 area"><c:out value="${Product.productName}"/></div>
		</div>
		<div>
			<div class="col-4 area">バーコード番号</div>
			<div class="col-8 area"><c:out value="${Product.janCd}"/></div>
		</div>
		<div>
			<div class="col-2 area">カテゴリ</div>
			<div class="col-4 area"><c:out value="${Product.categoryName}"/></div>
			<div class="col-2 area">商品カテゴリ</div>
			<div class="col-4 area"><c:out value="${Product.prodCategoryName}"/></div>
		</div>
		<div>
			<div class="col-4">ブランド</div>
			<div class="col-8"><c:out value="${Product.brandName}"/></div>
		</div>
		<a href="<c:url value='/reviewUproad' />">口コミを見る</a>
		<a href="<c:url value='/productPost' />">口コミを投稿する</a>
	</body>
</html>