<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>


<div class="container">

	<br>


	<div class="card">
		<div class="card-header">
			<h5>조회 순</h5>
		</div>

		<div>
			<ul class="list-group list-group-flush" id="boardList">

			
			</ul>
		</div>

		<div class="card-footer">
			<ul class="pagination justify-content-center" id="pagination"></ul>
		</div>

	</div>

	<br>
	<hr>
	<br>



</div>





</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twbs-pagination/1.4.2/jquery.twbsPagination.min.js"></script>
<script src="/js/board.js"></script>
<%@include file="../layout/footer.jsp"%>