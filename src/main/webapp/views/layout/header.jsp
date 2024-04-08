<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Community</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-expand-sm bg-light navbar-light">
		<a class="navbar-brand" href="/">Community Home</a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse ml-5" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link text-dark" href="/bdListForm_1">게시판</a></li>
				</ul>
		</div>
		
			<div class="collapse navbar-collapse justify-content-end"
				id="collapsibleNavbar">
				<ul class="navbar-nav">
					<c:choose>
						<c:when test="${empty sessionScope.userName }">
							<li class="nav-item"><a class="nav-link" href="/loginForm">로그인</a></li>
							<li class="nav-item"><a class="nav-link" href="/joinForm">회원가입</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item float-left"><a class="nav-link"  href="/login/logout">로그아웃</a></li>
							<li class="nav-item float-left"><a class="nav-link" href="/user">회원정보</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>


	</nav>

	<br>
	<c:set var="userName" value="<%=(String)session.getAttribute(\"userName\")%>"></c:set>
		