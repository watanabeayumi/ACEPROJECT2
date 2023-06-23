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
    <input id="hoshi1" type="radio" name="hoshi" value="5" />
    <label for="hoshi1">★</label>
    <input id="hoshi2" type="radio" name="hoshi" value="4" />
    <label for="hoshi2">★</label>
    <input id="hoshi3" type="radio" name="hoshi" value="3" />
    <label for="hoshi3">★</label>
    <input id="hoshi4" type="radio" name="hoshi" value="2" />
    <label for="hoshi4">★</label>
    <input id="hoshi5" type="radio" name="hoshi" value="1" />
    <label for="hoshi5">★</label>
 
  </div>
</div>
  ニックネーム<input name="name" type="textbox"><br>
  投稿フォーム<textarea name="otoiawase" rows="5" cols="40"></textarea>
  <th><input type="submit" value="送信する" class="botton"></th>
</form>
	

  


       
    
    

       
       
       
       
      

</body>
</html>