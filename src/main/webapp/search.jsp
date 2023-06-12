<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コンシェルジュ予約</title>
</head>
<body>
<table>
<tr>
　　<th>日付</th>
　　
</tr>
<tr>
      <td>時間</td>
　　  <td>6/15</td>
　　  <td>6/16</td>
      <td>6/17</td>
      <td>6/18</td>
      <td>6/19</td>
      <td>6/20</td>
      <td>6/21</td>
</tr>
<tr>
      <td></td>
      <td>〇</td>
      <td>×</td>
      <td>〇</td>
      <td>〇</td>
      <td>×</td>
      <td>〇</td>
      <td>〇</td>
</tr>
</table>

<form method="POST" action="">
    <p>お名前：<input type="text" name="name"></p><br>
    <p>電話：<input type="text" name="call"></p><br>
    <p>メールアドレス：<input type="text" name="mail"></p><br>
    <p><input type="submit" value="送信する"></p>

  </form>

</body>
</html>