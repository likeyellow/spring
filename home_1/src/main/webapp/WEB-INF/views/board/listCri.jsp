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


<script src="jquery-3.3.1.min.js"></script>
<!-- <style type="text/css"> 이렇게 쓰면 error 발생-->

<style>
.tbl_board {
	/* position: absolute;
	top: 165px;
	left: 171px; 
	float : center;  */
	background-position: center;
	background-color: black;
	font-family: Arial, Helvetica, sans-serif;
	text-align: justify;
	border: 2px double grey;
	border-radius: 15px;
	margin: 15px auto;
	padding: 10px 40px 50px 40px;
	width: 940px;
	height: 440px;
}

.tbl_board tr {
	/* position: relative; */
	text-align: center;
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
}
</style>
<title>ListALL Page Test</title>
</head>
<body>
	<!-- <h1>테스트 중입니다</h1> -->
	<table class="tbl_board">
		<tr>
			<th style="width: 10%">BNO</th>
			<th style="width: 30%">TITLE</th>
			<th style="width: 20%">WRITER</th>
			<th style="width: 30%">REGDATE</th>
			<th style="width: 10%">VIEWCNT</th>
		</tr>

		<c:forEach items="${listall}" var="BoardVO">

			<tr>
				<td>${BoardVO.bno}</td>
				<%-- <td><a href="/board/read${pageMaker.makeQuery(pageMaker.cri.page)}&bno=${BoardVO.bno}"> --%>
				<%-- <td><a href="/board/read${pageMaker.makeQuery(pageMaker.cri.page)}&bno=${BoardVO.bno}"> --%>
				<td><a href="/board/read?bno=${BoardVO.bno}">${BoardVO.title}</a></td>
				<td>${BoardVO.writer}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
						value="${BoardVO.regdate}" /></td>
				<td><span class="badge bg-red">${BoardVO.viewcnt}</span>
		</c:forEach>
		</tr>


		<tr>
			<td colspan="5">
				<div class="text-center">
					<ul class="pagination">

						<c:if test="${pageMaker.prev}">
							<%-- <li><a href="listCri${pageMaker.makeQuery(pageMaker.startPage -1) }">&laquo;</a> --%>
							<li><a href="listCri?page=${pageMaker.startPage -1 }">&laquo;</a></li>
						</c:if>
						
				<%-- 		<c:forEach items="${listall}" var="BoardVO"> --%>
						<c:forEach begin="${pageMaker.startPage}"
							end="${pageMaker.endPage}" var="idx">
							
								<li
									<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
									<%-- <a href="listCri${pageMaker.makeQuery(idx)}">${idx}</a> --%>
									<a href="listCri?page=${idx}">${idx}</a>
								</li>
						</c:forEach>

							<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								<%-- <li><a href="listCri${pageMaker.makeQuery(pageMaker.endPage +1)}">&raquo;</a> --%>
								<li><a href="listCri?page=${pageMaker.endPage +1}">&raquo;</a>
								</li>
							</c:if>
						<%--  </c:forEach>  --%>
					</ul>
				</div>
			</td>
		</tr>


		<!-- <tr> 
			<div class="text-center"> 
			<ul class="pagination">
					<li>&laquo;</li>
					<li>.........</li>
					<li>&raquo;</li>
			 	</ul> 
		 	</div> 
		</tr> -->
	</table>

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
	<div id="page">
		<div id="page-bgtop">
			<div id="content">
				<div class="post">
					<p class="meta">
						<span class="date">Sunday, April 26, 2009</span> 7:27 AM Posted by
						<a href="#">Someone</a>
					</p>
					<h2 class="title">
						<a href="#">Welcome to Throughout </a>
					</h2>
					<div class="entry">
						<p>
							This is <strong>Throughout </strong>, a free, fully
							standards-compliant CSS template designed by <a
								href="http://templated.co" rel="nofollow">TEMPLATED</a>. The
							slideshow uses photos from <a href="http://www.pdphoto.org">PDPhoto.org</a>
							and is powered by Slidertron (a jQuery plugin by <a
								href="http://n33.co/">n33</a>). This free template is released
							under the <a href="http://templated.co/license">Creative
								Commons Attribution</a> license, so you’re pretty much free to do
							whatever you want with it (even use it commercially) provided you
							keep the links in the footer intact. Have fun :)
						</p>
					</div>
					<div>
						<a href="#" class="links">View Full Story</a>
					</div>
				</div>
				<div class="post">
					<p class="meta">
						<span class="date">Sunday, April 26, 2009</span> 7:27 AM Posted by
						<a href="#">Someone</a>
					</p>
					<h2 class="title">
						<a href="#">Lorem ipsum sed aliquam</a>
					</h2>
					<div class="entry">
						<p>
							<img src="/resources/throughout/images/img11.jpg" width="560"
								height="270" alt="" />Donec ipsum. Proin imperdiet est.
							Phasellus <a href="#">dapibus semper urna</a>. Pellentesque
							ornare, orci in consectetuer hendrerit, urna elit eleifend nunc,
							ut consectetuer nisl felis ac diam. Etiam non felis.
						</p>
					</div>
					<div>
						<a href="#" class="links">View Full Story</a>
					</div>
				</div>
			</div>
			<!-- end #content -->
			<div id="sidebar">
				<ul>
					<li>
						<h2>Aliquam tempus</h2>
						<p>Mauris vitae nisl nec metus placerat perdiet est. Phasellus
							dapibus semper urna. Pellentesque ornare, orci in consectetuer
							hendrerit, volutpat.</p>
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
			</div>
			<!-- end #sidebar -->
			<div style="clear: both;">&nbsp;</div>
		</div>
		<!-- end #page -->
	</div>


	<script>
		var result = '${msg}';

		if (result == 'SUCCESS') {
			alert("처리가 완료되었습니다.");
		}
	</script>

	<%@ include file="../include/footer.jsp"%>

</body>
</html>