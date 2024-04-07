<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>


<div class="container">
	<button class="btn btn-secondary" onclick="history.back()">뒤로가기</button>

	<c:if test="${boardDetail.username == userName}">
		<a href="/board/updateForm/${boardDetail.id }" class="btn btn-warning">수정</a>
		<button id="btn-delete" class="btn btn-danger" >삭제</button>
	</c:if>

	<br> <br>
	<div>
		글 번호 : <span id="id"><i>${boardDetail.id } </i></span> 작성자 : <span><i>${boardDetail.username }
		</i></span>
	</div>
	<br>
	<div>
		<h3>${boardDetail.title }</h3>
	</div>

	<hr>

	<div>
		<div>${boardDetail.content}</div>
	</div>
	<hr>
	
	

</div>





</body>
<script src="/js/board.js"></script>
<%@include file="../layout/footer.jsp"%>