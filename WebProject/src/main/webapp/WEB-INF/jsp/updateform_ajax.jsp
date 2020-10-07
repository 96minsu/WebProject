<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h1>데이터 수정</h1>
	<form action="/update" method="post">
		<input type="number" name="listNum" placeholder="number" value="${lists.listNum}">	
		<input type="text" name="listName" placeholder="name" value="${lists.listName}">
		<button type="submit" class="btn btn-danger">수정</button>
	</form>

	<button type="submit" class="btn btn-link"><a href="/index2">끄기</a></button>
	
<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>