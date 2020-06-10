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

		ArrayList<Post> AllPostList = (ArrayList<Post>) request.getAttribute("AllPostList");

		for (int i = 0; i < AllPostList.size(); i++) {
			Post post = AllPostList.get(i);
	%>
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
			<%=post.getContent()%><br>
			投稿者:<%=post.getName()%>
			　投稿時間:<%=post.getTime()%>
			<%if(post.getUpdtime().equals("") == false) {%>
				　編集時間:<%=post.getUpdtime()%>
			<%} %>
			<div style="display:inline-flex">
				<form action="/Keiziban/UpdateServlet" class="updid" method="get">
					<input type="hidden" id="updid" name="updid" value="<%=post.getId()%>">
					<input type="submit" value="編集">
				</form>
				<form action="/Keiziban/DeleteServlet" class="delid" method="get">
					<input type="hidden" id="delid" name="delid" value="<%=post.getId()%>">
					<input type="submit" value="削除">
				</form>
			</div>
			<br>
			<hr>
	<%
		}
	%>

	<script>
	//ほんとにするのかチェック
	$('.updid').submit(function(){
    	if (!confirm('ほんとに編集しますか？')) {
    		return false;
    	}
    });
    $('.delid').submit(function(){
    	if (!confirm('ほんとに削除しますか？')) {
    		return false;
    	}
    });
	</script>
</body>
</html>