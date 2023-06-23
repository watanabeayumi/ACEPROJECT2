<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link href="css/custom.css" rel="stylesheet">
   
		<title>商品詳細ページ</title>
	</head>
	<body>
	<div class="container-fluid">
        <div class="row">
            <div class="top">
                <h1>商品情報</h1>
	        </div>
        </div>

        <div class="row">
			<div class="col-4 content">商品名</div>
			<div class="col-8 content"><c:out value="${Product.productName}"/></div>
		</div>
		<div class="row">
			<div class="col-4 content">バーコード番号</div>
			<div class="col-8 content"><c:out value="${Product.janCd}"/></div>
		</div>
		<div class="row">
			<div class="col-2 content">カテゴリ</div>
			<div class="col-4 content"><c:out value="${Product.categoryName}"/></div>
			<div class="col-2 content">商品カテゴリ</div>
			<div class="col-4 content"><c:out value="${Product.prodCategoryName}"/></div>
		</div>
		<div class="row">
			<div class="col-4">ブランド</div>
			<div class="col-8"><c:out value="${Product.brandName}"/></div>
		</div>
		<div class="row">
            <div class="bottom"><a href="<c:url value='/reviewUproad' />">口コミを見る</a></div>
            <div class="bottom"><a href="<c:url value='/productPost' />">口コミを投稿する</a></div>
        </div>
        

    </div>
	</body>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</html>

