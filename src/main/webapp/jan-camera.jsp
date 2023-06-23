<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=0.1, maximum-scale=4,user-scalable=yes">
<!-- quaggaJSの読み込み -->
<script src="js/quagga.min.js"></script>
<script>
	var DetectedCount=0,DetectedCode="";
	var video,tmp,tmp_ctx,jan,prev,prev_ctx,w,h,mw,mh,x1,y1;
	window.addEventListener('load',function(event){
		video=document.createElement('video');
		video.setAttribute("autoplay","");
		video.setAttribute("muted","");
		video.setAttribute("playsinline","");
		video.onloadedmetadata = function(e){video.play();
	};
	prev=document.getElementById("preview");
	prev_ctx=prev.getContext("2d");
	tmp = document.createElement('canvas');
	tmp_ctx = tmp.getContext("2d");
	jan=document.getElementById("jan");
	
	//カメラ使用の許可ダイアログが表示される
	navigator.mediaDevices.getUserMedia(
		//マイクはオフ, カメラの設定   背面カメラを希望する 640×480を希望する
		{"audio":false,"video":{"facingMode":"environment","width":{"ideal":640},"height":{"ideal":480}}}
	).then( //許可された場合
		function(stream){
			video.srcObject = stream;
			//0.5秒毎にスキャンする
			setTimeout(Scan,500,true);
		}
	).catch( //許可されなかった場合
		function(err){jan.value+=err+'\n';}
	);
	
	function Scan(first){
		if(first){
			//選択された幅高さ
			w=video.videoWidth;
			h=video.videoHeight;
			//画面上の表示サイズ
			prev.style.width=(w/2)+"px";
			prev.style.height=(h/2)+"px";
			//内部のサイズ
			prev.setAttribute("width",w);
			prev.setAttribute("height",h);
			mw=w*0.5;
			mh=w*0.2;
			x1=(w-mw)/2;
			y1=(h-mh)/2;
		}
		prev_ctx.drawImage(video,0,0,w,h);
		prev_ctx.beginPath();
		prev_ctx.strokeStyle="rgb(255,0,0)";
		prev_ctx.lineWidth=2;
		prev_ctx.rect(x1,y1,mw,mh);
		prev_ctx.stroke();
		tmp.setAttribute("width",mw);
		tmp.setAttribute("height",mh);
		tmp_ctx.drawImage(prev,x1,y1,mw,mh,0,0,mw,mh);
		
		tmp.toBlob(function(blob){
			let reader = new FileReader();
			reader.onload=function(){
				let config={
					decoder: {
						readers: ["ean_reader","ean_8_reader"],
						multiple: false, //同時に複数のバーコードを解析しない
					},
					locator:{patchSize:"large",halfSample:false},
					locate:false,
					src:reader.result,
				};
				Quagga.decodeSingle(config,function(){});
			}
			reader.readAsDataURL(blob);
		});
		setTimeout(Scan,50,false);
	}
	
	Quagga.onDetected(function (result) {
		//読み取り誤差が多いため、3回連続で同じ値だった場合に成功とする
		if(DetectedCode==result.codeResult.code){
			DetectedCount++;
		}else{
			DetectedCount=0;
			DetectedCode=result.codeResult.code;
		}
		if(DetectedCount>=3){
			console.log(result.codeResult.code);
			jan.value=result.codeResult.code+'\n';
			jan.scrollTop=jan.scrollHeight;
			DetectedCode='';
			DetectedCount=0;
		}
	});
});
</script>
</head>
<body>
<c:if test="${!empty JanErr}">
	<c:out value="${JanErr}" />
</c:if>
<form action="janCameraProduct" method="post">
  <div><canvas id="preview"></canvas></div>
  <textarea id="jan" name="jan" rows="8" cols="40"></textarea>
  <input type="submit" value="送信する">
</form>
</body>
</html>