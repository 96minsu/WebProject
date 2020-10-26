<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://kendo.cdn.telerik.com/2020.3.915/styles/kendo.default-v2.min.css" />


<link rel="stylesheet"
	href="https://kendo.cdn.telerik.com/2020.3.915/styles/kendo.default-v2.min.css" />

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script
	src="https://kendo.cdn.telerik.com/2020.3.915/js/kendo.all.min.js"></script>
	
<script src="https://code.highcharts.com/highcharts.js"></script>
<title></title>

<style>
form {
	margin: 0 auto;
	width: 250px;
}
</style>
</head>
<body>
	<div id="container" style="width:550px; height:400px; margin: 0 auto"></div>

	현재 접속한 계정은 ${id}입니다.
	<div id="grid" style="width: 1200px;"></div>

	<div class="form-group justify-content-center" tex-align:center
		id="detailDiv"></div>
	

<!-- 	<div class="demo-section k-content">
		<input name="files" id="files" type="file" />


		<script>
     
            $("#files").kendoUpload({
                async: {
                    saveUrl: "/save",
                    removeUrl: "/remove",
                    autoUpload: true
                }
            });
       
    	</script>
	</div>
 -->


	<textarea id="editor" style="width: 1200px;"></textarea>

	<br>
	<br>

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

	


	<div class="form-group justify-content-center" tex-align:center
		id="addDiv"></div>
	<div class="form-group justify-content-center" tex-align:center
		id="updateDiv"></div>

	</div>
	<script type="text/javascript">
		
	</script>



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