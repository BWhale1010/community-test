<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="layout/header.jsp"%>


<div class="container">

	<br>

	<div class="card">
		<div class="card-header">
			<h5>최신 순</h5>
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

		<div class="card-footer">
			<ul class="pagination justify-content-center" id="pagination"></ul>
		</div>

	</div>

	<br>
	<hr>
	<br>

	<div class="card">
		<div class="card-header">
			<h5>최신 순</h5>
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

		<div class="card-footer">
			<ul class="pagination justify-content-center" id="pagination"></ul>
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
<script src="/js/board.js"></script>
<%@include file="layout/footer.jsp"%>