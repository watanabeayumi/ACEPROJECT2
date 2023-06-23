<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>口コミ一覧</title>
	</head>
	<body>
		<div>
			<div class="col-3">
				<form action="/productReview" method="post">
					<input type="search" name="search" placeholder="キーワードを入力”>
					<input type="submit" name="submit" value="検索”>
				</form>
				<a href="productpost.jsp">投稿</a>
			</div>
			<div class="col-9">
				<c:if test="${!empty ReviewList}">
					<c:forEach items="${ReviewList}" var="review">
						<div class="row">
							<div class="col-3">
								<c:out value="${review.userName}"/>
							</div>
							<div class="col-3">
								評価：<c:out value="${review.star}"/>
							</div>
						</div>
						<div class="row">
							<div class="col-8">
								商品名:<c:out value="${review.productName}"/>
							</div>
							<div class="col-4">
								<c:out value="${review.janCd}"/>
							</div>
						</div>
						<div class="row">
							<div class="col-4">
								カテゴリ:<c:out value="${review.category}"/>
							</div>
							<div class="col-4">
								ジャンル:<c:out value="${review.genre}"/>
							</div>
							<div class="col-4">
								ブランド:<c:out value="${review.bland}"/>
							</div>
						</div>
						<div class="row">
							<div class="col-12">
								<c:out value="${review.review}"/>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
</body>
</html>