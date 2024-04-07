<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>

<div class="container">
	<h2>회원가입</h2>
		<form>

		<div class="form-group">
			<label for="username">Username</label> <input type="email"
				class="form-control" placeholder="Enter Username" name="text"
				id="username" value="${user.username }" readonly="readonly">
		</div>

		<div class="form-group">
			<label for="email">Email address</label> <input type="email"
				class="form-control" id="email" placeholder="Enter email"
				name="email" value="${user.email }">
		</div>

		<div class="form-group">
			<label for="pwd">Password</label> <input type="password"
				class="form-control" id="password" placeholder="Enter password"
				name="password" >
		</div>

	</form>

	<button id="btn-user" class="btn btn-primary">수정하기</button>


</div>


</body>
<script src="/js/user.js"></script>
<%@include file="../layout/footer.jsp"%>
