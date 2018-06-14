<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<%@ include file="../include/header.jsp"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/resources/throughout/css/slidertron.css" rel="stylesheet"
	type="text/css" media="screen" />
<link href="/resources/throughout/css/style.css" rel="stylesheet"
	type="text/css" media="screen" />

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>


<style>
/*
.tbl_board {
	 position: absolute;
	top: 165px;
	left: 171px; 
	float: center;
	background-position: center;
	background-color: black;
	font-family: Arial, Helvetica, sans-serif;
	text-align: center;
	border: 2px double grey;
	border-radius: 15px;
	margin: 15px 5px;
	padding: 10px 10px 10px 10px;
	width: 940px;
	height: 440px;
} 


.tbl_board tr {
	 position: relative; 
	text-align: center;
	width: 940px;
	height: 440px;
}

.tbl_board th {
	float: justify;
	height: 32px;
	padding: 10px 20px 0px 20px;
	letter-spacing: -1px;
	text-decoration: none;
	text-align: center;
	text-transform: lowercase;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 18px;
	font-weight: normal;
	color: #FFFFFF;
} 

.pagination li {
	color: blue;
	float: justify;
	height: 32px;
	text-align: center;
	text-decoration: none;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 25px;
	display: inline;
} */
.tbl_board th{
	color: white;
	padding: 10px 10px;
}

