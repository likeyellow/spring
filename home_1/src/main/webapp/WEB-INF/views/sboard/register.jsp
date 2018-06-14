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

.uploadedList{
	position: absolute;
	top: 42em;
	width: 100%;
	height: 100px;
	background-color: white;
	margin: 30px 30px;
	justify-content: center;
}

.btn-primary{
	position: absolute;
	left: 2em;
	margin: 30px 0px;
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
	
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>	
	
	<script type="text/javascript" src="/resources/js/upload.js"></script>
	
	<script id="template" type="text/x-handlebars-template">
	<li>
		<span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment"></span>
			<div class="mailbox-attachment-info">
				<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
				<a href="{{fullName}}"
					class="btn btn-default btn-xs pull-right delbtn"><i class="fa fa-fw fa-remove"></i></a>
			</div>
	</li>
	</script>	
	
	
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
  			integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  			crossorigin="anonymous"></script>
	
	<script>
	var template = Handlebars.compile($("#template").html());
	
	$(".fileDrop").on("dragenter dragover", function(event){
		event.preventDefault();
	});
	
	$(".fileDrop").on("drop", function(event){
		event.preventDefault();
		
		var files = event.originalEvent.dataTransfer.files;
		
		var file = files[0];
		
		var formData = new FormData();
		
		formData.append("file", file);
		
		$.ajax({
			url: '/sboard/uploadAjax',
			data: formData,
			dataType: 'text',
			processData: false,
			contentType: false,
			type: 'post',
			success: function(data){
				
				var fileInfo = getFileInfo(data);
				
				var html = template(fileInfo);
				
				$(".uploadedList").append(html);
			}
		});
	});
	
	$("#registerForm").submit(function(event){
		event.preventDefault();
		
		var that = $(this);
		
		var str = "";
		
		$(".uploadedList .delbtn").each(function(index){
			str += "<input type='hidden' name= 'files["+index+"]' value='"+$(this).attr("href") + "'> ";
		});
		
		that.append(str);
		that.get(0).submit();
	});
	
	</script>
	
</body>
</html>