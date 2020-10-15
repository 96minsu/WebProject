<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



<link rel="stylesheet" href="../static/css/style.css">

<link rel="stylesheet"
	href="https://kendo.cdn.telerik.com/2019.3.917/styles/kendo.default-v2.min.css" />
<script src="https://kendo.cdn.telerik.com/2019.3.917/js/jquery.min.js"></script>
<script
	src="https://kendo.cdn.telerik.com/2019.3.917/js/kendo.all.min.js"></script>

<style>
html {
	font-size: 14px;
	font-family: Arial, Helvetica, sans-serif;
}
</style>
<title></title>

<style>

form {
	margin: 0 auto;
	width: 250px;
}
</style>
</head>
<body>
	
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
	
	
	<div class="form-group justify-content-center" tex-align:center
		id="addDiv"></div>
	<div class="form-group justify-content-center" tex-align:center
		id="updateDiv"></div>
	
	<br>
	<br>

	<div class="demo-section k-content">
		<h4>DatePicker:</h4>
		<input id="datepicker" value="" title="datepicker"  />
	</div>
	
	<div id="grid" style="width: 1200px;" ></div>
	
	<script type="text/javascript">
		$("#datepicker").kendoDatePicker();	
		
		$("#grid").kendoGrid({
			columns:[{title:"Num", field: "listNum", width: 50},
					 {title:"Name", field: "listName", width: 100},
					 {title:"Date", field: "regDate", width: 900}],
		 	dataSource: {
			 	transport: {
				 	read: function(options) {
					 	$.ajax({
					 		url: "http://localhost:8080/json",
							dataType: "json",
							type: "GET",
							success: function(result) {
								options.success(result);
							},
							error: function(result) {
								options.error(result);
							}	
						 })
					}
				},
			 	pageSize: 10
			},
			height: 400,
			scrollable: true,
			pageable: {
	             refresh: true,
	             pageSizes: true,
	             buttonCount: 5
	        },
			sortable: {
				mode: "multiple"
			},
			groupable: true
		});
	</script>
	<script type="text/javascript">

	</script>
</div>
	<!--
  	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  	<link rel="stylesheet" href="/resources/demos/style.css">
  	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  	
	<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	-->
	<script src="<c:url value="../static/js/script.js"/>"></script>
</body>
</html>