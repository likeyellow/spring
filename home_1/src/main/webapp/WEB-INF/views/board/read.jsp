<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
  
<link href="/resources/throughout/css/slidertron.css" rel="stylesheet"
	type="text/css" media="screen" />
<link href="/resources/throughout/css/style.css" rel="stylesheet"
	type="text/css" media="screen" />

<style>
body {
	background-color: black;
}
label {
	color: white;
	font-weight: bold;
	font-size: 19px;
	width: 120px;
	font-family: Arial, Helvetica, sans-serif;
	text-align: justify;
	margin: 15px 70px;
}
input{
	color: black;
	/* background-color: yellow;
	width: 300px;
	height: 100px; */
	background-position: center;
	margin: 15px 130px;
	padding: 10px 10px 10px 10px;
	font-family: Arial, Helvetica, sans-serif;
	/* text-align: justify; */
}
.form-control{
	margin: 15px 130px;
	font-family: Arial, Helvetica, sans-serif;
	/* text-align: justify; */
}
.box-footer{
	/* background-position: center; */
	margin: 15px 130px;
}

</style>
<!-- <script src="jquery-3.3.1.min.js"></script> -->
<title>게시글 상세보기 페이지 입니다</title>
</head>
<body>
<form role="form" action="modify" method="post"> 


		<input type='hidden' name='bno' value="${bo.bno}"> 
		<input type='hidden' name='page' value="${cri.page}"> 
		<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
 </form> 

 <form role="form" method="post"> 
	<div class="box-header">
		<label for="this_bno">글번호<%-- 글번호<span class="test">${bo.bno}</span> --%></label>
		<input type='text' name="bno" class="form-control" value="${bo.bno}" readonly="readonly">
	</div>

		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">Title</label> 
				<input type="text"
					name='title' class="form-control" value="${bo.title}" readonly="readonly">
			</div>
			
			<div class="form-group">
				<label for="exampleInputPassword1">Content</label>
				<textarea class="form-control" name="content" rows="20" cols="100" readonly="readonly">${bo.content}</textarea>
			</div>
			
			<div class="form-group">
				<label for="exampleInputEmail1">Writer</label> 
				<input type="text"
					name="writer" class="form-control" value="${bo.writer}" readonly="readonly">
			</div>
		</div>
	
	
	
	<div class="box-footer">
		<button type="submit" class="btn btn-warining modifyBtn">MODIFY</button>
		<button type="submit" class="btn btn-danger removeBtn">REMOVE</button>
		<button type="submit" class="btn btn-primary goListBtn">LIST ALL</button>
	</div>
 </form> 
 
 
	<script>
		$(document).ready(function() {
			var formObj = $("form[role='form']");

			console.log(formObj);

			$(".btn btn-warining modifyBtn").on("click", function() {
				formObj.attr("action", "/board/modify");
				formObj.attr("method", "get");
				formObj.submit();
			});

			$(".btn btn-danger removeBtn").on("click", function() {
				formObj.attr("action", "/board/remove");
				formObj.submit();
			});

			$(".btn btn-primary goListBtn").on("click", function() {
				self.location = "/board/listCri";
				
			});
		});
	</script>
	
</body>
</html>