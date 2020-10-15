<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<base href="https://demos.telerik.com/kendo-ui/grid/from-table">
<style>
html {
	font-size: 14px;
	font-family: Arial, Helvetica, sans-serif;
}
</style>
<title></title>
<link rel="stylesheet"
	href="https://kendo.cdn.telerik.com/2019.3.917/styles/kendo.default-v2.min.css" />
<script src="https://kendo.cdn.telerik.com/2019.3.917/js/jquery.min.js"></script>
<script
	src="https://kendo.cdn.telerik.com/2019.3.917/js/kendo.all.min.js"></script>

</head>
<body>
	<div id="example">
		<table id="grid">
			
		</table>

		<script>
		
        $(document).ready(function () {
            $("#grid").kendoGrid({
                dataSource: {
                    type: "odata",
                    transport: {
                        read: "https://demos.telerik.com/kendo-ui/service/Northwind.svc/Customers"
                    },
                    pageSize: 20
                },
                height: 550,
                groupable: true,
                sortable: true,
                pageable: {
                    refresh: true,
                    pageSizes: true,
                    buttonCount: 5
                },
                columns: [{
                    
                    field: "ContactName",
                    title: "Contact Name",
                    width: 240
                }, {
                    field: "ContactTitle",
                    title: "Contact Title"
                }, {
                    field: "CompanyName",
                    title: "Company Name"
                }, {
                    field: "Country",
                    width: 1000
                }]
            });
        });
    </script>
		
	</div>






</body>
</html>