.tbl_board td{
	color: lightgreen;
	padding: 5px 5px;
	text-align: justify;
}
.badge bg-red{
	text-align: justify;
	padding: auto 20px;
}
</style>
<title>ListALL Page Test</title>
</head>
<body>


	<div id="slideshow">
		<!-- start -->
	 	<div id="foobar">  
			<div id="col1">
				<a href="#" class="previous">&nbsp;</a>
			</div>
			<div id="col2">
				<div class="viewer">
					<div class="reel">
						<div class="slide">
							<img src="/resources/throughout/images/img04.jpg" width="726"
								height="335" alt="" /> <span>Lorem Ipsum Dolor Sit Amet.</span>
						</div>
						<div class="slide">
							<img src="/resources/throughout/images/img07.jpg" width="726"
								height="335" alt="" /> <span>Mauris vitae nisl nec metus
								placerat consectetuer.</span>
						</div>
						<div class="slide">
							<img src="/resources/throughout/images/img08.jpg" width="726"
								height="335" alt="" /> <span>Nam bibendum dadn nulla
								tortor elementum ipsum</span>
						</div>
					</div>
				</div>
			</div>
			<div id="col3">
				<a href="#" class="next">&nbsp;</a>
			</div>
	 	</div>	
 
		<script src="/resources/throughout/jquery/jquery.slidertron-0.1.js"></script>

		<script type="text/javascript">
			$('#foobar').slidertron({
				viewerSelector : '.viewer',
				reelSelector : '.viewer .reel',
				slidesSelector : '.viewer .reel .slide',
				navPreviousSelector : '.previous',
				navNextSelector : '.next',
				navFirstSelector : '.first',
				navLastSelector : '.last'
			});
		</script>
		<!-- end -->
	</div>




	
	<!-- <div id="page"> -->
	<!-- <div id="page-bgtop"> -->
	<!-- 		<div id="content"> -->
	
	<div class="post">
		<!-- <p class="meta"> -->
		<%-- <div id="meta">
			<div class='box-body'>
		<select name="searchType">
			<option value="n"
				<c:out value="${cri.searchType == null?'selected':''}"/>>
				---</option>
			<option value="t"
				<c:out value="${cri.searchType eq 't'?'selected':''}"/>>
				Title</option>
			<option value="c"
				<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
				Content</option>
			<option value="w"
				<c:out value="${cri.searchType eq 'w'?'selected':''}"/>>
				Writer</option>
			<option value="tc"
				<c:out value="${cri.searchType eq 'tc'?'selected':''}"/>>
				Title OR Content</option>
			<option value="cw"
				<c:out value="${cri.searchType eq 'cw'?'selected':''}"/>>
				Content OR Writer</option>
			<option value="tcw"
				<c:out value="${cri.searchType eq 'tcw'?'selected':''}"/>>
				Title OR Content OR Writer</option>
		</select>
	</div>
	
		
	
		
			<div class="search"> 
				<input type="text" name='keyword' id="keywordInput"
					value="${cri.keyword}">
				<button id='searchBtn'>Search</button>
				<button id='newBtn'>New Board</button>
			</div>
		</div> --%>
			<!-- </div> -->
			<!--	<span class="date">Sunday, April 26, 2009</span> 7:27 AM Posted by
						<a href="#">Someone</a>
					</p>
					<h2 class="title">
						<a href="#">Welcome to Throughout </a>
					</h2> -->
			<!-- ///////////////////////////////////////////////////////////////////////////////////////////////////// -->
			<!-- <h1>테스트 중입니다</h1> -->
		<div id = "content">	
			<table class="tbl_board">
				<tr>
					<th style="width: 10%">BNO</th>
					<th style="width: 30%">TITLE</th>
					<th style="width: 20%">WRITER</th>
					<th style="width: 25%">REGDATE</th>
					<th style="width: 15%">VIEWCNT</th>
				</tr>

				<c:forEach items="${list}" var="BoardVO">
				<tr>
					<td>${BoardVO.bno}</td>
					<td><a href="/sboard/read${pageMaker.makeSearch(pageMaker.cri.page)}&bno=${BoardVO.bno}">
					<%-- <td><a href="/sboard/read${pageMaker.makeQuery(pageMaker.cri.page)}&bno=${BoardVO.bno}"> --%>
								${BoardVO.title} <strong>[${BoardVO.replycnt}]</strong>
								</a></td>
					<td>${BoardVO.writer}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${BoardVO.regdate}" /></td>
					<td><span class="badge bg-red">${BoardVO.viewcnt}</span>
				</tr>
				</c:forEach>

				
				<tr>
					<td colspan="5">
						<div class="text-center">
							<ul class="pagination">
								
								<c:if test="${pageMaker.prev}">
									<li><a href="/sboard/list${pageMaker.makeSearch(pageMaker.startPage - 1)}">&laquo;</a></li>
									<%-- <li><a href="/sboard/list${pageMaker.makeQuery(pageMaker.startPage - 1)}">&laquo;</a></li> --%>
								</c:if>

								<%-- 		<c:forEach items="${listall}" var="BoardVO"> --%>
								<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
								<li
									<c:out value="${pageMaker.cri.page == idx?'class=active':' '}"/>>
										<a href="/sboard/list${pageMaker.makeSearch(idx)}">${idx} </a>
										<%-- <a href="/sboard/list${pageMaker.makeQuery(idx)}">${idx} </a> --%>
								</li>									
								</c:forEach>

								<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
									<li><a href="/sboard/list${pageMaker.makeSearch(pageMaker.endPage +1)}">&raquo;</a></li>
									<%-- <li><a href="/sboard/list${pageMaker.makeQuery(pageMaker.endPage +1)}">&raquo;</a></li> --%>
								</c:if>
								<%--  </c:forEach>  --%>
							</ul>
						</div>
					</td>
				</tr>
			
			
			<tr>
				<td colspan="5">
					<div id="meta">
						<div class='box-body'>
							<select name="searchType">
								<option value="n"
									<c:out value="${cri.searchType == null?'selected':''}"/>>
							 ---</option>
								<option value="t"
									<c:out value="${cri.searchType eq 't'?'selected':''}"/>>
							Title</option>
								<option value="c"
								<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
							Content</option>
								<option value="w"
								<c:out value="${cri.searchType eq 'w'?'selected':''}"/>>
							Writer</option>
								<option value="tc"
								<c:out value="${cri.searchType eq 'tc'?'selected':''}"/>>
							Title OR Content</option>
								<option value="cw"
								<c:out value="${cri.searchType eq 'cw'?'selected':''}"/>>
							Content OR Writer</option>
								<option value="tcw"
								<c:out value="${cri.searchType eq 'tcw'?'selected':''}"/>>
							Title OR Content OR Writer</option>
							</select>
						</div>
	
			<div class="search"> <!-- 있어야 하는가??? 없애면 어떨까??? -->
				<input type="text" name='keyword' id="keywordInput"
					value="${cri.keyword}">
				<button id='searchBtn'>Search</button>
				<button id='newBtn'>New Board</button>
			</div>
		</div> 
			
			
			
			
			</tr>
			
			</table>
		</div>

			<!-- /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->


			<!-- <div>
								<a href="#" class="links">View Full Story</a>
							</div> -->


			<!-- <div class="post">
								<p class="meta">
									<span class="date">Sunday, April 26, 2009</span> 7:27 AM Posted
									by <a href="#">Someone</a>
								</p>
								<h2 class="title">
									<a href="#">Lorem ipsum sed aliquam</a>
								</h2>
								<div class="entry">
									<p>
									<img src="/resources/throughout/images/img11.jpg" width="560"
										height="270" alt="" />Donec ipsum. Proin imperdiet est.
									Phasellus <a href="#">dapibus semper urna</a>. Pellentesque
									ornare, orci in consectetuer hendrerit, urna elit eleifend
									nunc, ut consectetuer nisl felis ac diam. Etiam non felis.
										</p>
								</div> -->

			<!-- <div>
						<a href="#" class="links">View Full Story</a>
					</div> -->

			<!-- </div> -->
			<!-- end #content -->
			<!-- <div id="sidebar">
								<ul>
									<li>
										<h2>Aliquam tempus</h2>
										<p>Mauris vitae nisl nec metus placerat perdiet est.
											Phasellus dapibus semper urna. Pellentesque ornare, orci in
											consectetuer hendrerit, volutpat.</p>
									</li>
									<li>
										<h2>Pellenteque ornare</h2>
										<ul>
											<li><a href="#">Nec metus sed donec</a></li>
											<li><a href="#">Magna lacus bibendum mauris</a></li>
											<li><a href="#">Velit semper nisi molestie</a></li>
											<li><a href="#">Eget tempor eget nonummy</a></li>
											<li><a href="#">Nec metus sed donec</a></li>
											<li><a href="#">Velit semper nisi molestie</a></li>
											<li><a href="#">Eget tempor eget nonummy</a></li>
											<li><a href="#">Nec metus sed donec</a></li>
										</ul>
									</li>
									<li>
										<h2>Turpis nulla</h2>
										<ul>
											<li><a href="#">Nec metus sed donec</a></li>
											<li><a href="#">Magna lacus bibendum mauris</a></li>
											<li><a href="#">Velit semper nisi molestie</a></li>
											<li><a href="#">Eget tempor eget nonummy</a></li>
											<li><a href="#">Nec metus sed donec</a></li>
											<li><a href="#">Nec metus sed donec</a></li>
											<li><a href="#">Magna lacus bibendum mauris</a></li>
											<li><a href="#">Velit semper nisi molestie</a></li>
											<li><a href="#">Eget tempor eget nonummy</a></li>
											<li><a href="#">Nec metus sed donec</a></li>
										</ul>
									</li>
								</ul>
							</div> -->
			<!-- end #sidebar -->
			<div style="clear: both;">&nbsp;</div>
	
	</div>
	<!-- end #page -->

	
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
  			integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  			crossorigin="anonymous"></script>
	
	<script>
		$(document).ready(function(){
			$('#searchBtn').on("click",function(event) {
				/* alert("AAAA"); */
				var obj = $("#keywordInput");
				console.log(obj.html());
				alert(obj.val());
			
				self.location = "/sboard/list"
					+"?page=1"
					/* + '${pageMaker.makeQuery(1)} */
					+ "&searchType="
					+ $("select option:selected").val()
					+ "&keyword=" + encodeURIComponent($('#keywordInput').val());
				});
				
			$('#newBtn').on("click", function(evt) {
				self.location = "/sboard/register";
				});
			});
	</script>

	<script>
		var result = '${msg}';

		if (result == 'SUCCESS') {
			alert("처리가 완료되었습니다.");
		}
	</script>


</body>
</html>