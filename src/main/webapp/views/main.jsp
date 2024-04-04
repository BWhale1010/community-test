<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="layout/header.jsp"%>


	<div class="container">

		<br>
		<hr>

		<div class="card">
			<div class="card-header">
				<h5>조회 수</h5>
			</div>

			<div>
				<ul class="list-group list-group-flush">
					<c:forEach var="boardList" items="${boardList }">
										<li class="list-group-item d-flex justify-content-between">
						<div><a href="#">${boardList.title }</a></div>
						<div class="d-flex font-italic">
							<div>작성자 : ${boardList.username} &nbsp;</div>
							<div>조회수 : ${boardList.count }</div>
						</div>
					</li>
					
					</c:forEach>
				</ul>
			</div>

			<div class="card-footer">Footer</div>
		</div>

		<br>
		<hr>
		<br>

		<div class="card-group">
			<div class="card">
				<div class="card-header">
				<h5>카테고리 최신 글</h5>
				</div>
				
				<ul class="list-group list-group-flush">
				<c:forEach var="boardList" items="${boardList }">
					<li class="list-group-item d-flex justify-content-between">
						<div><a href="#">${boardList.title}</a></div>
						<div class="d-flex font-italic">
							<div>${boardList.username} &nbsp;</div>
							
						</div>
					</li>
					</c:forEach>
					<li class="list-group-item d-flex justify-content-between">
						<div>글 제목2</div>
						<div class="d-flex font-italic">
							<div>작성자 : 000 &nbsp;</div>
							
						</div>
					</li>
					<li class="list-group-item d-flex justify-content-between">
						<div>글 제목3</div>
						<div class="d-flex font-italic">
							<div>작성자 : 000 &nbsp;</div>
							
						</div>
					</li>
				</ul>
			</div>

			<div class="card">
				<div class="card-header">
					<h5>oo 카테고리 최신 글</h5>
				</div>
				<div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item">글 제목1</li>
						<li class="list-group-item">글 제목2</li>
						<li class="list-group-item">글 제목3</li>
					</ul>
				</div>
			</div>
		</div>

	</div>





</body>

<%@include file="layout/footer.jsp"%>