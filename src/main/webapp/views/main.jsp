<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="layout/header.jsp"%>


<div class="container">

	<br>

	<div class="card">
		<div class="card-header">
			<h5>자유게시판 인기글</h5>
		</div>

		<div>
			<ul class="list-group list-group-flush">

				<c:forEach var="boardList" items="${boardList }">
					<li class="list-group-item d-flex justify-content-between">
						<div>
							<a href="/board/detail/${boardList.id }">${boardList.title }</a>
						</div>
						<div class="d-flex font-italic">
							<div>작성자 : ${boardList.username} &nbsp;</div>
							<div>조회수 : ${boardList.count }</div>
						</div>
					</li>

				</c:forEach>
			</ul>
		
		</div>

	</div>

	<br>
	<hr>
	<br>

	<div class="card">
		<div class="card-header">
			<h5>인기글</h5>
		</div>

		<div>
			<ul class="list-group list-group-flush">
				<c:forEach var="boardList" items="${boardList }">
					<li class="list-group-item d-flex justify-content-between">
						<div>
							<a href="#">${boardList.title }</a>
						</div>
						<div class="d-flex font-italic">
							<div>작성자 : ${boardList.username} &nbsp;</div>
							<div>조회수 : ${boardList.count }</div>
						</div>
					</li>

				</c:forEach>
			</ul>
		</div>

	</div>



</div>





</body>
<script>
	var msg = "${msg}"
	if (msg != "") {
		alert(msg);
	}
</script>
<%@include file="layout/footer.jsp"%>