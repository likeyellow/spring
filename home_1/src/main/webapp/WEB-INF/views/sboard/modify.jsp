<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/resources/throughout/css/slidertron.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/resources/throughout/css/style.css" rel="stylesheet" type="text/css" media="screen" />
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>

<style>
/* 
 .form-group{

	position: relative;
	top: 40px;
	
	 background-color: yellow;
	height: 100px; 
	 width: 100%; 
	 	background-position: center; 
	margin: 15px 30px;
	padding: 10px 10px 10px 10px;
	font-family: Arial, Helvetica, sans-serif;
	 text-align: justify; 
	justify-content: center; 
} */

exampleInputBno{
	padding: 10px 10px;
	left: 20%;
}
.form-bno{
	justify-content: center;
	width: 90%;
	margin: 10px 10px;
	left: 20%;
}

exampleInputTitle{
	padding: 10px 10px;
}
.form-title{
	justify-content: center;
	width: 90%;
	margin: 10px 10px;
}

exmapleInputContent{
	padding: 10px 10px;
}
.form-content{
	justify-content: center;
	width: 90%;
	margin: 10px 10px;
}

exampleInputWriter{
	padding: 10px 10px;
}
.form-writer{
	justify-content: center;
	width: 90%;
	margin: 10px 10px;
}
.box-footer{

	position: absolute;
	top: 600px;
	left: 20%;
	justify-content: left;
}



</style>
<title>Modify Test</title>
</head>
<body>
	<form role="form" action="modify" method="post">
		<input type='hidden' name='page' value="${cri.page}">
		<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
		<input type='hidden' name='searchType' value="${cri.searchType}">
		<input type='hidden' name='keyword' value="${cri.keyword}">
	
	
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputBno">BNO</label><input type="text"
					name='bno' class="form-bno" value="${bo.bno}"
					readonly="readonly">
			</div>
			<div class="form-group">
				<label for="exampleInputTitle">Title</label><input type="text"
					name='title' class="form-title" value="${bo.title}">
			</div>
			<!-- rows="3" -->
			<div class="form-group"> 
				<label for="exmapleInputContent">Content</label>
				<textarea class="form-content" name="content" >${bo.content}</textarea>
			</div>
			<div class="form-group">
				<label for="exampleInputWriter">Writer</label><input type="text"
					name="writer" class="form-writer" value="${bo.writer}">
			</div>
		</div>
	</form>

<div class="box-footer">
		<button type="submit" class="btn btn-primary">SAVE</button>
		<button type="submit" class="btn btn-warning">CANCEL</button>
	</div>


	<script>
		$(document).ready(function() {
			var formObj = $("form[role='form']");
			console.log(formObj);

			$(".btn-warning").on("click", function() {
				self.location = "/sboard/list?page=${cri.page}&perPageNum=${cri.perPageNum}"
					+ "&searchType=${cri.searchType}&keyword=${cri.keyword}";
			});

			$(".btn-primary").on("click", function() {
				formObj.submit();
			});
		});
	</script>
	
	
	
		
</body>
</html>