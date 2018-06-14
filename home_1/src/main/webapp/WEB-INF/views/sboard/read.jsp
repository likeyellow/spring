<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>


<link href="/resources/throughout/css/slidertron.css" rel="stylesheet"
	type="text/css" media="screen" />
<link href="/resources/throughout/css/style.css" rel="stylesheet"
	type="text/css" media="screen" />

<style>
.box-header {
	/* margin: 30px auto; */
	}

label {
	color: white;
	font-weight: bold;
	font-size: 19px;
	width: 30%;
	font-family: Arial, Helvetica, sans-serif;
	/* text-align: justify; */
	margin: 15px 70px;
	justify-content: left;
}

input {
	color: black;
/* 	width: 70%; */
	/* 	background-position: center; */
	margin: 15px 130px;
	padding: 10px 10px 10px 10px;
	font-family: Arial, Helvetica, sans-serif;
	/* text-align: justify; */
	justify-content: center;
}

.form-control {
	width: 70%;
	margin: 15px 130px;
	padding: 10px 10px 10px 10px;
	font-family: Arial, Helvetica, sans-serif;
	/* text-align: justify; */
	justify-content: center;
}

.form-control-w {
	width: 70%;
	margin: 15px 130px;
	padding: 10px 10px 10px 10px;
	font-family: Arial, Helvetica, sans-serif;
	/* text-align: justify; */
	justify-content: center;
}

.form-control-c {
	width: 70%;
	margin: 15px 130px;
	padding: 10px 10px 10px 10px;
	font-family: Arial, Helvetica, sans-serif;
	/* text-align: justify; */
	justify-content: center;
}

.box-footer {
	position: relative;
	top: 520px;
	/* left: 100px; */
	margin: 25px 130px;
	padding: 20px 20px 20px auto;
	justify-content: left;
}

.box-title {
	font-weight: bold;
	font-size: 19px;
	margin: 10px 50px;
	font-family: Arial, Helvetica, sans-serif;
	color: white;
}

#repliesDiv {
	position: relative;
	top: 830px;
	font-family: Arial, Helvetica, sans-serif;
	color: white;
	font-weight: bold;
	font-size: 19px;
	margin: 10px 50px;
}

.box-success {
	position: relative;
	top: 530px;
}
.replyLi{
	color: white;
}

.bg-green{
	
}

.popup{
	position: absolute;
}
.back{
	background-color: white; 
	opacity: 0.5;
	width: 100%;
	height: 300%;
	overflow: hidden;
	z-index: 1101;
}
.front{
	z-index: 1110;
	opacity:1;
	boarder:1px;
	margin: auto;
}
.show{
	position: relative;
	max-width: 1200px;
	max-height: 800px;
	overflow: auto;
}
</style>
<!-- <script src="jquery-3.3.1.min.js"></script> -->
<title>게시글 상세보기 페이지 입니다</title>
</head>
<body>
	<form role="form" action="modify" method="post">
		<input type='hidden' name='bno' value="${bo.bno}"> 
		<input type='hidden' name='replycnt' value="${bo.replycnt}"> <!--  replycnt 를 쓰려면 여기에 이렇게 읽어와야 하는건가? (2018/06/11) -->
		<input type='hidden' name='page' value="${cri.page}"> 
		<input type='hidden' name='perPageNum' value="${cri.perPageNum}"> 
		<input type='hidden' name='searchType' value="${cri.searchType}"> 
		<input type='hidden' name='keyword' value="${cri.keyword}">
	</form>

	<form role="form" method="post">
		<div class="box-header">
			<label for="this_bno">글번호<%-- 글번호<span class="test">${bo.bno}</span> --%></label>
			<input type='text' name="bno" class="form-control" value="${bo.bno}"
				readonly="readonly">
		</div>

		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">Title</label> <input type="text"
					name='title' class="form-control" value="${bo.title}"
					readonly="readonly">
			</div>

			<div class="form-group">
				<label for="exampleInputPassword1">Content</label>
				<textarea class="form-control-c" name="content" rows="20" cols="100"
					readonly="readonly">${bo.content}</textarea>
			</div>

			<div class="form-group">
				<label for="exampleInputEmail1">Writer</label> <input type="text"
					name="writer" class="form-control-w" value="${bo.writer}"
					readonly="readonly">
			</div>
		</div>

		<ul class="milabox-attachments clearfix uploadedList"></ul>
		
		<div class='popup back' style="display:none;"></div>
			<div id="popup_front" class='popup front' style="display:none;">
			<img id="popup_img">
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
		<button type="submit" class="btn btn-primary goListBtn">GO LIST</button>
	</div>
	
	<form role="form" action="modifyPage" method="post">
		<input type="hidden" name="bno" value="${bo.bno}">
		<input type="hidden" name="page" value="${cri.page}">
		<input type="hidden" name="perPageNum" value="${cri.perPageNum}">
	</form>

	<!-- The time line -->
	<ul class="timeline">
		<!-- timeline time label -->
		<li class="time-label" id="repliesDiv">
		<span class="bg-green">
			Replies List <small id="replycntSmall"> [${bo.replycnt}]</small>
			
		</span></li>
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
					<label for="newReplyWriter">Writer</label> <input
						class="form-control reUser" type="text" placeholder="USER ID"
						id="newReplyWriter"><label for="newReplyText">ReplyText</label>
					<input class="form-control reText" type="text"
						placeholder="REPLY TEXT" id="newReplyText">
				</div>
				<!-- /.box-body -->
				<div class="box-footer">
					<button type="submit" class="btn btn-primary" id="replyAddBtn">ADD
						REPLY</button>
				</div>
			</div>
		</div>
	</div>

