<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://kendo.cdn.telerik.com/2019.3.917/styles/kendo.default-v2.min.css" />
<script src="https://kendo.cdn.telerik.com/2019.3.917/js/jquery.min.js"></script>
<script
	src="https://kendo.cdn.telerik.com/2019.3.917/js/kendo.all.min.js"></script>
</head>
<body>
	<div class="main">
		<div class="header">
			<h1>KENDO GRID TEST</h1>
		</div>

		<div id="grid" style="width: 1200px;" ></div>
	</div>

	<script type="text/javascript">
	$(function() {		
		$("#grid").kendoGrid({
			columns:[{title:"Num", field: "listNum", width: 50},
					 {title:"Name", field: "listName", width: 1000}],
		 	dataSource: {
			 	transport: {
				 	read: {
				 		url: "http://localhost:8080/jsonData",
						dataType: "json",
						type: "GET"
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
	});
	
	</script>

</body>
</html>