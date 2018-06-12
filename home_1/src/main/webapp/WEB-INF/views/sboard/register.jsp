<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/resources/throughout/css/slidertron.css" rel="stylesheet" type="text/css" media="screen" />
<link href="/resources/throughout/css/style.css" rel="stylesheet" type="text/css" media="screen" />

<title>Insert title here</title>

<style>

.box_body{
	position: relative;
	top: 10px;
	left: 20px;
	font-family: Arial, Helvetica, sans-serif;	
}

.form-controller{
	position: absolute;
	top: 1em;
	
	width: 100%;
    height: 20px;
    margin: 30px 30px;
    font-family: Arial, Helvetica, sans-serif;
    justify-content: center;
}
/* exampleInputContent{
	position: absolute;
	top: 4em;
	left: 2em;
	width: 130px;
    height: 15px;
    margin: 20px 20px;
} */

.form-control{
	position: absolute;
	top: 7em;
	
	width: 100%;
    height: 350px;
    margin: 30px 30px;
    font-family: Arial, Helvetica, sans-serif;
    justify-content: center;
}

/* exampleInputWriter{
	position: absolute;
	top: 6em;
	left: 2em;
	width: 60px;
    height: 15px;
    margin: 20px 20px;
} */
.form-control2{
	position: absolute;
	top: 4em;
	
	width: 100%;
    height: 20px;
    margin: 30px 30px;
    font-family: Arial, Helvetica, sans-serif;
    justify-content: center;
}
.btn-primary{
	position: absolute;
	top: 60em;
	left: 4em;
	margin: 30px 30px;
	font-family: Arial, Helvetica, sans-serif;
}
h1{
	text-align: center;
	justify-content: center;
	margin: 20px 40px;
	font-family: Arial, Helvetica, sans-serif;
}

.box-footer{
	position: relative;
	top: 10px;
	left: 20px;
}

.fileDrop{
	position: absolute;
	width: 100%;
	height: 100px;
	border: 1px dotted gray;
	background-color: white;
	top: 38em;
	/* left: 4em; */	
	margin: 30px 30px;
	justify-content: center;
}
</style>
</head>
<body>
<h1>등록페이지 테스트 중</h1>
	<form role="form" method="post">
		<div class="box_body">
			<div class="form-group">
				<!-- <label for="exmpleInputTitle">Title</label> -->
				<input type="text" name='title' class="form-controller" placeholder="Enter Title">
			</div>

			<div class="form-group">
				<!-- <label for="exampleInputContent">Content</label> -->
				<textarea class="form-control" name="content"  placeholder="Enter..."></textarea>
			</div>
		
			<div class="form-group">
				<!-- <label for="exampleInputWriter">Writer</label> -->
				<input type="text" name="writer" class="form-control2" placeholder="Enter Writer">
			</div>
			
			<div class="form-group">
				<!-- <label for="exampleInputFile">File DROP Here</label>  -->
				<div class="fileDrop"></div>
			</div>
		</div>
	<!-- /.box-body -->
	
			<div class="box-footer">
				<div>
					<hr>
				</div>
				
				<ul class="mailbox-attachments clearfix uploadedList">
				</ul>
				
				<button type="submit" class="btn btn-primary">Submit</button>
			
			</div>
	</form>
</body>
</html>