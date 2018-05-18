<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/resources/throughout/css/slidertron.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/resources/throughout/css/style.css" rel="stylesheet" type="text/css" media="screen" />
<script src="jquery-3.3.1.min.js"></script>
<title>Modify Test</title>
</head>
<body>
	<form role="form" method="post">
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">BNO</label><input type="text"
					name='bno' class="form-control" value="${BoardVO.bno}"
					readonly="readonly">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Title</label><input type="text"
					name='title' class="form-control" value="${BoardVO.title}">
			</div>
			<div class="form-group">
				<label for="exmapleInputPassword1">Content</label>
				<textarea class="form-control" name="content" rows="3">${BoardVO.content}</textarea>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Writer</label><input type="text"
					name="writer" class="form-control" value="${BoardVO.writer}">
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
				self.location = "/board/listAll";
			});

			$(".btn-primary").on("click", function() {
				formObj.submit();
			});
		});
	</script>
</body>
</html>