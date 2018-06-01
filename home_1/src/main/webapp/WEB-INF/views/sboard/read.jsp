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
.box-header{
	margin: 30px auto;
}
label {
	color: white;
	font-weight: bold;
	font-size: 19px;
	width: 120px;
	font-family: Arial, Helvetica, sans-serif;
	/* text-align: justify; */
	margin: 15px 70px;
}
input{
	color: black;
	/* background-color: yellow;
	height: 100px; */
	width: 700px;
/* 	background-position: center; */
	margin: 15px 130px;
	padding: 10px 10px 10px 10px;
	font-family: Arial, Helvetica, sans-serif;
	/* text-align: justify; */
}
.form-control{
	width: 700px;
	margin: 15px 130px;
	padding: 10px 10px 10px 10px;
	font-family: Arial, Helvetica, sans-serif;
	/* text-align: justify; */
}
.form-control-w{
	width: 700px;
	margin: 15px 130px;
	padding: 10px 10px 10px 10px;
	font-family: Arial, Helvetica, sans-serif;
	/* text-align: justify; */
}
.form-control-c{
	width: 700px;
	margin: 15px 130px;
	padding: 10px 10px 10px 10px;
	font-family: Arial, Helvetica, sans-serif;
	/* text-align: justify; */
}
.box-footer{
	position : relative;
	top: 520px;
	/* left: 100px; */
	margin: 25px 130px;
	padding: 20px 20px 20px auto;
}
.box-title{
	font-weight: bold;
	font-size: 19px;
	margin: 10px 50px;
	font-family: Arial, Helvetica, sans-serif;
	color: white;
}
#repliesDiv{
	position : relative;
	top: 830px;
	font-family: Arial, Helvetica, sans-serif;
	color: white;
	font-weight: bold;
	font-size: 19px;
	margin: 10px 50px;
}
.box-success{
	position : relative;
	top: 530px;


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
		<input type='hidden' name='searchType' value="${cri.searchType}">
		<input type='hidden' name='keyword' value="${cri.keyword}">
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
				<textarea class="form-control-c" name="content" rows="20" cols="100" readonly="readonly">${bo.content}</textarea>
			</div>                                                                                                                               
			
			<div class="form-group">
				<label for="exampleInputEmail1">Writer</label> 
				<input type="text"
					name="writer" class="form-control-w" value="${bo.writer}" readonly="readonly">
			</div>
		</div>
	
	
	
	<!-- <div class="box-footer">
		<button type="submit" class="btn btn-warining modifyBtn">MODIFY</button>
		<button type="submit" class="btn btn-danger removeBtn">REMOVE</button>
		<button type="submit" class="btn btn-primary goListBtn">LIST ALL</button>
	</div> -->
 </form> 
 
 
<div class="box-footer">
		<button type="submit" class="btn btn-warining modifyBtn">MODIFY</button>
		<button type="submit" class="btn btn-danger removeBtn">REMOVE</button>
		<button type="submit" class="btn btn-primary goListBtn">LIST ALL</button>
</div>

 <!-- The time line -->
<ul class="timeline">
	<!-- timeline time label -->
	<div class="time-label" id="repliesDiv">
		Replies List </div>
</ul>
<div class="text-center">
	<ul id="pagination" class="pagination pagination-sm no-margin ">
	
	</ul>
</div> 

<div class="row">
	<div class="col-md-12">
	
		<div class="box box-success">
			<div class="box-header">
				<h3 class="box-title">ADD NEW REPLY</h3>
			</div>
			<div class="box-body">
				<label for="newReplyWriter">Writer</label>
					<input class="form-control reUser" type="text" placeholder="USER ID"
					id="newReplyWriter"><label for="newReplyText">ReplyText</label>
					<input class="form-control reText" type="text" placeholder="REPLY TEXT" id="newReplyText">
			</div>
			<!-- /.box-body -->
			<div class="box-footer">
				<button type="submit" class="btn btn-primary" id="replyAddBtn">ADD REPLY</button>
			</div>
		</div>
	</div>
</div>	

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	
	<script>
		$(document).ready(function() {
			var formObj = $("form[role='form']");

			console.log(formObj);

			$(".btn btn-warining modifyBtn").on("click", function() {
				formObj.attr("action", "/sboard/modify");
				formObj.attr("method", "get");
				formObj.submit();
			});

			$(".btn btn-danger removeBtn").on("click", function() {
				formObj.attr("action", "/sboard/remove");
				formObj.submit();
			});

			$(".btn btn-primary goListBtn").on("click", function() {
				/* self.location = "/sboard/list"; */
				formObj.attr("method", "get");
				formObj.attr("action", "/sboard/list");
				formObj.submit();
			});
		});
	</script>
	
<script id="template" type="text/x-handlebars-template">
{{#each .}}
<li class="replyLi" data-rno={{rno}}>
<i class="fa fa-comments bg-blue"></i>
	<div class="timeline-item">
		<span class="time">
			<i class="fa fa-clock-o"></i>{{perttifyDate regdate}}
		</span>
		<h3 class="timeline-header"><strong>{{rno}}</strong> -{{replyer}}</h3>
		<div class="timeline-body">{{replytext}}</div>
			<div class="timeline-footer">
				<a class="btn btn-primary btn-xs"
					data-toggle="modal" data-target="#modifyModal">Modify</a>
			</div>
		</div>
</li>
{{/each}}
</script>
<script>
Handlebars.registerHelper("prettifyDate", function(timeValue){
	var dateObj = new Date(timeValue);
	var year = dateObj.getFullYear();
	var month = dateObj.getMonth() + 1;
	var date = dateObj.getDate();
	return year+"/" + month + date;
});

var printData = function(replyArr, target, templateObject){
		var template = Handlebars.comile(templateObject.html());
		
		var html = template(replyArr);
		$(".replyLi").remove();
		target.after(html);
}
</script>	
<script>
var bno = ${bo.bno};
var replyPage = 1;

function getPage(pageInfo){
	
	$.getJSON(pageInfo, function(data){
		printData(data.list, $("#repliesDiv"), $("#template"));
		printPaging(data.pageMaker, $(".pagination"));
		
		$("#modifyModal").modal("hide");
	});
}

var printPaging = function(pageMaker,arget){
	var str = "";
	
	if(pageMaker.prev){
		str += "<li><a href='"+(pageMaker.startPage-1)+"'> << </a></li>";
	}
	for(var i=pageMaker.startPage, len = pageMaker.endPage; i <= len; i++){
		var strClass = pageMaker.cri.page == i?'class=active':'';
		str += "<li " + strClass+"><a href='"+i+"'>"+i+"</a></li>";
	}
	if(pageMaker.next){
		str += "<li>< a href='"+(pageMaker.endPage + 1)+"'> >> </a></li>";
	}
	target.html(str);
};

$("#repliesDiv").on("click", function(){
	if($(".timeline li").size() > 1){
		return;
	}
	getPage("/replies/" + bno + "/1");
});

$("#replyAddBtn").on("click", function(){
	var replyObj = $("#newReplyWriter");
	var replytextObj = $("#newReplyText");
	var replyerObj = $(".reUser");
	var replytextObj = $(".reText");
	
	//var data = {bno:bno, replyer:replyerObj, replytext:replytextObj};
	
	//console.log(data);
	
 	$.ajax({
		type:'post',
		url: '/replies/',
		headers:{
			"Content-Type" : "application/json",
			"X-HTTP-Method-Override" : "POST"},
		dataType:'text',
		data: JSON.stringify({bno:bno, replyer:replyerObj.val(), replytext:replytextObj.val()}),
		success:function(result){
			console.log("result: " + result);
			if(result == 'SUCCESS'){
				alert("등롱 되었습니다");
				replyPage = 1;
				getPage("/replies/" + bno + "/" + replyPage);
				replyerObj.val("");
				replytextObj.val("");				
			}
		}}); 
});


</script>
</body>
</html>