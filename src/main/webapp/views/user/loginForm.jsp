<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>

<div class="container">
	<h2>로그인</h2>
	<form action="/login" method="POST">

		<div class="form-group">
			<label for="username">Username</label> 
			<input type="text"  class="form-control" placeholder="Enter Username" name="username"  id="username">
		</div>

		<div class="form-group">
			<label for="pwd">Password</label> 
			<input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
		</div>

		<button id="btn-login" class="btn btn-primary">로그인</button>
<!-- 		<a href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=ab572190a5b27f145a1ba843b1991053&redirect_uri=http://localhost:8000/auth/kakao/callback"><img height="38px" src="/image/kakao_login_button.png"></a> -->
	</form>

</div>


</body>
<script>
var msg = "${msg}"
if(msg != ""){
	alert(msg);
}
</script>

<%@include file="../layout/footer.jsp"%>