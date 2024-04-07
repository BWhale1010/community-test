<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>


<div class="container">
	<button class="btn btn-secondary" onclick="history.back()">뒤로가기</button>

	<c:if test="${boardDetail.username == userName}">
		<a href="/board/updateForm/${boardDetail.id }" class="btn btn-warning">수정</a>
		<button id="btn-delete" class="btn btn-danger">삭제</button>
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

	<div class="card">
		<form>
			<div class="card-body">
				<textarea id="reply-content" class="form-control" rows="1"></textarea>
			</div>
			<div class="card-footer">


				<c:choose>
					<c:when test="${empty userName }">
						<button type="button" id="btn-reply-save-notLogin" class="btn btn-primary" onclick='alert("로그인이 필요합니다.");'>등록</button>
					</c:when>
					<c:otherwise>
						<button type="button" id="btn-reply-save" class="btn btn-primary">등록</button>
					</c:otherwise>
				</c:choose>
			</div>
		</form>
	</div>

	<br>

	<div class="card">
		<div class="card-header">댓글 리스트</div>
		<ul id="Reply-box" class="list-group">
			<c:forEach var="reply" items="${reply }">

				<li id="Reply-${reply.id }"
					class="list-group-item d-flex justify-content-between">
					<div>${reply.content }</div>
					<div class="d-flex">
						<div class="font-italic">작성자 : ${reply.username } &nbsp;</div>
						<c:if test="${reply.username ==  userName_session}">
							<button onclick="index.replyDelete(${reply.id })" class="badge">삭제</button>
						</c:if>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>

</div>





</body>
<script src="/js/board.js"></script>
<%@include file="../layout/footer.jsp"%>