<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h4>데이터 추가</h4>
<hr>
<form action="/add" method="post" enctype="multipart/form-data">
	<input type="number" name="listNum" placeholder="number"> 
	<input type="text" name="listName" placeholder="name">
	<input type="file" name="files">
	<button type="submit" class="btn btn-danger" id="saveButton">추가하기</button>
</form>

<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
