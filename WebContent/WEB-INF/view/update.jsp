<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.Post"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/kognise/water.css@latest/dist/light.min.css">
    <title>掲示板</title>
</head>
<body>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <a href="/Keiziban/StartServlet"><button>TOPへ戻る</button></a>
	<br>
	<br>

	<%
		request.setCharacterEncoding("UTF-8");

		Post post = (Post) request.getAttribute("UpdPost");
	%>
		<form action="/Keiziban/UpdateServlet2" method="get">
			<%if(post.getImgname().equals("") == false) {%>
				<%String upperimgname = post.getImgname().toUpperCase();
			    String extension = upperimgname.substring(upperimgname.lastIndexOf("."));
			    //画像ファイルだったら
				if(extension.equals(".JPG") || extension.equals(".JPEG") || extension.equals(".PNG") || extension.equals(".GIF") || extension.equals(".TIFF") || extension.equals(".BMP") || extension.equals(".PICT")) { %>
					<img src="./upload/<%=post.getImgname()%>" alt="投稿画像" width="100" height="100">
					<br>
			  <%}
				else {%>
					<a href="./upload/<%=post.getImgname()%>"><%=post.getImgname()%></a>
			  		<br>
			  <%}%>
			<%}%>
			投稿内容<br>
			<textarea name="updtext" id="str" cols="60" rows="5"><%=post.getContent()%></textarea><br>
			投稿者:<%=post.getName()%>
			　投稿時間:<%=post.getTime()%>
			<input type="hidden" id="updid" name="updid" value="<%=post.getId()%>"><br>
			<input type="submit" value="編集の完了">
		</form>
</body>
</html>