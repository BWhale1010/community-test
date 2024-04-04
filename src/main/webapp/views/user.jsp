<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="layout/header.jsp"%>

<body>
	<h3>test Jsp Page</h3>

	<h4>Test User List</h4>
	<table>
		<tr>
			<th>id</th>
			<th>username</th>
			<th>email</th>
			<th>password</th>
			<th>role</th>
			<th>createDate</th>
		</tr>
		<c:forEach items="${userList }" var="userList">
		<tr>			
			<td>${userList.id }</td>
			<td>${userList.username }</td>
			<td>${userList.email }</td>
			<td>${userList.password }</td>
			<td>${userList.role }</td>
			<td>${userList.createDate }</td>
			<td>${userList.oauth}</td>
		</tr>
		</c:forEach>
	</table>


</body>

<%@include file="layout/footer.jsp"%>