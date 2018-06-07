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

.form-group{

	position: relative;
	color: black;
	/* background-color: yellow;
	height: 100px; */
	width: 1700px;
	/* 	background-position: center; */
	margin: 15px 130px;
	padding: 10px 10px 10px 10px;
	font-family: Arial, Helvetica, sans-serif;
	/* text-align: justify; */
}
.box-footer{

	position: absolute;
	top: 300px;
	left: 171px; 
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
				<label for="exampleInputEmail1">BNO</label><input type="text"
					name='bno' class="form-control" value="${bo.bno}"
					readonly="readonly">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Title</label><input type="text"
					name='title' class="form-control" value="${bo.title}">
			</div>
			<!-- rows="3" -->
			<div class="form-group"> 
				<label for="exmapleInputPassword1">Content</label>
				<textarea class="form-control" name="content" >${bo.content}</textarea>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Writer</label><input type="text"
					name="writer" class="form-control" value="${bo.writer}">
			</div>
		</div>
	</form>

<div class="box-footer">
		<button type="submit" class="btn btn-primary">SAVE</button>
		<button type="submit"class="btn btn-warning">CANCEL</button>
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