<!-- 	<!-- Modal
	<div id="modifyModal" class="modal modal-primary fade" role="dialog">
		<div class="modal-dialog">
			Modal content
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title"></h4>
				</div>
				<div class="modal-body" data-rno>
					<p>
						<input type="text" id="replytext" calss="form-control">
					</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" id="replyModBtn">Modify</button>
					<button type="button" class="btn btn-danger" id="replyDelBtn">DELETE</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
 -->

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
  			integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  			crossorigin="anonymous"></script>
	
	

	<script>
		$(document).ready(function() {
			var formObj = $("form[role='form']");

			console.log("이게.....???" +formObj);

			$(".btn-warining").on("click", function() {
				formObj.attr("method", "get");
				formObj.attr("action", "/sboard/modify");
				
				formObj.submit();
			});

			$(".btn-danger").on("click", function() {
				formObj.attr("action", "/sboard/remove");
				formObj.submit();
			});

			$(".btn-primary").on("click", function() {
				/* self.location = "/sboard/list"; */
				formObj.attr("method", "get");
				formObj.attr("action", "/sboard/list");
				formObj.submit();
			});
		});
	</script>


<script
		src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>	
		
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

<script id="templateAttach" type="text/x-handlebars-template">
<li data-src='{{fullName}}'>
	<span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}"
alt="Attachment"></span>
	<div class="mailbox-attachment-info">
	<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
	</span>
	</div>
</li>
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
		var template = Handlebars.compile(templateObject.html());
		
		var html = template(replyArr);
		$(".replyLi").remove();
		target.after(html);
}

		var bno = ${bo.bno};
		var replyPage = 1;

		function getPage(pageInfo) {

			$.getJSON(pageInfo, function(data) {
				printData(data.list, $("#repliesDiv"), $("#template"));
				printPaging(data.pageMaker, $(".pagination"));

				$("#modifyModal").modal("hide");
				$("#replycntSmall").html("[ " + data.pageMaker.totalCount +  " ]");
			});
		}

		var printPaging = function(pageMaker, target) {
			var str = "";

			if (pageMaker.prev) {
				str += "<li><a href='" + (pageMaker.startPage - 1)
						+ "'> << </a></li>";
			}
			for (var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++) {
				var strClass = pageMaker.cri.page == i ? 'class=active' : '';
				str += "<li " + strClass+"><a href='"+i+"'>" + i + "</a></li>";
			}
			if (pageMaker.next) {
				str += "<li>< a href='" + (pageMaker.endPage + 1)
						+ "'> >> </a></li>";
			}
			target.html(str);
		};

		$("#repliesDiv").on("click", function() {
			if ($(".timeline").size() > 1) {
				return;
			}
			getPage("replies/" + bno + "/1");
		});

		$(".pagination").on("click", "li a", function(event) {
			event.preventDefault();
			replyPage = $(this).attr("href");
			getPage("replies/" + bno + "/" + replyPage);
		});

		$("#replyAddBtn").on("click", function() {
			var replyObj = $("#newReplyWriter");
			var replytextObj = $("#newReplyText");
			var replyerObj = $(".reUser");
			var replytextObj = $(".reText");

			//var data = {bno:bno, replyer:replyerObj, replytext:replytextObj};

			//console.log(data);

			$.ajax({
				type : 'post',
				url : '/sboard/replies',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : 'text',
				data : JSON.stringify({
					bno : bno,
					replyer : replyerObj.val(),
					replytext : replytextObj.val()
				}),
				success : function(result) {
					console.log("result: " + result);
					if (result == 'SUCCESS') {
						alert("등록 되었습니다");
						replyPage = 1;
						getPage("/replies/" + bno + "/" + replyPage);
						replyerObj.val("");
						replytextObj.val("");
					}
				}
			});
		});
		
		
		var bno = ${bo.bno};
		var template = Handlebars.compile($("#templateAttach").html());
		
		$.getJSON("/sboard/getAttach/"+ bno, function(list){
			$(list).each(function(){
				
				var fileInfo = getFileInfo(this);
				
				var html = template(fileInfo);
				
				$(".uploadedList").append(html);
				
			});
		});
		
/* $(".timeline").on("click", ".replyLi", function(event){
	
	var reply = $(this);
	
	$("#replytext").val(reply.find('.timeline-body').text());
	$(".modal-title").html(reply.attr("data-rno"));
	
});		
	 */	
	 $(".uploadedList").on("click", ".mailbox-attachment-info a", function(event){
		
		 var fileLink = $(this).attr("href");
		 
		 if(checkImageType(fileLink)){
			 
			 event.preventDefault();
			 
			 var imgTag = $("#popup_img");
			 imgTag.attr("src", fileLink);
			 
			 console.log(imgTag.attr("src"));
			 
			 $(".popup").show('slow');
			 imgTag.addClass("show");	 
		 }
	 });
	 
	 $("#popup_img").on("click", function(){
		
		 $(".popup").hide('slow');
	 });
	 
	 $("#removeBtn").on("click", function(){
		
		 var replyCnt = $("replycntSmall").html().replace(/[^0~9]/g,"");
		 
		 if(replyCnt > 0){
			 alert("댓글이 달린 게시물을 삭제할 수 없습니다.");
			 return;
		 }
		 var arr = [];
		 $(".uploadedList li").each(function(index){
			 arr.push($(this).attr("data-src"));
		 });
		 
		 if(arr.length > 0){
			 $.post("/deleteAllFiles", {files:arr}, function(){
				 
			 });
		 }
		 formObj.attr("action", "/sboard/remove");
		 formObj.submit();
	 });
		
</script>
</body>
</html>