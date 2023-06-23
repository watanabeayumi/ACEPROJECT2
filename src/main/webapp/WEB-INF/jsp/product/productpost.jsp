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
   <form action="Servlet" method="post">
   
  <p>レビュー</p>
  <select id="hyoka"name="hyoka">
  <option value="1">★</option>
  <option value="2">★★</option>
  <option value="3">★★★</option>
  <option value="4">★★★★</option>
  <option value="5">★★★★★</option>
  </select>
  </div>
  ニックネーム<input name="name" type="textbox"><br>
  投稿フォーム<textarea name="touko" rows="5" cols="40"></textarea>
  <th><input type="submit" value="投稿する" class="botton"></th>
</form>
	

  


       
    
    

       
       
       
       
      

</body>
</html>