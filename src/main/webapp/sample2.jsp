<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
    var video = document.querySelector('video');
    var canvas = document.querySelector('canvas');
    var ctx = canvas.getContext('2d');
    var localMediaStream = null;
    var list = document.querySelector('ul#decoded');

    var worker = new Worker('zbar-processor.js');
    worker.onmessage = function (event) {
      if (event.data.length == 0) return;
      var d = event.data[0];
      var entry = document.createElement('li');
      entry.appendChild(document.createTextNode(d[2] + ' (' + d[0] + ')'));
      list.appendChild(entry);
    };

    function snapshot() {
      if (localMediaStream === null) return;
      var k = (800 + 500) / (video.videoWidth + video.videoHeight);
      canvas.width = Math.ceil(video.videoWidth * k);
      canvas.height = Math.ceil(video.videoHeight * k);
      var ctx = canvas.getContext('2d');
      ctx.drawImage(video, 0, 0, video.videoWidth, video.videoHeight,
        0, 0, canvas.width, canvas.height);

      var data = ctx.getImageData(0, 0, canvas.width, canvas.height);
      worker.postMessage(data);
    }

    setInterval(snapshot, 500);

    navigator.getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia || navigator.msGetUserMedia;
    window.URL = window.URL || window.webkitURL || window.mozURL || window.msURL;

    if (navigator.getUserMedia) {
      navigator.getUserMedia({ video: true },
        function (stream) { // success callback
          if (video.mozSrcObject !== undefined) {
            video.mozSrcObject = stream;
          } else {
            video.src = (window.URL && window.URL.createObjectURL(stream)) || stream;
          }
          localMediaStream = true;
        },
        function (error) {
          console.error(error);
        });
    }
    else {
    }
  </script>
</head>
<body>
<div><canvas></canvas></div>
  <textarea id="jan" rows="8" cols="40"></textarea>
</body>
</html>