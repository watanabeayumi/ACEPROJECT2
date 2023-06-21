<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=0.1, maximum-scale=4,user-scalable=yes">
<!-- quaggaJSの読み込み -->
<script src="js/quagga.min.js">
</script>
<script>
var DetectedCount=0,DetectedCode="";
var video,tmp,tmp_ctx,jan,prev,prev_ctx,w,h,mw,mh,x1,y1;
window.addEventListener('load',function(event){
  video=document.createElement('video');
  video.setAttribute("autoplay","");
  video.setAttribute("muted","");
  video.setAttribute("playsinline","");
  video.onloadedmetadata = function(e){video.play();};
  prev=document.getElementById("preview");
  prev_ctx=prev.getContext("2d");
  tmp = document.createElement('canvas');
  tmp_ctx = tmp.getContext("2d");
  jan=document.getElementById("jan");

 

   
</script>
</head>
<body>
<c:if test="${!empty JanErr}">
	<c:out value="${JanErr}" />
</c:if>
<form action="sample" method="post">
  <div><canvas id="preview"></canvas></div>
  <textarea id="jan" name="jan" rows="8" cols="40"></textarea>
  <input type="submit" value="送信する">
</form>
<a href="<c:url value='/sample?jan_code='/>">商品</a>
<c:out value="${Product.janCd}"/>
<c:out value="${Product.productName}"/>
</body>
</html>