<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.Post"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/kognise/water.css@latest/dist/light.min.css">
<title>掲示板</title>
</head>
<body>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<a href="/Keiziban/ManagementServlet"><button>管理画面へ</button></a>

	<form id="post" enctype="multipart/form-data"
		action="/Keiziban/InsertServlet" method="post">
		投稿者<br> <input type="text" id="name" name="name"><br>
		メールアドレス<br> <input type="text" id="mail" name="mail"><br>
		内容<br>
		<textarea name="content" id="str" cols="80" rows="5"></textarea>
		<br> ファイルをアップロード<br>
		<input type="file" name="file" id="file"><br>

		<div id="nullcheck">
			<font color="red">入力されていない箇所があります</font><br>
		</div>
		<div id="mailcheck">
			<font color="red">メールアドレスには@を入れてください</font><br>
		</div>
		<div id="filecheck">
			<font color="red">そのファイルアップロードできません</font><br>
		</div>

		<input type="submit" value="投稿">
	</form>

	<hr style="border: 1; border-top: 10px double;">

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
				<img src="./upload/<%=post.getImgname()%>" alt="投稿画像" width="100"height="100"><br>
			<%}
	  		else {%>
	  			<a href="./upload/<%=post.getImgname()%>"><%=post.getImgname()%></a>
				<br>
			<%}%>
		<%}%>
		<%=post.getContent()%><br> 投稿者:<%=post.getName()%>
		投稿時間:<%=post.getTime()%>
		<%if(post.getUpdtime().equals("") == false) {%>
			編集時間:<%=post.getUpdtime()%>
		<%} %>
		<br>
		<hr>
	<%
	}
	%>




	<script>
	//form
	$('#nullcheck').hide();
	$('#mailcheck').hide();
	$('#filecheck').hide();

	//入力項目のチェック
	//nullチェック
    $('#post').submit(function(){
        if($('#name').val() === "" || $('#mail').val() === "" || $('#str').val() === "" || $('#file').val() === "") {
        	$('#nullcheck').show();
        	return false;
        }
        else {
        	$('#nullcheck').hide();
        }
    });
  	//メールチェック
    $('#post').submit(function(){
    	if($('#mail').val().indexOf("@") === -1) {
        	$('#mailcheck').show();
        	return false;
        }
    	else {
    		$('#mailcheck').hide();
    	}
    });

  	//ファイルチェック
	$('#post').submit(function(){
		var filename = $('#file').val();
		//比較のため大文字
		var ext = filename.toUpperCase();
		//対象の拡張子があるか確認
		if ( ext.indexOf("JPG") === -1 &&  ext.indexOf("JPEG") === -1 && ext.indexOf("PNG") === -1 &&  ext.indexOf("GIF") === -1 && ext.indexOf('TIFF') === -1 && ext.indexOf('BMP') === -1 &&
			ext.indexOf("PICT") === -1 && ext.indexOf("XLSX") === -1 && ext.indexOf("DOCX") === -1 && ext.indexOf("DOCM") === -1 && ext.indexOf('XLSM') === -1 && ext.indexOf('JPG') === -1 &&
			ext.indexOf("XLSX") === -1 &&  ext.indexOf("PPT") === -1 && ext.indexOf("PPTX") === -1 && ext.indexOf("PDF") === -1) {
			$('#filecheck').show();
			return false;
		}
		else {
			$('#filecheck').hide();
		}

	});
	</script>
</body>
</html>