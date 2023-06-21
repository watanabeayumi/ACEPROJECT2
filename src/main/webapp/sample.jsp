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
import Quagga from 'quagga';

export class  ScanComponent {
 
public startCapture() {
    // Quaggaの設定項目
    const config = {
      // カメラの映像の設定
      inputStream: {
        type: 'LiveStream',
        // カメラ映像を表示するHTML要素の設定
        target: '#camera-area',
        // バックカメラの利用を設定. (フロントカメラは"user")
        constraints: {
          height: 300,
          facingMode: 'environment'
        },
        size: 900,
        // 検出範囲の指定:
        area: { top: '0%', right: '0%', left: '0%', bottom: '30%' },
        singleChannel: false
      },
      // 解析するワーカ数の設定
      numOfWorkers: navigator.hardwareConcurrency || 4,
      // バーコードの種類を設定
      decoder: { readers: ['ean_reader'] },
      locate: false
    };
 
    Quagga.onDetected(result => {
      // 検出時の処理
      this.onDetected(result);
    });
    Quagga.onProcessed(result => {
      // 検出中の処理
      this.onProcessed(result);
    });
    // 初期化処理
    Quagga.init(config, error => {
      if (!!error) {
        console.error(`Error: ${error}`, error);
        return;
      }
      // エラーがない場合は、読み取りを開始
      Quagga.start();
    });
  }
}
 
private onDetected(result): void {
　const barcode = result.codeResult.code;
  if(barcode) {
    // バーコード検出時の処理を実装
 
    // 撮影を止める
    this.stopCapture();
  }
}
 
private onProcessed(result): void {
}
 
private stopCapture(): void {
    Quagga.stop();
}
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