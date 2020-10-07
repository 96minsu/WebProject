<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">
<link rel="stylesheet"
	href="webjars/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<!--<c:url var="getBoardListURL" value="/index2"></c:url>-->
	
	<div class="form-group row justify-content-center">
		현재 접속한 계정은 ${id}입니다.
		<button id="addButton" class="btn btn-primary">추가</button>
		<input type="button" value="로그아웃" class="btn btn-info"
			onclick="location.href='logout'">
	</div>
	<div class="form-group row justify-content-center">
		<table id="table" class="tbl paginated" style="width: 300px;">
			<thead class="thead-dark">
				<tr>
					<th>num</th>
					<th>name</th>
					<th>action</th>
				</tr>
			</thead>
			<tbody id="tbody"></tbody>

		</table>
	</div>
	
	<table class="tbl paginated" id="tbl">
	</table>

	<div id="addDiv"></div>
	<div id="updateDiv"></div>

	<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>


	<script src="<c:url value="../static/js/script.js"/>"></script>
</body>
</html>