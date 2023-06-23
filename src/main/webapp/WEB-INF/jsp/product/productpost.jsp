<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>口コミ投稿サイト</title>
</head>
<body>
   <h1>商品名:<c:out value="${Product.productName}"/></h1>
   <form  action="Servlet" method="post">
   
   <div class="review">
  <p>レビュー</p>
  <div class="stars">
    <span>
      <input id="review01" type="radio" name="review"><label for="review01">★</label>
      <input id="review02" type="radio" name="review"><label for="review02">★</label>
      <input id="review03" type="radio" name="review"><label for="review03">★</label>
      <input id="review04" type="radio" name="review"><label for="review04">★</label>
      <input id="review05" type="radio" name="review"><label for="review05">★</label>
    </span>
  </div>
</div>
  ニックネーム<input name="name" type="textbox">
  投稿フォーム<textarea name="otoiawase" rows="5" cols="40"></textarea>
  <th><input type="submit" value="送信する" class="botton"></th>
	</form>
	

  


       
    
    

       
       
       
       
      

</body>
</html>