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
<link rel="stylesheet" href="../static/css/style.css">
<style>
h4 {
	text-align: center;
}

form {
	margin: 0 auto;
	width: 250px;
}
</style>
</head>
<body>
	<c:url var="index2" value="/index2"></c:url>
	<script>
		$(document).on('click', '#btnSearch', function(e) {

			e.preventDefault();

			var url = "${index2}";

			url = url + "?searchType=" + $('#searchType').val();

			url = url + "&keyword=" + $('#keyword').val();

			location.href = url;

			console.log(url);

		});
	</script>
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

	<table class="tbl paginated" id="tbl"></table>

	<!-- search{s} -->

	<div class="form-group row justify-content-center">

		<div class="w100" style="padding-right: 10px">

			<select class="form-control form-control-sm" name="searchType"
				id="searchType">

				<option value="title">제목</option>

				<option value="Content">본문</option>

				<option value="reg_id">작성자</option>

			</select>

		</div>

		<div class="w300" style="padding-right: 10px">

			<input type="text" class="form-control form-control-sm"
				name="keyword" id="keyword">

		</div>

		<div>

			<button class="btn btn-sm btn-primary" name="btnSearch"
				id="btnSearch">검색</button>

		</div>

	</div>

	<!-- search{e} -->





	<!-- pagination{s} 

	<div id="paginationBox">

		<ul class="pagination">

			<c:if test="${pagination.prev}">

				<li class="page-item"><a class="page-link" href="#"
					onClick="idx">Previous</a></li>
			</c:if>



			<c:forEach begin="${pagination.startPage}"
				end="${pagination.endPage}" var="idx">

				<li
					class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> "><a
					class="page-link" href="#"
					onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')">
						${idx} </a></li>

			</c:forEach>



			<c:if test="${pagination.next}">

				<li class="page-item"><a class="page-link" href="#"
					onClick="fn_next('${pagination.range}', '${pagination.range}', '${pagination.rangeSize}')">Next</a></li>

			</c:if>

		</ul>

	</div>

	<!-- pagination{e} 



	<script>
		//이전 버튼 이벤트

		function fn_prev(page, range, rangeSize) {

			var page = ((range - 2) * rangeSize) + 1;

			var range = range - 1;

			var url = "${pageContext.request.contextPath}/index2";

			url = url + "?page=" + page;

			url = url + "&range=" + range;

			location.href = url;

		}

		//페이지 번호 클릭

		function fn_pagination(page, range, rangeSize, searchType, keyword) {

			var url = "${pageContext.request.contextPath}/index2";

			url = url + "?page=" + page;

			url = url + "&range=" + range;

			location.href = url;

		}

		//다음 버튼 이벤트

		function fn_next(page, range, rangeSize) {

			var page = parseInt((range * rangeSize)) + 1;

			var range = parseInt(range) + 1;

			var url = "${pageContext.request.contextPath}/index2";

			url = url + "?page=" + page;

			url = url + "&range=" + range;

			location.href = url;

		}
	</script>
-->

	<div class="form-group justify-content-center" tex-align:center
		id="addDiv"></div>
	<div class="form-group justify-content-center" tex-align:center
		id="updateDiv"></div>


	<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>


	<script src="<c:url value="../static/js/script.js"/>"></script>
</body>
</html>